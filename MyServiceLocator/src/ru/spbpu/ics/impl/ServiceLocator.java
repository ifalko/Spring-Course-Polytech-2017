package ru.spbpu.ics.impl;

import java.util.HashMap;
import java.util.Map;

import ru.spbpu.ics.interfaces.Service;

public class ServiceLocator {
	
	Map<String, Service> locator = new HashMap<String, Service>();
	
	{
		System.out.println("block init");
		locator.put("Box", new Box());
		locator.put("Cpu", new Cpui7());
	}
	
	public ServiceLocator(){
		System.out.println("Init");
	}
	
	public Service getServiceByName(String service){
		return locator.get(service);
	}
	
	
}
