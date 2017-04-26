package ru.spbpu.ics.controls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.spbpu.ics.interfaces.PersonDAO;
import ru.spbpu.ics.objects.Person;

@RestController
public class PersonController {

	private static final String template = "%sov";

	@Autowired
	private PersonDAO personBD;

	@RequestMapping(path = "/")
	public Person example(@RequestParam(value = "name", defaultValue = "Petr") String name) {
		Person person = new Person();
		person.setFirstName(name);
		person.setLastName(String.format(template, name));
		person.setAge(0);
		return person;
	}

	
	
	
	
	//*************************************************************************
	//*************************************************************************
	//*************************************************************************
	
	
	
	
	@GetMapping
	@RequestMapping(path = "/get_all")
	public ResponseEntity<List<Person>> personAll() {
		List<Person> listPerson = personBD.findAll();
		return new ResponseEntity<List<Person>>(listPerson, HttpStatus.OK);
	}

	@GetMapping
	@RequestMapping(path = "/get_person")
	public ResponseEntity<Person> personByID(@RequestParam(value = "id") Integer id) {
		Person person;
		try {
			person = personBD.getPersonByID(id);
		} catch (NullPointerException e) {
			/**
			 * 418 I'm a teapot — Этот код был введен в 1998 году как одна из
			 * традиционных первоапрельских шуток IETF в RFC 2324, Hyper Text
			 * Coffee Pot Control Protocol. Не ожидается, что данный код будет
			 * поддерживаться реальными серверами =)
			 */
			return new ResponseEntity<Person>(HttpStatus.I_AM_A_TEAPOT);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

	@PostMapping
	@RequestMapping(path = "/post_person")
	public ResponseEntity<Person> personAdd(@RequestBody Person person) {
		personBD.insert(person);
		return new ResponseEntity<Person>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/init")
	public ResponseEntity<Person> init() {

		personBD.drop();
		personBD.create();

		Person person = new Person();
		person.setFirstName("Alexey");
		person.setLastName("Falko");
		person.setAge(22);
		personBD.insert(person);

		person.setFirstName("Lewis");
		person.setLastName("Hamilton");
		person.setAge(31);
		personBD.insert(person);

		person.setFirstName("Nico");
		person.setLastName("Rosberg");
		person.setAge(31);
		personBD.insert(person);

		person.setFirstName("Fernando");
		person.setLastName("Alonso");
		person.setAge(35);
		personBD.insert(person);

		return new ResponseEntity<Person>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/delete")
	public ResponseEntity<Person> delete() {
		personBD.deleteAllPerson();
		return new ResponseEntity<Person>(HttpStatus.OK);
	}

}
