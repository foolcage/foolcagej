package com.foolcage.foolapi.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "Result", description = "返回结果")
public class Result<T> {
    @ApiModelProperty(value = "错误标识")
    private int code;
    @ApiModelProperty(value = "错误信息")
    private String msg;
    @ApiModelProperty(value = "返回的数据")
    private T data;

    public Result(ErrorCode errorCode) {
        code = errorCode.getCode();
        msg = errorCode.getMessage();
    }

    public Result(ErrorCode errorCode, T data) {
        code = errorCode.getCode();
        msg = errorCode.getMessage();
        this.data = data;
    }
}
