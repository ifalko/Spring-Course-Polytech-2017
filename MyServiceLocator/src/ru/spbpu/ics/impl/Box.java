package ru.spbpu.ics.impl;

import ru.spbpu.ics.interfaces.Service;

public class Box implements Service {

	@Override
	public void print() {
		System.out.println("Box was injected");
		
	}
		
}
