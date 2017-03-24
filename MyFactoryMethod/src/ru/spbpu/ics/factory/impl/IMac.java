package ru.spbpu.ics.factory.impl;

import ru.spbpu.ics.factory.interfaces.Product;

public class IMac implements Product{

	private Box box;
	private Cpu cpu;
	private Display display;
	
	public IMac(Box box, Cpu cpu, Display display){
		this.box = box;
		this.cpu = cpu;
		this.display = display;
	}

	public Box getBox() {
		return box;
	}

	public void setBox(Box box) {
		this.box = box;
	}

	public Cpu getCpu() {
		return cpu;
	}

	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	@Override
	public void print() {
		System.out.println("I am IMac!");
		
	}
}
