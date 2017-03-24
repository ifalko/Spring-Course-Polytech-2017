package ru.spbpu.ics.impl;

import ru.spbpu.ics.interfaces.Service;

public class Cpu implements Service {

	@Override
	public void print() {
		System.out.println("Cpu was injected");
		
	}
	
}
