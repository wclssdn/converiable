package converter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
        Convertible convertible = sourceClass.getAnnotation(Convertible.class);
        if (convertible == null) {
            throw new NoConvertibleAnnotationException("Source " + sourceClass.toString() + " can't be convert. Use @" + Convertible.class + " to enable convert ability.");
        }
        Class<?>[] targets = convertible.targets();
        boolean hasTarget = false;
        for (Class<?> x : targets) {
            if (x == targetClass) {
                hasTarget = true;
                break;
            }
        }
        if (!hasTarget) {
            throw new NoConvertibleTargetException("Source " + sourceClass.toString() + " can't be convert to " + targetClass.toString() + ".");
        }
        Field[] sourceClassFields = sourceClass.getDeclaredFields();
        for (Field field : sourceClassFields) {
            Convertible fieldConvertible = field.getAnnotation(Convertible.class);
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
                        for (Class<?> cls : fieldConvertible.targets()) {
                            targetFieldType = cls;
                            try {
                                setterMethod = targetClass.getMethod(setterMethodName, targetFieldType);
                                break;
                            } catch (Exception ignored) {
                            }
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
