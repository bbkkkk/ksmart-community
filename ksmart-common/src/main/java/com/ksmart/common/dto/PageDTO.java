package com.ksmart.common.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class PageDTO {
    private int pageSize;
    private int currentPage;
    private String input;
    private String direction;
    private List<Condition> conditions;
}
