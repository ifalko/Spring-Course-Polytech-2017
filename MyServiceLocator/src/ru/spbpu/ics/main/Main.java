package ru.spbpu.ics.main;

import ru.spbpu.ics.impl.ConveyorMacMini;
import ru.spbpu.ics.impl.ServiceLocator;

public class Main {

	public static void main(String[] args) {
		ServiceLocator locator = new ServiceLocator();
		
		ConveyorMacMini conveyor = new ConveyorMacMini(locator);
		conveyor.getMacMini().print();

	}

}
