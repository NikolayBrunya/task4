package com.company.task4.screen.teacher;

import io.jmix.ui.screen.*;
import com.company.task4.entity.Teacher;

@UiController("st_Teacher.edit")
@UiDescriptor("teacher-edit.xml")
@EditedEntityContainer("teacherDc")
public class TeacherEdit extends StandardEditor<Teacher> {
}