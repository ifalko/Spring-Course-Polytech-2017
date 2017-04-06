package ru.spbpu.ics.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import ru.spbpu.ics.impls.Robot;

@Configuration
@ComponentScan("ru.spbpu.ics.impls")
@ImportResource("classpath:context.xml")
public class Config {

//	@Bean("robot")
//	@Scope("prototype")
//	public Robot getRobot(){
//		return new Robot();
//	}
	
	
	@Bean("admins")
	@Scope("prototype")
	public List<String> createAdmins(){
		return new ArrayList<String>(){{
			add("ivanov@hero.org"); 
			add("petrov@slums.org"); 
			add("sidorov@gov.org");
		}};
	}
	
	@Bean("other")
	@Scope("prototype")
	public List<String> createOtherAdmins(){
		return new ArrayList<String>(){{
			System.out.println("createOtherAdmins()");
			add("smith@hero.org"); 
			add("turner@slums.org"); 
		}};
	}
	
	
	
	
}
