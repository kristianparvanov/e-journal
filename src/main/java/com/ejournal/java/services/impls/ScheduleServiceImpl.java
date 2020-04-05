package com.ejournal.java.services.impls;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.ejournal.java.dtos.ApiResponseDto;
import com.ejournal.java.dtos.dayitem.DayItemDto;
import com.ejournal.java.dtos.schedule.CreateScheduleDayDto;
import com.ejournal.java.dtos.schedule.CreateScheduleDto;
import com.ejournal.java.dtos.schedule.GetScheduleDayDto;
import com.ejournal.java.dtos.schedule.ScheduleDayDto;
import com.ejournal.java.dtos.schedule.ScheduleDto;
import com.ejournal.java.dtos.schedule.UpdateScheduleDayDto;
import com.ejournal.java.dtos.schedule.UpdateScheduleDto;
import com.ejournal.java.entities.DayItem;
import com.ejournal.java.entities.Group;
import com.ejournal.java.entities.Schedule;
import com.ejournal.java.enums.DayOfWeek;
import com.ejournal.java.enums.Term;
import com.ejournal.java.exceptions.EntityExistsException;
import com.ejournal.java.exceptions.EntityNotFoundException;
import com.ejournal.java.exceptions.MissingPropertiesException;
import com.ejournal.java.mappers.ScheduleMapper;
import com.ejournal.java.repositories.ScheduleRepository;
import com.ejournal.java.services.DayItemService;
import com.ejournal.java.services.GroupService;
import com.ejournal.java.services.ScheduleService;
import lombok.RequiredArgsConstructor;

/**
 * Created by kristiyan.parvanov on 18.02.20 г.
 */
@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final GroupService groupService;
    private final DayItemService dayItemService;
    private final ScheduleMapper scheduleMapper;

    @Override
    public Schedule getById(final String id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Schedule", id));
    }

    @Override
    public ScheduleDto getSchedule(final String id) {
        return scheduleMapper.scheduleToScheduleDto(getById(id));
    }

    @Override
    public ScheduleDto updateSchedule(final UpdateScheduleDto updateScheduleDto) {
        if (Objects.isNull(updateScheduleDto.getTerm()) && StringUtils.isBlank(updateScheduleDto.getGroupId())) {
            throw new MissingPropertiesException("Schedule");
        }

        final Schedule schedule = getById(updateScheduleDto.getId());

        if (!Objects.isNull(updateScheduleDto.getTerm())) {
            schedule.setTerm(Term.FIRST);
        }

        if (StringUtils.isNotBlank(updateScheduleDto.getGroupId())) {
            final Group group = groupService.getById(updateScheduleDto.getGroupId());
            schedule.setGroup(group);
        }

        return scheduleMapper.scheduleToScheduleDto(scheduleRepository.save(schedule));
    }

    @Override
    public ScheduleDto createSchedule(final CreateScheduleDto createScheduleDto) {
        final Group group = groupService.getById(createScheduleDto.getGroupId());

        if (scheduleRepository.existsByGroupAndTerm(group, createScheduleDto.getTerm())) {
            throw new EntityExistsException("Schedule already exists");
        }

        final Schedule schedule = Schedule.builder()
                .term(createScheduleDto.getTerm())
                .group(group)
                .build();

        return scheduleMapper.scheduleToScheduleDto(scheduleRepository.save(schedule));
    }

    @Override
    public ApiResponseDto deleteSchedule(final String id) {
        scheduleRepository.delete(getById(id));

        return new ApiResponseDto(true, "The Schedule is deleted successfully!");
    }

    @Override
    public List<ScheduleDto> getSchedulesByGroup(final String groupId, final Term term) {
        final Group group = groupService.getById(groupId);

        if (Objects.isNull(term)) {
            return scheduleRepository.findByGroupOrderByTerm(group).stream()
                    .map(scheduleMapper::scheduleToScheduleDto)
                    .collect(Collectors.toList());
        }

        return Collections.singletonList(scheduleMapper.scheduleToScheduleDto(scheduleRepository.findByGroupAndTerm(group, term)));
    }

    @Override
    public ScheduleDayDto createScheduleDay(final CreateScheduleDayDto createScheduleDayDto) {
        final Schedule schedule = getById(createScheduleDayDto.getScheduleId());

        final DayOfWeek dayOfWeek = createScheduleDayDto.getDayOfWeek();
        final List<DayItem> dayItems = createScheduleDayDto.getDays().stream()
                .map(createDayItemDto -> dayItemService.buildDayItem(createDayItemDto, dayOfWeek))
                .peek(dayItem -> dayItem.setSchedule(schedule))
                .collect(Collectors.toList());

        final List<DayItemDto> savedDateItems = dayItemService.saveAll(dayItems);

        return buildScheduleDayDto(schedule, dayOfWeek, savedDateItems);
    }

    @Override
    public ScheduleDayDto getScheduleDay(final GetScheduleDayDto getScheduleDayDto) {
        final Schedule schedule = getById(getScheduleDayDto.getScheduleId());
        final List<DayItemDto> dateItems = dayItemService.getDayItemDtos(getScheduleDayDto.getScheduleId(),
                                                                         getScheduleDayDto.getDayOfWeek());

        return buildScheduleDayDto(schedule, getScheduleDayDto.getDayOfWeek(), dateItems);
    }

    @Override
    public ScheduleDayDto updateScheduleDay(final UpdateScheduleDayDto updateScheduleDayDto) {
        return null;
    }

    @Override
    public ApiResponseDto deleteScheduleDay(final GetScheduleDayDto getScheduleDayDto) {
        dayItemService.deleteScheduleDay(getScheduleDayDto.getScheduleId(), getScheduleDayDto.getDayOfWeek());

        return new ApiResponseDto(true, "The ScheduleDay has been deleted successfully!");
    }

    private ScheduleDayDto buildScheduleDayDto(final Schedule schedule, final DayOfWeek dayOfWeek,
                                               final List<DayItemDto> dateItems) {
        return new ScheduleDayDto(scheduleMapper.scheduleDtoToSimpleScheduleDto(schedule), dayOfWeek, dateItems);
    }
}
