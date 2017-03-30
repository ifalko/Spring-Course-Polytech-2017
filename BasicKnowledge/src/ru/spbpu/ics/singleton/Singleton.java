package ru.spbpu.ics.singleton;

public class Singleton {
	
	private static Singleton instance;
	
	public static String PATH = "/user/home/app/file.txt";
	public static String URL = "http://docs.spring.io/spring/docs/current/spring-framework-reference/pdf/spring-framework-reference.pdf";
	
	private Singleton(){
		
	}
	
	public static Singleton getInstance() throws InterruptedException {
		if(instance == null){
			Thread.sleep(3000);
			instance = new Singleton();
		}
			return instance;
	}

}
