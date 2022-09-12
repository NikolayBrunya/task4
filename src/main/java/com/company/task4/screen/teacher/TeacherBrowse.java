package com.company.task4.screen.teacher;

import io.jmix.ui.screen.*;
import com.company.task4.entity.Teacher;

@UiController("st_Teacher.browse")
@UiDescriptor("teacher-browse.xml")
@LookupComponent("teachersTable")
public class TeacherBrowse extends StandardLookup<Teacher> {
}