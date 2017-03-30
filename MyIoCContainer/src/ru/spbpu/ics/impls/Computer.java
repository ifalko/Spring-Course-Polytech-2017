package ru.spbpu.ics.impls;

import ru.spbpu.ics.annotations.Qualifier;

public class Computer {
	
	@Qualifier
	private Cpu cpuMain; 
	
	@Qualifier(freqValue = "2.0 Hz")
	private Cpu cpuNotMain;
	
	public Cpu getCpuMain() {
		return cpuMain;
	}
	
	public void setCpuMain(Cpu cpuMain) {
		this.cpuMain = cpuMain;
	}

	public Cpu getCpuNotMain() {
		return cpuNotMain;
	}

	
	
	@Override
	public String toString(){
		return getCpuMain().getFrequancy() + ": " + getCpuNotMain().getFrequancy();
	}
}
