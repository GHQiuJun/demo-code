package demo.project.test.demoprojecttest.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @program: RequestInsureChannelResDTO
 * @description: 请求保司响应数据中间对象
 * @author: 60007949
 * @create: 2022-01-12 18:59
 **/
@Data
@Builder
public class RequestInsureChannelResDTO<T> {
    Boolean isSuccess;
    String errorCode;
    String errorMessage;
    T data;

    public RequestInsureChannelResDTO() {

    }

    public RequestInsureChannelResDTO(Boolean isSuccess, String errorCode, String errorMessage, T data) {
        this.isSuccess = isSuccess;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.data = data;
    }

    public static RequestInsureChannelResDTO<Object> failure(String errorCode, String errorMessage) {
        return RequestInsureChannelResDTO.builder()
                .isSuccess(false)
                .errorCode(errorCode)
                .errorMessage(errorMessage)
                .build();
    }

    public static RequestInsureChannelResDTO<String> success(String data) {
        RequestInsureChannelResDTO<String> channelResDTO = new RequestInsureChannelResDTO<>();
        channelResDTO.setIsSuccess(true);
        channelResDTO.setData(data);
        return channelResDTO;

    }
}
