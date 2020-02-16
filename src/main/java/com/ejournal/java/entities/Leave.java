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

    @Builder
    public Leave(final LocalDate modificationDate, final Subject subject, final Student student, final Teacher teacher) {
        super(null, modificationDate, subject, student, teacher);
    }
}
