package com.ksmart.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;

@Slf4j
public class JSONUtil {

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  static {
    /**
     * 默认非空不输出，时间格式
     */
    OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    OBJECT_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
  }

  /**
   *将 JSON 字符串转为 Java 对象
   * @param json
   * @param type
   * @param <T>
   * @return
   */
  public static <T> T fromJSON(String json, Class<T> type) {
    T obj;
    try {
      obj = OBJECT_MAPPER.readValue(json, type);

    } catch (Exception e) {
      log.error("JSON to Java failed！", e);
      throw new RuntimeException(e);
    }
    return obj;
  }


  /**
   *将 JSON 字符串转为 Java 对象
   * @param obj
   * @return
   */
  public static String toJSON(Object obj) {
    String jsonString;
    try {
      jsonString = OBJECT_MAPPER.writeValueAsString(obj);

    } catch (Exception e) {
      log.error("Java to JSON failed！", e);
      throw new RuntimeException(e);
    }
    return jsonString;
  }

}
