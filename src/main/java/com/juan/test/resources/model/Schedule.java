package com.juan.test.resources.model;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;

@Data
@JsonApiResource(type = "schedules")
public class Schedule {

  @JsonApiId
  private Long id;
  private String name;

}
