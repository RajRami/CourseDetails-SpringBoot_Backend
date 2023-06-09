package com.example.coursedetailsspringboot_backend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id", unique = true)
    private long id;

    @Column(name = "course_title", nullable = false)
    private String title;

    @Column(name = "course_description", nullable = false)
    private String description;

    @Column(name = "course_duration", nullable = false)
    private int duration;

    @Column(name = "course_fees", nullable = false)
    private double fees;

}
