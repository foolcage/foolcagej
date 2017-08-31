package com.foolcage.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Created by xuanqi on 17-7-27.
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "TradeDate", description = "交易日期")
public class TradeDate {
    @ApiModelProperty(value = "证券id")
    private String securityId;
    @ApiModelProperty(value = "交易日期")
    private Date date;
}
