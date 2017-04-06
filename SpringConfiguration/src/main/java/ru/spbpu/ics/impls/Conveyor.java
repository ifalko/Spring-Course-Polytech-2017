package ru.spbpu.ics.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import ru.spbpu.ics.interfaces.IBox;
import ru.spbpu.ics.interfaces.ICache;
import ru.spbpu.ics.interfaces.IComputer;
import ru.spbpu.ics.interfaces.ICore;
import ru.spbpu.ics.interfaces.ICpu;
import ru.spbpu.ics.interfaces.IDisplay;
import ru.spbpu.ics.interfaces.IMatrix;

@Component("conveyor")
public class Conveyor {
	
	@Autowired
	@Qualifier("other")
	private List<String> admins;
	
	public Conveyor() {
		System.out.println("Constructor by default");
	}
	
	public Conveyor(List<String> admins){
		this.admins = admins;
		System.out.println("Constructor");
	}
	
	public IComputer newIMac() {
		return createIMac();
	}
	
	public IComputer newIMacTop() {
		return createIMacTop();
	}
	
	protected IComputer createIMac() {
		
		IBox box = new Box();
		IMatrix matrix = new TNFilm();
		IDisplay display = new Display(matrix);
		ICache cache = new Cache4Mb();
		ICore core = new CoreI5();
		ICpu cpu = new Cpu(cache, core);
		
		return new IMac(box, cpu, display);
	}
	
	@Lookup("imac")
	protected IComputer createIMacTop() {
		return null;
	}

	
	public List<String> getAdmins() {
		return admins;
	}

	public void setAdmins(List<String> admins) {
		System.out.println("Setter");
		this.admins = admins;
	}

}
