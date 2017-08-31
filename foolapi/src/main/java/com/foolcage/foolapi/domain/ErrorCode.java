package com.foolcage.foolapi.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@ApiModel(value = "ErrorCode", description = "错误码")
public enum ErrorCode {
    //common
    CODE_FAILED(-1, "failed"),
    CODE_SUCCESS(0, "success"),
    CODE_REQUEST_ARG_ERROR(1, "request arg error");

    @ApiModelProperty(value = "错误标识")
    private int code;
    @ApiModelProperty(value = "错误信息")
    private String message;
}