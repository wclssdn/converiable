package converter;

/**
 * 没有找对对应目标类的异常
 *
 * @author nemo ssdn@vip.qq.com
 * github https://github.com/wclssdn/converiable
 */
public class NoConvertibleTargetException extends Exception {
    public NoConvertibleTargetException(String message) {
        super(message);
    }
}
