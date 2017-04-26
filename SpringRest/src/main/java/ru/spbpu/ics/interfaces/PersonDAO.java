package ru.spbpu.ics.interfaces;

import java.util.List;

import ru.spbpu.ics.objects.Person;

public interface PersonDAO extends PersonTable{
												//*** - CRUD - ***
	public void insert(Person person); 				// Create
	public List<Person> findAll(); 					// Read
	public void updateByID(int id, Person person); 	// Update
	public void deleteByID(int id); 					// Delete

	// *********************************

	public Person getPersonByID(int id);

	public void deleteAllPerson();
}
