package com.company.task4.service;

import com.company.task4.StBaseTest;
import com.company.task4.entity.Teacher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class TeacherServiceTest extends StBaseTest {


    @Autowired
    TeacherServiceBean teacherService;
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
}