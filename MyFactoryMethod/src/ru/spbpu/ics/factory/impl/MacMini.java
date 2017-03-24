package ru.spbpu.ics.factory.impl;

import ru.spbpu.ics.factory.interfaces.Product;

public class MacMini implements Product {

	Box box;
	Cpu cpu;
	
	public MacMini(Box box, Cpu cpu){
		this.cpu = cpu;
		this.box = box;
	}
	
	@Override
	public void print() {
		System.out.println("I am MacMini");

	}

}
