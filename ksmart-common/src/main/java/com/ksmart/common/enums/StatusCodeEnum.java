package com.ksmart.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: PeterLee
 * @date: 2020/10/27 18:37
 * @description:
 */
@AllArgsConstructor
@Getter
public enum  StatusCodeEnum {
  /**
   * 通用异常
   */
  COMMON_EX_STATUS_CODE(500,"通用异常");

  private Integer status;
  private String message;
}
