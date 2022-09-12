package com.company.task4.repository;

import com.company.task4.entity.ExamSheet;
import com.company.task4.entity.Teacher;
import io.jmix.core.repository.JmixDataRepository;

import java.util.UUID;

public interface TeacherRepository extends JmixDataRepository<Teacher, UUID> {


}
