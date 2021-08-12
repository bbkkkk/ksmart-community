package com.ksmart.common.exception;

import com.ksmart.common.enums.StatusCodeEnum;
import lombok.Data;

/**
 * @author: PeterLee
 * @date: 2020/10/27 18:36
 * @description:
 */
@Data
public class CustomException extends RuntimeException {
  private Integer status;

  public CustomException(Integer status, String message) {
    super(message);
    this.status = status;
  }

  public static CustomException build(StatusCodeEnum statusCodeEnum) {
    return new CustomException(statusCodeEnum.getStatus(), statusCodeEnum.getMessage());
  }
}
