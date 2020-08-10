package converter;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 基于注解的对象转换工具
 *
 * @author nemo <ssdn@vip.qq.com>
 * @link https://github.com/wclssdn/converiable
 */
public class Converter {

    /**
     * 将源对象的属性拷贝到目标对象
     *
     * @param source   源对象（不改变）
     * @param target   目标对象（会变更）
     * @param <SOURCE> 源对象类型
     * @param <TARGET> 目标对象类型
     * @throws NoConvertibleAnnotationException 源对象类型未正确设置@Convertible注解
     * @throws NoConvertibleTargetException     源对象类型未正确设置targets属性
     */
    public static <SOURCE, TARGET> void convert(SOURCE source, TARGET target) throws NoConvertibleAnnotationException, NoConvertibleTargetException {
        Class<?> sourceClass = source.getClass();
        Class<?> targetClass = target.getClass();
        Convertible[] convertibles = getAnnotationsFromElement(sourceClass);
        if (convertibles.length == 0) {
            throw new NoConvertibleAnnotationException("Source " + sourceClass.toString() + " can't be convert. Use @" + Convertible.class + " to enable convert ability.");
        }

        Convertible convertible = chooseClassAnnotation(convertibles, targetClass);
        if (convertible == null) {
            throw new NoConvertibleTargetException("Source " + sourceClass.toString() + " can't be convert to " + targetClass.toString() + ".");
        }
        Field[] sourceClassFields = sourceClass.getDeclaredFields();
        for (Field field : sourceClassFields) {
            Convertible fieldConvertible = chooseFieldAnnotation(getAnnotationsFromElement(field), targetClass);
            String getterMethodName = generateGetterMethodName(field.getName());
            if (fieldConvertible != null && fieldConvertible.getter().length() > 0) {
                getterMethodName = fieldConvertible.getter();
            }
            try {
                Method getterMethod = sourceClass.getMethod(getterMethodName);
                Object sourceFieldValue = getterMethod.invoke(source);

                String targetFieldName = field.getName();
                String setterMethodName = generateSetterMethodName(targetFieldName);

                Class<?> targetFieldType = field.getType();
                Method setterMethod = null;
                try {
                    setterMethod = targetClass.getMethod(setterMethodName, targetFieldType);
                } catch (NoSuchMethodException ignored) {
                }
                if (fieldConvertible != null) {
                    if (fieldConvertible.setter().length() > 0) {
                        setterMethodName = fieldConvertible.setter();
                        try {
                            setterMethod = targetClass.getMethod(setterMethodName, targetFieldType);
                        } catch (NoSuchMethodException ignored) {
                        }
                    } else if (fieldConvertible.field().length() > 0) {
                        targetFieldName = fieldConvertible.field();
                        setterMethodName = generateSetterMethodName(targetFieldName);
                    }
                    try {
                        setterMethod = targetClass.getMethod(setterMethodName, targetFieldType);
                    } catch (Exception ignored) {
                    }
                    if (setterMethod == null) {
                        targetFieldType = fieldConvertible.target();
                        try {
                            setterMethod = targetClass.getMethod(setterMethodName, targetFieldType);
                        } catch (Exception ignored) {
                        }
                    }

                }

                Object targetFieldObject = sourceFieldValue;
                if (field.getType() != targetFieldType) {
                    targetFieldObject = targetFieldType.newInstance();
                    convert(sourceFieldValue, targetFieldObject);
                }
                if (setterMethod != null) {
                    setterMethod.invoke(target, targetFieldObject);
                }
            } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException ignored) {
            }
        }

    }

    /**
     * 获取注解数组
     *
     * @param element 可获取注解的元素
     * @param <T>     可获得注解的类型：类、属性
     * @return 注解数组
     */
    private static <T extends AnnotatedElement> Convertible[] getAnnotationsFromElement(T element) {
        Convertible[] fieldConvertibles = {};
        Convertibles fieldConvertiblesAnnotation = element.getAnnotation(Convertibles.class);
        Convertible fieldConvertible = element.getAnnotation(Convertible.class);
        if (fieldConvertiblesAnnotation != null) {
            fieldConvertibles = fieldConvertiblesAnnotation.value();
        } else if (fieldConvertible != null) {
            fieldConvertibles = new Convertible[1];
            fieldConvertibles[0] = fieldConvertible;
        }
        return fieldConvertibles;
    }

    /**
     * 如果存在多个Convertible注解，则根据when属性决定使用哪个注解
     *
     * @param convertibles 属性上的所有注解
     * @param targetClass  属性所属类，即将转换为的类型
     * @return 通过when()选择的注解
     */
    private static Convertible chooseFieldAnnotation(Convertible[] convertibles, Class<?> targetClass) {
        for (Convertible convertible : convertibles) {
            if (convertible.when() == targetClass) {
                return convertible;
            }
        }
        return null;
    }

    /**
     * 如果存在多个Convertible注解，则根据target属性决定使用哪个注解
     *
     * @param convertibles 类上的所有注解
     * @param targetClass  即将转换为的类型
     * @return 通过target()选择的注解
     */
    private static Convertible chooseClassAnnotation(Convertible[] convertibles, Class<?> targetClass) {
        for (Convertible convertible : convertibles) {
            if (convertible.target() == targetClass) {
                return convertible;
            }
        }
        return null;
    }

    private static String generateGetterMethodName(String fieldName) {
        return "get" + toUpperCaseFirstOne(fieldName);
    }

    private static String generateSetterMethodName(String fieldName) {
        return "set" + toUpperCaseFirstOne(fieldName);
    }

    private static String toUpperCaseFirstOne(String s) {
        // Abc/aBc
        if (Character.isUpperCase(s.charAt(0))) {
            return s;
        } else if (s.length() > 1 && Character.isUpperCase(s.charAt(1))) {
            return s;
        } else {
            return Character.toUpperCase(s.charAt(0)) + s.substring(1);
        }
    }
}
