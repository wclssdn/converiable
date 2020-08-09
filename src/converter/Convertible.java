package converter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

/**
 * 对象之间互相转换工具
 * 使用在class上是为了方便使用
 * 定义在属性上的注解 优先级比class上的优先级高
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Convertible {

    /**
     * @return 可转换为什么类
     */
    Class<?>[] targets() default {};

    /**
     * @return 转换到的目标类属性名称
     */
    String field() default "";

    /**
     * @return 源对象属性的getter方法名（如果不指定，则通过源属性名进行推导）
     */
    String getter() default "";

    /**
     * @return 目标字段的setter函数名（如果不指定，则优先通过field推导，如为提供，则按源field推导）
     */
    String setter() default "";
}
