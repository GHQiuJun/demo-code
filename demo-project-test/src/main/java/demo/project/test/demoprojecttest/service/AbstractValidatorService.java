package demo.project.test.demoprojecttest.service;

import com.sun.javafx.binding.StringFormatter;
import demo.project.test.demoprojecttest.entity.InsureValidateReqParamsDTO;
import demo.project.test.demoprojecttest.entity.Response;
import demo.project.test.demoprojecttest.entity.ValidateResDTO;

/**
 * @program: ValidateService
 * @description: 核保规则校验器接口
 * @author: 60007949
 * @create: 2022-01-13 11:48
 **/
public abstract class AbstractValidatorService {

    protected Response response;

    /**
     * 下一个规则校验逻辑
     */
    private AbstractValidatorService nextAbstractValidatorService;

    /**
     * build validate chain
     *
     * @param nextAbstractValidatorService 下一个校验器
     * @return
     */
    public AbstractValidatorService linkWith(AbstractValidatorService nextAbstractValidatorService) {
        this.nextAbstractValidatorService = nextAbstractValidatorService;
        return nextAbstractValidatorService;
    }

    /**
     * 核心校验逻辑
     *
     * @return boolean
     */
    protected ValidateResDTO validate(InsureValidateReqParamsDTO validateReqParamsDTO) {
        return new ValidateResDTO(true);
    }

    /**
     * 开始校验
     *
     * @param validateReqParamsDTO 校验参数
     * @return boolean
     */
    public ValidateResDTO startValidate(InsureValidateReqParamsDTO validateReqParamsDTO) {
        if (isSupported()) {
            final ValidateResDTO validateResDTO = validate(validateReqParamsDTO);
            if (!validateResDTO.getValidateRes()) {
                response = validateResDTO.getResponse();
                return validateResDTO;
            }
        }
        return nextValidate(validateReqParamsDTO);
    }

    /**
     * 校验校验器是否支持
     *
     * @return
     */
    protected boolean isSupported() {
        return true;
    }

    /**
     * 进行链式检验
     *
     * @param validateReqParamsDTO 校验数据
     * @return boolean
     */
    private ValidateResDTO nextValidate(InsureValidateReqParamsDTO validateReqParamsDTO) {
        if (nextAbstractValidatorService == null) {
            return new ValidateResDTO(true);
        }
        return this.nextAbstractValidatorService.startValidate(validateReqParamsDTO);
    }
}
