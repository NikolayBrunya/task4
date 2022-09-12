package com.company.task4.repository;

import com.company.task4.entity.ExamSheet;
import io.jmix.core.FetchPlan;
import io.jmix.core.repository.JmixDataRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.UUID;

public interface ExamSheetRepository extends JmixDataRepository<ExamSheet, UUID> {

    List<ExamSheet> findAllByNumber(String number);

    List<ExamSheet> findAllByTeachers_FirstNameAndTeachersLastName(String firstName, String lastName);

    List<ExamSheet> findExamSheetByTeachersFirstName(String firstName, FetchPlan fetchPlan);
}
