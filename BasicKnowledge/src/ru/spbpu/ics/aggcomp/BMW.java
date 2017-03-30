package ru.spbpu.ics.aggcomp;

public class BMW extends Car {

	private String color = "Black";
	
	@Override
	protected void model() {
		System.out.println(BMW.class.getSimpleName() + ": " + getColor());
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
