package ru.spbpu.ics.aggcomp;

public class Person {

	private Heart heart = new Heart(); // Composition
	private Eyes eyes = new Eyes(); // Composition
	private Car car; // Aggregation
	
	private interface IAction {
		void action();
	}
	
	private class Heart implements IAction {
		@Override
		public void action() {
			System.out.println("Tick Tack");
		}
	}
	
	private class Eyes implements IAction{
		@Override
		public void action() {
			System.out.println("Clap clap");	
		}
	}
	
	public void live(){
		heart.action();
		eyes.action();
		if(getCar() != null){
			getCar().model();
		}
		System.out.println("*** ------- ***");
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}
