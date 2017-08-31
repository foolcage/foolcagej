package com.foolcage.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Created by xuanqi on 17-5-25.
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "Stock", description = "股票元信息")
public class Stock implements Serializable {
    @ApiModelProperty(value = "证券类型")
    private String type;
    @ApiModelProperty(value = "证券唯一标示")
    private String id;
    @ApiModelProperty(value = "证券代码")
    private String code;
    @ApiModelProperty(value = "证券名称")
    private String name;
    @ApiModelProperty(value = "上市日期")
    private Date listDate;
    @ApiModelProperty(value = "退市日期")
    private Date delistDate;
    @ApiModelProperty(value = "所在交易所")
    private String exchange;

    private Map<String, String[]> labels;
}
