package com.ejournal.java.services.impls;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.ejournal.java.entities.Parent;
import com.ejournal.java.exceptions.EntityNotFoundException;
import com.ejournal.java.repositories.ParentRepository;
import com.ejournal.java.repositories.StudentRepository;
import com.ejournal.java.services.ParentStudentService;
import lombok.RequiredArgsConstructor;

/**
 * Created by kristiyan.parvanov on 29.03.20 г.
 */
@RequiredArgsConstructor
@Service
public class ParentStudentServiceImpl implements ParentStudentService {

    private static final String PARENT = "Parent";

    private final ParentRepository parentRepository;
    private final StudentRepository studentRepository;

    @Override
    public List<Parent> getParents(final List<String> ids) {
        if (Objects.isNull(ids)) {
            return Collections.emptyList();
        }

        final List<Parent> parents = (List<Parent>) parentRepository.findAllById(ids);

        if (parents.size() == ids.size()) {
            return parents;
        }

        final List<String> parentIds = parents.stream()
                .map(Parent::getId)
                .collect(Collectors.toList());

        ids.forEach(id -> {
            if (!parentIds.contains(id)) {
                throw new EntityNotFoundException(PARENT, id);
            }
        });

        return Collections.emptyList();
    }
}
