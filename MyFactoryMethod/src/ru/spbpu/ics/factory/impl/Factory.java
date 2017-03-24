package ru.spbpu.ics.factory.impl;

import ru.spbpu.ics.factory.interfaces.Product;

public abstract class Factory {

	public Product newInstance(){
		return factoryMethod();
	}

	protected abstract Product factoryMethod();
}
