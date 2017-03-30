package ru.spbpu.ics.aggcomp;

public class Main {

	public static void main(String[] args) {
		
		Person p = new Person();
		p.live(); // Student
		
		BMW bmw = new BMW();
		p.setCar(bmw);
		p.live(); // Holostyak
		
		bmw.setColor("Pink");
		p.live(); // ...
	}

}
