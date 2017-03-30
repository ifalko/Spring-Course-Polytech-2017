package ru.spbpu.ics.main;

import java.lang.reflect.InvocationTargetException;

import ru.spbpu.ics.impls.Computer;
import ru.spbpu.ics.impls.IoCContainer;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		Computer comp = (Computer) IoCContainer.produce(Computer.class);
		System.out.println(comp);
		Computer comp2 = (Computer) IoCContainer.produce(Computer.class);
		System.out.println(comp2);
		if(comp.equals(comp2)){
			System.out.println("equals");
		}

	}

}
