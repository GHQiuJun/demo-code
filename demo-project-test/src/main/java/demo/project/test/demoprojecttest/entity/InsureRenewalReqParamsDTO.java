package demo.project.test.demoprojecttest.entity;

import lombok.Data;

/**
 * @program: InsureRenewalReqParam
 * @description: 续期请求保司统一参数
 * @author: 60007949
 * @create: 2022-01-12 17:20
 **/
@Data
public class InsureRenewalReqParamsDTO {

    /**
     * 保单号
     */
    private String policyNo;

    private String renewalNo;

    private String payMethod;

    private String payNo;

    private String payDate;
}
