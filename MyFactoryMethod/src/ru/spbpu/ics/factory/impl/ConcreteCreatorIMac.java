package ru.spbpu.ics.factory.impl;

import ru.spbpu.ics.factory.interfaces.Product;

public class ConcreteCreatorIMac extends Factory{

	@Override
	protected Product factoryMethod() {	
		Box box = new Box();
		Cpu cpu = new Cpu();
		Display display = new Display();
		return new IMac(box, cpu, display);
	}

}
