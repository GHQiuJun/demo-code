package demo.project.test.demoprojecttest.service;

import demo.project.test.demoprojecttest.customerException.BaseException;
import demo.project.test.demoprojecttest.customerException.InsureBusinessException;
import demo.project.test.demoprojecttest.customerException.MethodNotDefineException;
import demo.project.test.demoprojecttest.entity.*;

/**
 * @program: AbstractInsureTwoStepOrderService
 * @description: 两步出单相关操作模板方法
 * @author: 60007949
 * @create: 2022-01-12 14:21
 **/
public abstract class AbstractInsureTwoStepOrderService {

    final static String VALIDATE_METHOD_NAME = "VALIDATE_INTERFACE";
    final static String ACCEPT_METHOD_NAME = "ACCEPT_INTERFACE";
    final static String CANCEL_METHOD_NAME = "CANCEL_INTERFACE";
    final static String RENEWAL_METHOD_NAME = "RENEWAL_INTERFACE";

    /**
     * 请求保司核保
     *
     * @param insureValidateReqParamsDTO 核保请求参数
     * @return String 承保单号
     */
    final public String validate(InsureValidateReqParamsDTO insureValidateReqParamsDTO) throws BaseException {
        // 获取保司参数
        final InsureChannelApiParams insureChannelApiParams = getInsureChannelApiParams("");
        // 构建请求保司参数
        // 请求保司（对接保司逻辑）
        final RequestInsureChannelResDTO<String> channelResDTO = doValidate(insureValidateReqParamsDTO, insureChannelApiParams);
        // 处理响应
        if (Boolean.TRUE.equals(channelResDTO.getIsSuccess())) {
            return channelResDTO.getData();
        }
        final Response response = covertResponseCode(channelResDTO.getErrorCode(), channelResDTO.getErrorMessage());
        throw new InsureBusinessException(response.getResponseCode(), response.getResponseMessage());
    }

    /**
     * 构建保司请求参数，请求保司核心逻辑
     * re
     *
     * @param validateReqParams
     * @param apiParams
     * @return
     * @throws MethodNotDefineException
     */
    protected RequestInsureChannelResDTO<String> doValidate(InsureValidateReqParamsDTO validateReqParams, InsureChannelApiParams apiParams) throws MethodNotDefineException {
        throw new MethodNotDefineException(VALIDATE_METHOD_NAME);
    }

    /**
     * 请求保司承保
     *
     * @param acceptReqParams 承保参数
     * @return InsureAcceptResData 承保成功参数
     * @throws Exception
     */
    public InsureAcceptResDataDTO accept(InsureAcceptReqParamsDTO acceptReqParams) throws MethodNotDefineException {
        throw new MethodNotDefineException(ACCEPT_METHOD_NAME);
    }

    /**
     * 请求保司续期
     *
     * @param renewalReqParams 续期参数
     */
    public void renewal(InsureRenewalReqParamsDTO renewalReqParams) throws BaseException {
        throw new MethodNotDefineException(RENEWAL_METHOD_NAME);
    }


    public void cancel() throws BaseException {
        throw new MethodNotDefineException(CANCEL_METHOD_NAME);
    }

    /**
     * 根据保司错误码获取系统错误码
     *
     * @param errorCode    错误码
     * @param errorMessage 错误信息
     * @return ResponseCode 系统错误码
     */
    private Response covertResponseCode(String errorCode, String errorMessage) throws BaseException {
        throw new MethodNotDefineException("");
    }

    /**
     * 根据产品编码获取保司API对接参数信息
     *
     * @param productCode 产品编码
     * @return InsureChannelApiParams 保司API对接参数信息
     */
    private InsureChannelApiParams getInsureChannelApiParams(String productCode) {
        return null;
    }
}
