package com.foolcage.common.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xuanqi on 17-6-9.
 */
@Getter
@Setter
@NoArgsConstructor
public class KData implements Serializable {
    private String id;
    private String securityId;
    private Date timestamp;
    private String type;
    private String code;
    //级别，1,5,15,30,60,DAY,WEEK,MONTH
    private String level;
    private float fuquan;

    private float open;
    private float close;
    private float high;
    private float low;
    private float volume;
    private float turnover;
}
