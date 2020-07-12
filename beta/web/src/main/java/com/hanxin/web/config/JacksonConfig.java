package com.hanxin.web.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * Jackson 的配置类 转换 null 为 ""
 *
 * @Author: hanxin
 * @Date: 2020/7/11 11:37
 * @Version 1.0
 */
@Configuration
public class JacksonConfig {
  @Bean
  @Primary
  @ConditionalOnMissingBean(ObjectMapper.class)
  public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
    ObjectMapper objectMapper = builder.createXmlMapper(false).build();
    objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
      @Override
      public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
          throws IOException {
        jsonGenerator.writeString("");
      }
    });
    return objectMapper;
  }
}
