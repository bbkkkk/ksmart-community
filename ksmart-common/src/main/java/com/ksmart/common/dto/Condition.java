package com.ksmart.common.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Condition {
    private String name;
    private Object value;
    private String direction;
}
