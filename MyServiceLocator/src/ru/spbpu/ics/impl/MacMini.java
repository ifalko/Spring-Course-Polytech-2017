package ru.spbpu.ics.impl;

import ru.spbpu.ics.interfaces.Service;

public class MacMini {

	private Service box;
	private Service cpu;
	
	public MacMini(Service box, Service cpu){
		this.box = box;
		this.cpu = cpu;
	}

	public Service getBox() {
		return box;
	}

	public void setBox(Service box) {
		this.box = box;
	}

	public Service getCpu() {
		return cpu;
	}

	public void setCpu(Service cpu) {
		this.cpu = cpu;
	}
	
	public void print(){
		box.print();
		cpu.print();
	}
}
