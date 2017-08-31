package com.foolcage.foolapi.controller;

import com.foolcage.foolapi.domain.Result;
import com.foolcage.foolapi.domain.VO.QuerySecurityMetaVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by xuanqi on 17-7-24.
 */
@RestController
@RequestMapping("/meta")
public class MetaController extends BaseController {

    @ApiOperation(value = "query security meta info")
    @RequestMapping(value = "/querySecurityMeta", method = {RequestMethod.POST})
    @ResponseBody
    public Result<?> queryConfig(@RequestBody @Valid QuerySecurityMetaVO queryVO,
                                 BindingResult bindingResult) {
        Result result = resolveBindResult(bindingResult);
        if (result == null) {

        }
        return result;
    }
}
