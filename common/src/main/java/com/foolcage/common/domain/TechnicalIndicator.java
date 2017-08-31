package com.foolcage.common.domain;

import java.util.Date;

/**
 * Created by xuanqi on 17-7-19.
 */
public class TechnicalIndicator {
    private String id;
    private Date timestamp;
    private String securityId;
    private String code;
    private String type;
    //级别，1,5,15,30,60,DAY,WEEK,MONTH
    private String level;
    private float fuquan;


    private float pe;
    private float pe1;
    private float ma;
    private float macd;
}
