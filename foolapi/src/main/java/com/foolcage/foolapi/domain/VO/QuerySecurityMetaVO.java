package com.foolcage.foolapi.domain.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by xuanqi on 17-7-24.
 */
@Getter
@Setter
@ApiModel(value = "QuerySecurityMetaVO", description = "查询证券标的元信息")
public class QuerySecurityMetaVO {
    @ApiModelProperty(value = "交易所唯一标识", allowableValues = "sh,sz", example = "sh")
    private String exchange;
    @ApiModelProperty(value = "证券类型", allowableValues = "stock", example = "stock")
    private String type;
    @ApiModelProperty(value = "证券代码", example = "000338")
    private String code;
    @ApiModelProperty(value = "证券名称", example = "潍柴动力")
    private String name;
}
