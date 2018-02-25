package com.juan.test.config;

import com.juan.test.filter.CustomSpringCrnkFilter;
import io.crnk.spring.boot.CrnkSpringBootProperties;
import io.crnk.spring.internal.SpringServiceDiscovery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.juan.test.resources", "com.juan.test.config"})
public class GlobalConfig {

  @Autowired
  private ApplicationContext applicationContext;

  @Bean
  public CrnkSpringBootProperties properties(){
    CrnkSpringBootProperties properties = new CrnkSpringBootProperties();
    properties.setEnabled(true);
    return properties;
  }

  @Bean
  public CustomSpringCrnkFilter customSpringCrnkFilter(){
    SpringServiceDiscovery springServiceDiscovery = new SpringServiceDiscovery();
    springServiceDiscovery.setApplicationContext(applicationContext);

    return new CustomSpringCrnkFilter(springServiceDiscovery,customSpringMvcModule);
  }

  @Autowired
  private CustomSpringMvcModule customSpringMvcModule;

}
