package converter;

/**
 * 没有声明注解的异常
 *
 * @author nemo <ssdn@vip.qq.com>
 * @link https://github.com/wclssdn/converiable
 */
public class NoConvertibleAnnotationException extends Exception {
    public NoConvertibleAnnotationException(String message) {
        super(message);
    }
}
