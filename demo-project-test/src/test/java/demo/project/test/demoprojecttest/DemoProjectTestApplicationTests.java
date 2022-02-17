package demo.project.test.demoprojecttest;

import demo.project.test.demoprojecttest.customerException.InsureBusinessException;
import demo.project.test.demoprojecttest.customerException.MethodNotDefineException;
import demo.project.test.demoprojecttest.entity.InsureValidateReqParamsDTO;
import demo.project.test.demoprojecttest.entity.Response;
import demo.project.test.demoprojecttest.entity.ValidateResDTO;
import demo.project.test.demoprojecttest.service.AbstractInsureTwoStepOrderService;
import demo.project.test.demoprojecttest.service.AbstractValidatorService;
import demo.project.test.demoprojecttest.service.InsureServiceFactory;
import demo.project.test.demoprojecttest.service.ServiceImpl.vadidator.validate.AntiMoneyLaunderingValidator;
import demo.project.test.demoprojecttest.service.ServiceImpl.insureChannel.PinAnTwoStepOrderServiceImpl;
import demo.project.test.demoprojecttest.service.ServiceImpl.vadidator.validate.ProductRuleValidator;
import demo.project.test.demoprojecttest.service.ServiceImpl.insureChannel.TaiKangTwoStepOrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class DemoProjectTestApplicationTests {

    @Autowired
    private PinAnTwoStepOrderServiceImpl pinAnTwoStepOrderService;

    @Autowired
    private TaiKangTwoStepOrderServiceImpl taiKangTwoStepOrderService;

    @Test
    void testValidate() throws Exception {
        String productCode = "002";
        switch (productCode) {
            case "001":
                pinAnTwoStepOrderService.validate(new InsureValidateReqParamsDTO());
                break;
            case "002":
                taiKangTwoStepOrderService.validate(new InsureValidateReqParamsDTO());
                break;
            default:
                throw new Exception();
        }
    }

    @Test
    void testValidateV1() {
        String productCode = "002";
        // 参数合法性校验 基于hibernate validator
        // 构建核保请求参数
        final InsureValidateReqParamsDTO validateReqParamsDTO = new InsureValidateReqParamsDTO();

        // 规则校验（产品规则、风控风控、反洗钱）
        AbstractValidatorService validator = new AntiMoneyLaunderingValidator();
        validator.linkWith(new ProductRuleValidator());
        final ValidateResDTO validateRes = validator.startValidate(validateReqParamsDTO);
        if (!Boolean.TRUE.equals(validateRes.getValidateRes())) {
            log.info(validateRes.getResponse().toString());
        }

        // 数据入库
        // 获取产品对应保司对接实现类
        final AbstractInsureTwoStepOrderService instance = new InsureServiceFactory(productCode).getInstance();

        String rayCode = null;
        try {
            rayCode = instance.validate(validateReqParamsDTO);
        } catch (Exception e) {
            // 处理核保失败逻辑
            // 更新数据库
            // 处理异常，构建响应参数
            final Response response = getResponseByException(e);
            log.info(String.valueOf(response));
        }
        // 处理核保成功逻辑
        log.info(rayCode);
    }

    /**
     * 将系统异常转化为对应错误码
     *
     * @param e 捕获的系统异常
     * @return Response 系统错误码
     */
    private Response getResponseByException(Exception e) {
        final Response response;
        if (e instanceof InsureBusinessException) {
            response = Response.valueOf(((InsureBusinessException) e).getErrorCode());
        } else if (e instanceof MethodNotDefineException) {
            response = Response.valueOf("核心方法未定义");
        } else {
            response = Response.valueOf("未知异常");
        }
        return response;
    }

}
