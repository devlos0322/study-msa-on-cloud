package org.devlos.system.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {
    private Result result;
    private T data;
    private Object message;
    private Number errorCode;
    private String errorCodeName;

    public static <T> CommonResponse<T> success(T data, String message) {
        return (CommonResponse<T>) CommonResponse.builder()
                .result(Result.SUCCESS)
                .data(data)
                .message(message)
                .build();
    }

    public static <T> CommonResponse<T> success(T data) {
        return success(data, null);
    }

    public static CommonResponse fail(Object message, String errorCodeName, Number errorCode) {
        return CommonResponse.builder()
                .result(Result.FAIL)
                .message(message)
                .errorCodeName(errorCodeName)
                .errorCode(errorCode)
                .build();
    }

    public static CommonResponse fail(ErrorCode errorCodeName, Number errorCode) {
        return CommonResponse.builder()
                .result(Result.FAIL)
                .message(errorCodeName.getErrorMsg())
                .errorCode(errorCode)
                .errorCodeName(errorCodeName.name())
                .build();
    }

    public enum Result {
        SUCCESS, FAIL
    }
}