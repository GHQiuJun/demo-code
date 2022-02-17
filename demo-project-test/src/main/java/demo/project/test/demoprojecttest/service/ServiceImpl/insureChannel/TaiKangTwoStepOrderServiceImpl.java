package demo.project.test.demoprojecttest.service.ServiceImpl.insureChannel;

import demo.project.test.demoprojecttest.customerException.MethodNotDefineException;
import demo.project.test.demoprojecttest.entity.*;
import demo.project.test.demoprojecttest.service.AbstractInsureTwoStepOrderService;
import org.springframework.stereotype.Service;

/**
 * @program: TaiKangTwoStepOrderServiceImpl
 * @description: 泰康对接保司实现类
 * @author: 60007949
 * @create: 2022-01-12 15:50
 **/
@Service("TaiKangTwoStepOrderService")
public class TaiKangTwoStepOrderServiceImpl extends AbstractInsureTwoStepOrderService {
    @Override
    public InsureAcceptResDataDTO accept(InsureAcceptReqParamsDTO acceptReqParams) throws MethodNotDefineException {
        return super.accept(acceptReqParams);
    }

    @Override
    protected RequestInsureChannelResDTO<String> doValidate(InsureValidateReqParamsDTO validateReqParamsDTO, InsureChannelApiParams apiParams) throws MethodNotDefineException {
        // 构建请求参数
        // 请求保司
        return RequestInsureChannelResDTO.success("ray_code");
    }
}
