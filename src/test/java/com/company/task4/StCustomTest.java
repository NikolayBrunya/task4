package com.company.task4;

import com.company.task4.entity.Teacher;
import com.company.task4.entity.User;
import com.company.task4.service.TeacherServiceBean;
import io.jmix.core.impl.UnconstrainedDataManagerImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class StCustomTest extends  StBaseTest{



	@Test
	void teacherTest() {

		// Дано
		var teacher = dataManager.create(Teacher.class);
		teacher.setFirstName("Егор");
		teacher.setLastName("Владимирович");

		// Действие
		entitiesToRemove.add(dataManager.save(teacher));
		// Результат
		var teacherList = dataManager.load(Teacher.class)
				.query("select e from st_Teacher e where e.firstName = :firstName")
				.parameter("firstName", "Егор")
				.list();
		Assertions.assertFalse(teacherList.isEmpty());
		Assertions.assertEquals(teacherList.size(), 1);
		Assertions.assertEquals("Егор",
				teacherList.stream()
				           .findFirst()
				           .map(Teacher::getFirstName)
				           .orElse("Зомби"));

	}

	@Test
	void checkSystemUser()
	{
		User user = (User) currentAuthentication.getUser();
		Assertions.assertEquals(user.getUsername(), username);
	}
}
