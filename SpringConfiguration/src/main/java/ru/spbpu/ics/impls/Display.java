package ru.spbpu.ics.impls;

import ru.spbpu.ics.interfaces.IDisplay;
import ru.spbpu.ics.interfaces.IMatrix;

public class Display implements IDisplay{

	private IMatrix matrix;
	
	public Display(IMatrix matrix){
		this.setMatrix(matrix);
	}
	
	public void print() {
		matrix.print();
	}

	public IMatrix getMatrix() {
		return matrix;
	}

	public void setMatrix(IMatrix matrix) {
		this.matrix = matrix;
	}

}
