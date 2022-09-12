package com.company.task4.service;

import com.company.task4.entity.ExamSheet;
import com.company.task4.repository.ExamSheetRepository;
import io.jmix.core.FetchPlan;
import io.jmix.core.FetchPlans;
import io.jmix.core.impl.UnconstrainedDataManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("st_ExamSheetServiceBean")
public class ExamSheetServiceBean implements ExamSheetService{

    //protected UnconstrainedDataManagerImpl dataManager;
    @Autowired
    private FetchPlans fetchPlans;
    protected final ExamSheetRepository examSheetRepository;

    public ExamSheetServiceBean(ExamSheetRepository examSheetRepository) {
        this.examSheetRepository = examSheetRepository;
    }

    @Override
    public List<ExamSheet> findAllByNumber(String number) {
        return examSheetRepository.findAllByNumber(number);
    }

    @Override
    public List<ExamSheet> findAllByTeacher(String firstName, String lastName) {
        return examSheetRepository.findAllByTeachers_FirstNameAndTeachersLastName(firstName,lastName);
    }

    @Override
    public List<ExamSheet> findAllByTeacherFirstName(String firstName) {

        FetchPlan fetchPlan = fetchPlans.builder(ExamSheet.class)
                .add("teachers", fetchPlanBuilder -> fetchPlanBuilder.add("firstName").build() )
                .build();
        return examSheetRepository.findExamSheetByTeachersFirstName(firstName, fetchPlan );
    }
}
