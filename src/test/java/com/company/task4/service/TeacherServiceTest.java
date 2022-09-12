package com.company.task4.service;

import com.company.task4.StBaseTest;
import com.company.task4.entity.Teacher;
import io.jmix.core.FetchPlans;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class TeacherServiceTest extends StBaseTest {


    @Autowired
    TeacherServiceBean teacherService;

    @Autowired
    private FetchPlans fetchPlans;

    @Test
    void findByFirstName() {

        // Дано
        var teacher = dataManager.create(Teacher.class);

        String firstName = "Егор";
        String lastName = "Владимирович";

        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        entitiesToRemove.add(dataManager.save(teacher));

        // Действие
        var teacherList = teacherService.findByFirstName(firstName);

        // Проверка
        Assertions.assertFalse(teacherList.isEmpty());
        Assertions.assertEquals(teacherList.size(), 1);
        Assertions.assertEquals(firstName,
                teacherList.stream()
                        .findFirst()
                        .map(Teacher::getFirstName)
                        .orElse("Зомби"));
    }

    @Test
    void findByFirstNameFetchPlan() {

        // Дано
        var teacher = dataManager.create(Teacher.class);

        String firstName = "Егор";
        String lastName = "Владимирович";

        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        entitiesToRemove.add(dataManager.save(teacher));

        // Действие
        var teacherList = teacherService.findByFirstName(firstName,
                fetchPlans.builder(Teacher.class)
                        .add("firstName")
                        .build());

        // Проверка
        Assertions.assertFalse(teacherList.isEmpty());
        Assertions.assertEquals(teacherList.size(), 1);

        Assertions.assertThrows(Exception.class, () ->{
            var t1 = teacherList.get(0);
            var lastName1 = t1.getLastName();
        });

        Assertions.assertEquals(firstName,
                teacherList.stream()
                        .findFirst()
                        .map(Teacher::getFirstName)
                        .orElse("Зомби"));
    }
}