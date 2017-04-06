package ru.spbpu.ics.impls;

import ru.spbpu.ics.interfaces.IBox;
import ru.spbpu.ics.interfaces.IComputer;
import ru.spbpu.ics.interfaces.ICpu;
import ru.spbpu.ics.interfaces.IDisplay;


public class IMac implements IComputer {

	private IBox box;
	private ICpu cpu;
	private IDisplay display;
	
	public IMac(IBox box, ICpu cpu, IDisplay display) {
		this.box = box;
		this.cpu = cpu;
		this.display = display;
	}
	
	public IBox getBox() {
		return box;
	}
	public void setBox(IBox box) {
		this.box = box;
	}
	public ICpu getCpu() {
		return cpu;
	}
	public void setCpu(ICpu cpu) {
		this.cpu = cpu;
	}
	public IDisplay getDisplay() {
		return display;
	}
	public void setDisplay(IDisplay display) {
		this.display = display;
	}

	public void printDisplay() {
		display.print();
	}

	public void printCpu() {
		// TODO Auto-generated method stub
		
	}

	public void printBox() {
		// TODO Auto-generated method stub
		
	}
}
