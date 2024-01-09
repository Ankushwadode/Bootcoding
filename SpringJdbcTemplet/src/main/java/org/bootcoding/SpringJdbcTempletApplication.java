package org.bootcoding;

import org.bootcoding.Repository.StudentRepo;
import org.bootcoding.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringJdbcTempletApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcTempletApplication.class, args);

		Student student = context.getBean(Student.class);

		student.setId(101);
		student.setName("Ankush");
		student.setTech("Java");

		StudentRepo studentRepo = context.getBean(StudentRepo.class);
		studentRepo.save(student);

		System.out.println(studentRepo.findAll());
	}

}
