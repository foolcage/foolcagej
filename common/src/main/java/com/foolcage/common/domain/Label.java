package com.foolcage.common.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by xuanqi on 17-7-21.
 */
@Getter
@Setter
@NoArgsConstructor
public class Label implements Serializable {
    private String id;
    private String name;
    private String[] values;
}
