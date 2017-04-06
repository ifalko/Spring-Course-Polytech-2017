package ru.spbpu.ics.main;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.spbpu.ics.config.Config;
import ru.spbpu.ics.impls.Conveyor;
import ru.spbpu.ics.impls.IMac;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException {

		Consumer<String> admins = new Consumer<String>() {
			public void accept(String admin) {
				System.out.println(admin);
			}
		};

//		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		
//		IMac imac1 = (IMac) context.getBean("imac");
//		System.out.println(imac1);
//		imac1 = (IMac) context.getBean("imac");
//		System.out.println(imac1);
//
//		IMac imac2 = (IMac) context.getBean("imacTop");
//		System.out.println(imac2);
//		
//		IMac imacCustom = (IMac) context.getBean("imacCustom");
//		System.out.println(imacCustom + " : " + imacCustom.getDisplay());
//		
//		Conveyor conveyor = context.getBean("conveyorXML", Conveyor.class);
//		conveyor.getAdmins().forEach(admins);
//		conveyor.newIMacTop().printDisplay();
//		conveyor.newIMac().printDisplay();
//
//		while (true) {
//			System.out.println(conveyor + " : " + conveyor.newIMac() + " : " + conveyor.newIMacTop());
//			Thread.sleep(2000);
//		}

		// *************************************************************************************************************
		// *************************************************************************************************************
		// *************************************************************************************************************

		ApplicationContext context2 = new AnnotationConfigApplicationContext(Config.class);
//		((List<String>)context2.getBean("admins")).forEach(admins);
		
		Conveyor conveyor2 = context2.getBean("conveyor", Conveyor.class);
		
		conveyor2.getAdmins().forEach(admins);
		
		
//		System.out.println(conveyor2.getAdmins().hashCode());
//		System.out.println(conveyor2.getAdmins().hashCode());
//		
		while (true) {
			System.out.println(conveyor2 + " : " + conveyor2.newIMac() + " : " + conveyor2.newIMacTop());
			Thread.sleep(2000);
		}
		
//		System.out.println("--------");
//		boolean check1 = context2.getBean("robot") == context2.getBean("robot");
//		System.out.println("robots: " + check1);
//		System.out.println("robot.hashcode():" + context2.getBean("robot").hashCode());
//		System.out.println("robot.hashcode():" + context2.getBean("robot").hashCode());
//		System.out.println("admins.equals():" + context2.getBean("robot").equals(context2.getBean("robot")));
		//System.out.println("--------");
//		boolean check2 = context2.getBean("admins") == context2.getBean("admins");
//		System.out.println("admins: " + check2);
//		System.out.println("admins.hashcode():" + context2.getBean("admins").hashCode());
//		System.out.println("admins.hashcode():" + context2.getBean("admins").hashCode());
//		System.out.println("admins.equals():" + context2.getBean("admins").equals(context2.getBean("admins")));
////		
////		
//		String putin = "president"; //new String("president");
//		String medvedev = "president";
//		System.out.println("****");	
//		System.out.println(putin==medvedev);
//		System.out.println(putin.equals(medvedev));
		
//		System.out.println(context2.getBean("test2").hashCode());
//		System.out.println(context2.getBean("test2").hashCode());
		

	}

}
