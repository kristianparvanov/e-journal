package com.ejournal.java.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by kristiyan.parvanov on 26.12.19 г.
 */
@Entity
@Table(name = "marks")
@NoArgsConstructor
@Getter
@Setter
public class Mark extends StudentMetric {

    @Column(name = "mark")
    private Integer mark;

    @Builder
    public Mark(LocalDate modificationDate, Subject subject, Student student, Teacher teacher, Integer mark) {
        super(null, modificationDate, subject, student, teacher);

        this.mark = mark;
    }
}
