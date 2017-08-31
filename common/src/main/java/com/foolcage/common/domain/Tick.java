package com.foolcage.common.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xuanqi on 17-5-25.
 */
@Getter
@Setter
@NoArgsConstructor
public class Tick implements Serializable {
    private String id;
    private String securityId;
    private Date timestamp;
    private float price;
    private float change;
    private long volume;
    private float turnover;
    private int direction;
}
