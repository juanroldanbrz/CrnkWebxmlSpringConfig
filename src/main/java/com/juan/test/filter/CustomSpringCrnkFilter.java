package com.juan.test.filter;

import io.crnk.core.boot.CrnkBoot;
import io.crnk.servlet.CrnkFilter;
import io.crnk.spring.SpringCrnkFilter;
import io.crnk.spring.boot.CrnkSpringBootProperties;
import io.crnk.spring.internal.SpringServiceDiscovery;
import io.crnk.spring.mvc.SpringMvcModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class CustomSpringCrnkFilter extends CrnkFilter {

  private SpringServiceDiscovery springServiceDiscovery;
  private SpringMvcModule springMvcModule;

  public CustomSpringCrnkFilter(SpringServiceDiscovery springServiceDiscovery, SpringMvcModule springMvcModule){
    this.springServiceDiscovery = springServiceDiscovery;
    this.springMvcModule = springMvcModule;
  }

  @Override
  protected void initCrnk(CrnkBoot boot) {
    boot.addModule(springMvcModule);
    boot.setServiceDiscovery(springServiceDiscovery);
  }
}
