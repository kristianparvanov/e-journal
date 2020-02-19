package com.ejournal.java.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import com.ejournal.java.entities.DayItem;
import com.ejournal.java.enums.DayOfWeek;

/**
 * Created by kristiyan.parvanov on 18.02.20 г.
 */
public interface DayItemRepository extends PagingAndSortingRepository<DayItem, String> {

    String FIND_BY_SCHEDULE_AND_DAY_OF_WEEK = "SELECT * "
            + "FROM day_items di "
            + "WHERE di.schedule_id = :scheduleId AND di.day_of_week = :dayOfWeek "
            + "ORDER BY di.period";

    @Query(value = FIND_BY_SCHEDULE_AND_DAY_OF_WEEK, nativeQuery = true)
    List<DayItem> findByScheduleAndAndDayOfWeek(@Param("scheduleId") String scheduleId,
                                                @Param("dayOfWeek") String dayOfWeek);
}
