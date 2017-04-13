package ru.spbpu.ics.main;
import java.util.function.Consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.spbpu.ics.dao.config.SqlConfig;
import ru.spbpu.ics.dao.impls.PersonSql;
import ru.spbpu.ics.dao.objects.Person;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		

		ApplicationContext context2 = new AnnotationConfigApplicationContext(SqlConfig.class);
		PersonSql sqLite = (PersonSql) context2.getBean("personSQL");
		
//		Person p = new Person();
//		p.setFirstName("Alexey");
//		p.setLastName("Falko");
//		p.setAge(22);
		
//		Person p1 = new Person();
//		p1.setFirstName("Lewis");
//		p1.setLastName("Hamilton");
//		p1.setAge(31);
		
//		sqLite.drop();
//		sqLite.create();
//		sqLite.insertWithJDBC(p);
		
//		sqLite.updateByID(4, p1);
		
		Consumer<Person> consumer = new Consumer<Person>() {
			@Override
			public void accept(Person p) {
				System.out.println(p.getFirstName() + " | " 
									+ p.getLastName() + " | " 
									+ p.getAge());
			}
		};
		
		sqLite.findAll().forEach(consumer);
		
	}

}