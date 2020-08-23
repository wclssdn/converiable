package converter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 对象之间互相转换工具
 * 使用在class上是为了方便使用
 * 定义在属性上的注解 优先级比class上的优先级高
 *
 * @author nemo <ssdn@vip.qq.com>
 * @link https://github.com/wclssdn/converiable
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Convertibles {

    /**
     * @return 转换描述注解Convertible
     */
    Convertible[] value();
}
