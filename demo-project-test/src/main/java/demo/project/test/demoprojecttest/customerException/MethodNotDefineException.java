package demo.project.test.demoprojecttest.customerException;

/**
 * @program: InterfaceNotDefineException
 * @description: 核心方法未实现，不支持该方法
 * @author: 60007949
 * @create: 2022-01-12 14:44
 **/
public class MethodNotDefineException extends BaseException {
    public MethodNotDefineException(String message) {
        super(message);
    }
}
