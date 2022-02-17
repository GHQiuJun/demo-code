package demo.project.test.demoprojecttest.service.ServiceImpl.vadidator.validate;

import demo.project.test.demoprojecttest.entity.InsureValidateReqParamsDTO;
import demo.project.test.demoprojecttest.entity.ValidateResDTO;
import demo.project.test.demoprojecttest.service.AbstractValidatorService;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: AntiMoneyLaunderingValidator
 * @description: 反洗钱校验器
 * @author: 60007949
 * @create: 2022-01-13 12:04
 **/
@Slf4j
public class AntiMoneyLaunderingValidator extends AbstractValidatorService {
    @Override
    public ValidateResDTO validate(InsureValidateReqParamsDTO validateReqParamsDTO) {
        log.info("反洗钱校验------");
        return new ValidateResDTO(true);
    }
}
