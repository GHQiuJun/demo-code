package demo.project.test.demoprojecttest.customerException;

import lombok.Data;
import lombok.Getter;

/**
 * @program: InsureBusinessException
 * @description: 保司业务异常
 * @author: 60007949
 * @create: 2022-01-13 10:27
 **/
public class InsureBusinessException extends BaseException {
    @Getter
    String errorCode;
    @Getter
    String errorMessage;

    public InsureBusinessException(String message) {
        super(message);
    }

    public InsureBusinessException(String errorCode, String errorMessage) {
        super("");
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
