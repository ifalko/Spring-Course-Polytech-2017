package ru.spbpu.ics.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.spbpu.ics.impls.IMac;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		
		IMac imac = (IMac)context.getBean("imac");
		
		IMac imac2 = (IMac)context.getBean("imac2");
		
		imac.getDisplay().print();
		imac2.getDisplay().print();
	}
	
	
	
}
