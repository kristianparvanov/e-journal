package com.ejournal.java.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by kristiyan.parvanov on 26.12.19 г.
 */
@Entity
@Table(name = "schools")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "school")
    private List<Group> groups;

    @OneToMany(mappedBy = "school")
    private List<Student> student;

    @OneToMany(mappedBy = "school")
    private List<Teacher> teachers;
}
