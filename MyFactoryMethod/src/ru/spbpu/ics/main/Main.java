package ru.spbpu.ics.main;

import ru.spbpu.ics.factory.impl.ConcreteCreatorIMac;
import ru.spbpu.ics.factory.impl.ConcreteCreatorMacMini;
import ru.spbpu.ics.factory.impl.Factory;

public class Main {

	public static void main(String[] args) {
		Factory[] factory = {new ConcreteCreatorIMac(), new ConcreteCreatorMacMini()};
		
		for(Factory f: factory){
			System.out.println(f.newInstance());
		}
		
	}
}
