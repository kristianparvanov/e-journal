package com.ejournal.java.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
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
@Table(name = "parents")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Parent extends User {

    @ManyToMany(mappedBy = "parents", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Student> students;
}
