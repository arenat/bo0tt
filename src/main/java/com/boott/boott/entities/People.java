package com.boott.boott.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "people")
public class People {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "jobTitle")
    private String jobTitle;
}
