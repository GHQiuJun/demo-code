package demo.project.test.demoprojecttest.entity;

import lombok.Data;

import java.util.Currency;
import java.util.Date;
import java.util.List;

/**
 * @program: InsureValidateRes
 * @description: 两步出单请求保司核保统一请求参数
 * @author: 60007949
 * @create: 2022-01-12 14:31
 **/
@Data
public class InsureValidateReqParamsDTO {


    private Policy policy;

    private Product product;

    /**
     * 是否续保请求
     */
    private Boolean isRenewalPolicy;

    /**
     * 保单信息
     */
    @Data
    public static class Policy {
        /**
         * 产品计划码
         */
        private String planCode;

        /**
         * 出单时间
         */
        private String issueDate;

        /**
         * 生效时间
         */
        private String effectiveDate;
    }

    /**
     * 产品信息
     */
    @Data
    public static class Product {

        /**
         * 虚拟产品编码
         */
        String productCode;

        /**
         * 渠道真实产品编码
         */
        String insureProductCode;

        /**
         * 是否上线
         */
        boolean isOnline;
    }
}
