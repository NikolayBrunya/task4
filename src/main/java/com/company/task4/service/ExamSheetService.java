package com.company.task4.service;

import com.company.task4.entity.ExamSheet;
import io.jmix.core.repository.JmixDataRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.UUID;


public interface ExamSheetService {

    List<ExamSheet> findAllByNumber(String number);
    List<ExamSheet> findAllByTeacher(String firstName, String lastName);

    List<ExamSheet> findAllByTeacherFirstName(String firstName);
}
