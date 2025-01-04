package com.alfsoftwares.honey.product.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.mediatype.hal.HalConfiguration;

@Configuration
public class ProductHalConfiguration {

  @Bean
  public HalConfiguration globalPolicy() {
    return new HalConfiguration()
        .withRenderSingleLinks(HalConfiguration.RenderSingleLinks.AS_ARRAY);
  }
}
