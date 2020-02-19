package com.ejournal.java.repositories;

import java.time.LocalDate;

import org.springframework.data.repository.CrudRepository;
import com.ejournal.java.entities.Group;
import com.ejournal.java.entities.Schedule;

/**
 * Created by kristiyan.parvanov on 18.02.20 г.
 */
public interface ScheduleRepository extends CrudRepository<Schedule, String> {

    boolean existsByGroupAndFromDate(Group group, LocalDate fromDate);
}
