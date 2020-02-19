package com.ejournal.java.services.impls;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;
import com.ejournal.java.dtos.dayitem.CreateDayItemDto;
import com.ejournal.java.dtos.dayitem.DayItemDto;
import com.ejournal.java.dtos.schedule.GetScheduleDayDto;
import com.ejournal.java.entities.DayItem;
import com.ejournal.java.entities.Subject;
import com.ejournal.java.entities.Teacher;
import com.ejournal.java.enums.DayOfWeek;
import com.ejournal.java.exceptions.EntityNotFoundException;
import com.ejournal.java.mappers.DayItemMapper;
import com.ejournal.java.repositories.DayItemRepository;
import com.ejournal.java.services.DayItemService;
import com.ejournal.java.services.SubjectService;
import com.ejournal.java.services.TeacherService;
import lombok.RequiredArgsConstructor;

/**
 * Created by kristiyan.parvanov on 18.02.20 г.
 */
@Service
@RequiredArgsConstructor
public class DayItemsImpl implements DayItemService {

    private final DayItemRepository dayItemRepository;
    private final SubjectService subjectService;
    private final TeacherService teacherService;
    private final DayItemMapper dayItemMapper;

    @Override
    public DayItem buildDayItem(final CreateDayItemDto createDayItemDto, final DayOfWeek dayOfWeek) {
        final Subject subject = subjectService.getById(createDayItemDto.getSubjectId());
        final Teacher teacher = teacherService.getById(createDayItemDto.getTeacherId());

        final DayItem dayItem = dayItemMapper.createDayItemDtoToDayItem(createDayItemDto);
        dayItem.setSubject(subject);
        dayItem.setTeacher(teacher);
        dayItem.setDayOfWeek(dayOfWeek);

        return dayItem;
    }

    @Override
    public DayItem get() {
        return null;
    }

    @Override
    public DayItem update() {
        return null;
    }

    @Override
    public void delete(final String id) {
        final DayItem dayItem = dayItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("DayItem", id));

        dayItemRepository.delete(dayItem);
    }

    @Override
    public List<DayItemDto> saveAll(List<DayItem> dayItems) {
        return StreamSupport.stream(dayItemRepository.saveAll(dayItems).spliterator(), false)
                .map(dayItemMapper::dayItemToDayItemDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DayItemDto> getDayItemDtos(final String scheduleId, final DayOfWeek dayOfWeek) {
        return getScheduleDay(scheduleId, dayOfWeek).stream()
                .map(dayItemMapper::dayItemToDayItemDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteScheduleDay(final String scheduleId, final DayOfWeek dayOfWeek) {
        dayItemRepository.deleteAll(getScheduleDay(scheduleId, dayOfWeek));
    }

    private List<DayItem> getScheduleDay(String scheduleId, DayOfWeek dayOfWeek) {
        return dayItemRepository.findByScheduleAndAndDayOfWeek(scheduleId, dayOfWeek.toString());
    }
}
