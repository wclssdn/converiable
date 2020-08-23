package converter;

import java.lang.annotation.*;

/**
 * 对象之间互相转换工具
 * 使用在class上是为了方便使用
 * 定义在属性上的注解 优先级比class上的优先级高
 *
 * @author nemo ssdn@vip.qq.com
 * github https://github.com/wclssdn/converiable
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Repeatable(Convertibles.class)
public @interface Convertible {

    /**
     * 应用在类上
     * 可转换为哪个目标类必须明确声明
     *
     * @return 转换为哪个目标类
     */
    Class<?> target() default Class.class;

    /**
     * 应用在属性上，当存在多个注解时，根据此值选择生效注解
     * 仅当所属类声明多个可转换的目标类时，选择性使用
     *
     * @return 此注解生效于哪个目标类
     */
    Class<?> when() default Class.class;

    /**
     * 目标类的属性名 默认和源对象一致
     *
     * @return 转换到的目标类属性名称
     */
    String field() default "";

    /**
     * 源对象属性的getter方法名（如果不指定，则通过源属性名进行推导）
     *
     * @return 源对象属性的getter方法名
     */
    String getter() default "";

    /**
     * 目标字段的setter函数名（如果不指定，则优先通过field推导，如为提供，则按源field推导）
     *
     * @return 目标字段的setter函数名
     */
    String setter() default "";
}
