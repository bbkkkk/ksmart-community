package com.ksmart.common.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BaseDTO {
    private String accessToken;
    private String userId;
    private String userName;
    private String ext1;
    private String ext2;
    private String ext3;
}
