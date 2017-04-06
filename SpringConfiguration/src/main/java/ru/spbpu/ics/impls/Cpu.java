package ru.spbpu.ics.impls;

import ru.spbpu.ics.interfaces.ICache;
import ru.spbpu.ics.interfaces.ICore;
import ru.spbpu.ics.interfaces.ICpu;

public class Cpu implements ICpu{

	private ICache cache;
	private ICore core;
	
	public Cpu(ICache cache, ICore core){
		this.setCache(cache);
		this.setCore(core);
	}

	public ICache getCache() {
		return cache;
	}

	public void setCache(ICache cache) {
		this.cache = cache;
	}

	public ICore getCore() {
		return core;
	}

	public void setCore(ICore core) {
		this.core = core;
	}
	
}
