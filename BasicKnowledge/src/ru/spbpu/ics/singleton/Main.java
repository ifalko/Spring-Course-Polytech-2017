package ru.spbpu.ics.singleton;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
//		Singleton s0 = new Singleton(); //Error: The constructor Singleton() is not visible
		
		System.out.println(Singleton.PATH);
		System.out.println(Singleton.URL);
		
		System.out.println("*** ---1--- ***");
		Singleton s1 = Singleton.getInstance();
		System.out.println("*** ---2--- ***");
		Singleton s2 = Singleton.getInstance();
		System.out.println("*** ---3--- ***");
		
		if(s1.equals(s2)){
			System.out.println(s1 + " = " + s2);
		}
		
		
		
		
	}
}
