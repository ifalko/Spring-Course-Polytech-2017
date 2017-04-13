package ru.spbpu.ics.dao.interfaces;

import java.util.List;

import ru.spbpu.ics.dao.objects.Person;

public interface PersonDao {
												//*** - CRUD - ***
	public void insert(Person person); 				// Create
	List<Person> findAll(); 							// Read 
	public void updateByID(int id, Person person);	// Update
	public void deleteByID(int id);					// Delete
	
	//*********************************
	
	Person getPersonByID(int id);
	public void deleteAllPerson();

}
