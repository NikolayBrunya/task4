package com.company.task4.service;

import com.company.task4.entity.Teacher;
import io.jmix.core.FetchPlan;
import io.jmix.core.FetchPlans;
import io.jmix.core.impl.UnconstrainedDataManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("st_TeacherServiceBean")
public class TeacherServiceBean implements  TeacherService {

    protected UnconstrainedDataManagerImpl dataManager;

    public TeacherServiceBean(UnconstrainedDataManagerImpl dataManager) {
        this.dataManager = dataManager;
    }

    @Autowired
    private FetchPlans fetchPlans;

    @Override
    public List<Teacher> findByFirstName(String firstName) {
        return findByFirstName(firstName, fetchPlans.builder(Teacher.class).add("firstName").build());
    }

    @Override
    public List<Teacher> findByFirstName(String firstName, FetchPlan fetchPlan) {
        return dataManager.load(Teacher.class)
                .query("select e from st_Teacher e where e.firstName = :firstName")
                .parameter("firstName", firstName)
                .fetchPlan(fetchPlan)
                .list();
    }
}

