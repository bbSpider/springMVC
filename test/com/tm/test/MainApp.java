package com.tm.test;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.tm.dao.impl.StudentJDBCTemplate;
import com.tm.dto.Student;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
		System.out.println("------新增------------");
		studentJDBCTemplate.create("L", 11);
		
		System.out.println("------查询------------");
		List<Student> students = studentJDBCTemplate.listStudents();
		for (Student record : students) {
			System.out.print("ID : " + record.getId());
			System.out.print(", Name : " + record.getName());
			System.out.println(", Age : " + record.getAge());
		}
		
		System.out.println("----通过id查询一条数据 -----");
		Student student = studentJDBCTemplate.getStudent(2);
		System.out.print("ID : " + student.getId());
		System.out.print(", Name : " + student.getName());
		System.out.println(", Age : " + student.getAge());
		
		 System.out.println("----修改-----" );
	     studentJDBCTemplate.update(2, 20);
	     
	     System.out.println("------删除-------");
	     studentJDBCTemplate.delete(4);
		
	}
}
