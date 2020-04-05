package com.ejournal.java.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.ejournal.java.entities.Group;
import com.ejournal.java.entities.Schedule;
import com.ejournal.java.enums.Term;

/**
 * Created by kristiyan.parvanov on 18.02.20 г.
 */
public interface ScheduleRepository extends PagingAndSortingRepository<Schedule, String> {

    boolean existsByGroupAndTerm(Group group, Term term);

    Schedule findByGroupAndTerm(Group group, Term term);

    List<Schedule> findByGroupOrderByTerm(Group group);
}
