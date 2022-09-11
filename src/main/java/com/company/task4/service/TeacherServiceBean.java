package com.company.task4.service;

import com.company.task4.entity.Teacher;
import io.jmix.core.impl.UnconstrainedDataManagerImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("st_TeacherServiceBean")
public class TeacherServiceBean implements  TeacherService {

    protected UnconstrainedDataManagerImpl dataManager;

    public TeacherServiceBean(UnconstrainedDataManagerImpl dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public List<Teacher> findByFirstName(String firstName) {
        return dataManager.load(Teacher.class)
                .query("select e from st_Teacher e where e.firstName = :firstName")
                .parameter("firstName", firstName)
                .list();
    }
}

