package ru.spbpu.ics.factory.impl;

import ru.spbpu.ics.factory.interfaces.Product;

public class ConcreteCreatorMacMini extends Factory{

	@Override
	protected Product factoryMethod() {
		Box box = new Box();
		Cpu cpu = new Cpu();
		return new MacMini(box, cpu);
	}

}
