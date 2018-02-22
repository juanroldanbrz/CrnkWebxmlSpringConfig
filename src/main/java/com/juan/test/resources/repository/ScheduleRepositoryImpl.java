package com.juan.test.resources.repository;

import com.juan.test.resources.model.Schedule;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class ScheduleRepositoryImpl extends ResourceRepositoryBase<Schedule, Long> {

  private Map<Long, Schedule> schedules = new HashMap<>();

  protected ScheduleRepositoryImpl() {
    super(Schedule.class);
  }

  @Override
  public ResourceList<Schedule> findAll(QuerySpec querySpec) {
    return querySpec.apply(schedules.values());
  }

  @Override
  public <S extends Schedule> S save(S entity) {
    schedules.put(entity.getId(), entity);
    return null;
  }

  @Override
  public void delete(Long id) {
    schedules.remove(id);
  }
}