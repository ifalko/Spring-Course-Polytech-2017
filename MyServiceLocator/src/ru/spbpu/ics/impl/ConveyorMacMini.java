package ru.spbpu.ics.impl;

import ru.spbpu.ics.interfaces.Service;

public class ConveyorMacMini {

	private ServiceLocator locator;
	
	public ConveyorMacMini(ServiceLocator locator){
		this.locator = locator;
	}
	
	public MacMini getMacMini(){
		Service box = locator.getServiceByName("Box");
		Service cpu = locator.getServiceByName("Cpu");
		return new MacMini(box, cpu);
	}
}
