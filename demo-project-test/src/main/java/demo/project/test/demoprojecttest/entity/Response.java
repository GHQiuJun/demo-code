package demo.project.test.demoprojecttest.entity;

import com.sun.javafx.binding.StringFormatter;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: demo-project-test
 * @description: 系统响应状态码
 * @author: 6007949
 * @create: 2022-01-12 18:00
 **/
public enum Response {
    /**
     * 处理成功
     */
    SUCCESS("0000", "成功"),
    PRODUCT_RULE_VALIDATE_FALSE("0001", "产品规则校验失败：%s");;

    @Getter
    String responseCode;
    @Getter
    @Setter
    String responseMessage;

    Response(String responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    public static Response formatResponse(Response response, String additionalText) {
        response.setResponseMessage(StringFormatter.format(response.getResponseMessage(), additionalText).toString());
        return response;
    }
}
