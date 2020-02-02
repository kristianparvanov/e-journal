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
@Table(name = "leaves")
@NoArgsConstructor
@Getter
@Setter
public class Leave extends StudentMetric {

    @Column(name = "leave_date")
    private LocalDate leaveDate;

    @Builder
    public Leave(LocalDate modificationDate, Subject subject, Student student, Teacher teacher, LocalDate leaveDate) {
        super(null, modificationDate, subject, student, teacher);

        this.leaveDate = leaveDate;
    }
}
