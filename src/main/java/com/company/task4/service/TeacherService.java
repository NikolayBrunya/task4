package com.company.task4.service;

import com.company.task4.entity.Teacher;

import java.util.List;

public interface TeacherService {

    public List<Teacher> findByFirstName(String firstName);

}
