/**
 *
 */
package com.foolcage.foolapi.controller;

import com.foolcage.foolapi.domain.Result;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import static com.foolcage.foolapi.domain.ErrorCode.CODE_FAILED;
import static com.foolcage.foolapi.domain.ErrorCode.CODE_REQUEST_ARG_ERROR;
import static com.foolcage.foolapi.domain.ErrorCode.CODE_SUCCESS;

public class BaseController {

    Result success(Object data) {
        return new Result(CODE_SUCCESS, data);
    }

    Result success() {
        return new Result(CODE_SUCCESS);
    }

    Result failed() {
        return new Result(CODE_FAILED);
    }

    Result failed(String msg, Object data) {
        return new Result(CODE_FAILED.getCode(), msg, data);
    }

    Result failed(String msg) {
        return new Result(CODE_FAILED.getCode(), msg, null);
    }

    protected Result resolveBindResult(BindingResult result) {
        if (result != null && result.hasErrors()) {
            FieldError fieldError = result.getFieldError();
            return new Result<>(CODE_REQUEST_ARG_ERROR, fieldError.getDefaultMessage());
        }
        return null;
    }
}
