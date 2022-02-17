package demo.project.test.demoprojecttest.entity;

import lombok.Data;

/**
 * @program: ValidateResDTO
 * @description: 规则校验器响应对象
 * @author: 60007949
 * @create: 2022-01-13 19:21
 **/
@Data
public class ValidateResDTO {
    Boolean validateRes;
    Response response;

    public ValidateResDTO(Boolean validateRes, Response response) {
        this.validateRes = validateRes;
        this.response = response;
    }

    public ValidateResDTO(Boolean validateRes) {
        this.validateRes = validateRes;
    }
}
