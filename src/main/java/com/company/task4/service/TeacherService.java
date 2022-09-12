package com.company.task4.service;

import com.company.task4.entity.Teacher;
import io.jmix.core.FetchPlan;

import java.util.List;

public interface TeacherService {

    public List<Teacher> findByFirstName(String firstName);
    public List<Teacher> findByFirstName(String firstName, FetchPlan fetchPlan);

}
