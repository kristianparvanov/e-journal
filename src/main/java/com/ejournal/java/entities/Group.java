package com.ejournal.java.entities;

import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by kristiyan.parvanov on 26.12.19 г.
 */
@Entity
@Table(name = "groups")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Group {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    private int level;

    @Column(name = "year")
    private int year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id", referencedColumnName = "id")
    private School school;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students;

    @ManyToMany(mappedBy = "groups")
    private Set<Teacher> teachers;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Schedule> schedules;
}
