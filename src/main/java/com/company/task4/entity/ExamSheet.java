package com.company.task4.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JmixEntity
@Table(name = "ST_EXAM_SHEET", indexes = {
        @Index(name = "IDX_ST_EXAM_SHEET_TEACHERS", columnList = "TEACHERS_ID")
})
@Entity(name = "st_ExamSheet")
public class ExamSheet {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "NUMBER_", nullable = false)
    @NotNull
    private String number;

    @JoinColumn(name = "TEACHERS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teachers;

    public Teacher getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher teachers) {
        this.teachers = teachers;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}