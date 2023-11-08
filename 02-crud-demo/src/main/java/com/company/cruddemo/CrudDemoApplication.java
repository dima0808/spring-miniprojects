package com.company.cruddemo;

import com.company.cruddemo.dao.StudentDAO;
import com.company.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {

//			createStudent(studentDAO);
//			readStudent(studentDAO);
//			readAllStudents(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		Student theStudent = new Student("Adam", "Brown", "adam14288@gmail.com");
		studentDAO.save(theStudent);
		System.out.printf("Student with id %d saved:\n%s\n", theStudent.getId(), theStudent);
	}

	private void readStudent(StudentDAO studentDAO) {
		Student theStudent = studentDAO.read(1);
		System.out.printf("Student with id %d found:\n%s\n", theStudent.getId(), theStudent);
	}

	private void readAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.readAll();
		System.out.println("All students:");
		for (Student temp : students) {
			System.out.println(temp);
		}
	}

	private void readStudentByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.readByLastName("Lethbridge");
		System.out.println("All students:");
		for (Student temp : students) {
			System.out.println(temp);
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student theStudent = studentDAO.read(1);
		theStudent.setFirstName("John");
		theStudent.setLastName("Paul");
		theStudent.setEmail("jpaul495@gmail.com");
		studentDAO.update(theStudent);
		System.out.printf("Student with id %d updated:\n%s\n", theStudent.getId(), theStudent);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int id = 23;
		Student theStudent = studentDAO.read(id);
		if (theStudent == null) {
			System.out.printf("No student with id %d.\n", id);
			return;
		}
		studentDAO.delete(id);
		System.out.printf("Student with id %d deleted:\n%s\n", id, theStudent);
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		int rowCount = studentDAO.deleteAll();
		System.out.printf("Deleted all students.\nDeleted row count: %d", rowCount);
	}
}
