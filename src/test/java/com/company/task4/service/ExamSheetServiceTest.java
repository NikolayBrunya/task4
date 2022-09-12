package com.company.task4.service;

import com.company.task4.StBaseTest;
import com.company.task4.entity.ExamSheet;
import com.company.task4.entity.Teacher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ExamSheetServiceTest extends StBaseTest {

    @Autowired
    ExamSheetServiceBean examSheet;

    @Test
    void findAllByNumber() {

        // Дано
        var exS = dataManager.create(ExamSheet.class);

        String number = "test_num";
        exS.setNumber(number);
        entitiesToRemove.add(dataManager.save(exS));

        // Действие
        var examList = examSheet.findAllByNumber(number);

        // Проверка
        Assertions.assertFalse(examList.isEmpty());
        Assertions.assertEquals(examList.size(), 1);
        Assertions.assertEquals(number,
                examList.stream()
                        .findFirst()
                        .map(ExamSheet::getNumber)
                        .orElse("Зомби"));
    }
    @Test
    void findAllTeacher()
    {
        // Дано
        var exS = dataManager.create(ExamSheet.class);
        var teacher = dataManager.create(Teacher.class);
        //Учитель
        String firstName = "Егор";
        String lastName = "Владимирович";

        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);

        // Ведомость
        String number = "test_num";
        exS.setNumber(number);
        exS.setTeachers(teacher);
        entitiesToRemove.add(dataManager.save(teacher));
        entitiesToRemove.add(dataManager.save(exS));



        // Действие
        var examList = examSheet.findAllByTeacher(firstName, lastName);

        // Проверка
        Assertions.assertFalse(examList.isEmpty());
        Assertions.assertEquals(examList.size(), 1);
        // check number
        var examSheet = examList.get(0);
        Assertions.assertEquals(number,examSheet.getNumber());
        // check teacher
        Assertions.assertEquals(firstName,examSheet.getTeachers().getFirstName());
        Assertions.assertEquals(lastName,examSheet.getTeachers().getLastName());
    }
    @Test
    void  findAllByFirstName()
    {
        // Дано
        var exS = dataManager.create(ExamSheet.class);
        var teacher = dataManager.create(Teacher.class);
        //Учитель
        String firstName = "Егор";
        teacher.setFirstName(firstName);


        // Ведомость
        String number = "test_num";
        exS.setNumber(number);
        exS.setTeachers(teacher);
        entitiesToRemove.add(dataManager.save(teacher));
        entitiesToRemove.add(dataManager.save(exS));

        // Действие
        var examList = examSheet.findAllByTeacherFirstName(firstName);
        var examSheet = examList.get(0);
        // Проверка
        Assertions.assertFalse(examList.isEmpty());
        Assertions.assertEquals(examList.size(), 1);
        // check number

        Assertions.assertEquals(number,examSheet.getNumber());
        // check teacher
        Assertions.assertEquals(firstName,examSheet.getTeachers().getFirstName());

    }
}