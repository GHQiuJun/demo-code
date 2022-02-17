package demo.project.test.demoprojecttest.service.ServiceImpl.vadidator.validate;

import com.sun.javafx.binding.StringFormatter;
import demo.project.test.demoprojecttest.entity.InsureValidateReqParamsDTO;
import demo.project.test.demoprojecttest.entity.Response;
import demo.project.test.demoprojecttest.entity.ValidateResDTO;
import demo.project.test.demoprojecttest.service.AbstractValidatorService;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: ProductRuleValidator
 * @description: 产品规则校验器
 * <p>
 * 校验规则描述：
 * 1、产品及计划是否上线
 * 2、产品是否支持该接口
 * 3、生效时间、失效时间
 * @author: 60007949
 * @create: 2022-01-13 12:37
 **/
@Slf4j
public class ProductRuleValidator extends AbstractValidatorService {


    @Override
    protected ValidateResDTO validate(InsureValidateReqParamsDTO validateReqParamsDTO) {
        log.info("产品规则校验-----");

        final InsureValidateReqParamsDTO.Product product = validateReqParamsDTO.getProduct();
        if (product == null || !product.isOnline()) {
            return new ValidateResDTO(false, Response.formatResponse(Response.PRODUCT_RULE_VALIDATE_FALSE, "产品已下架"));
        }
        final InsureValidateReqParamsDTO.Policy policy = validateReqParamsDTO.getPolicy();
        return new ValidateResDTO(true);
    }
}
