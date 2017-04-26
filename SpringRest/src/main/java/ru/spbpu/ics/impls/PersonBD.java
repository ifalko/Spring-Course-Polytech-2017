package ru.spbpu.ics.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import ru.spbpu.ics.interfaces.PersonDAO;
import ru.spbpu.ics.objects.Person;

@Component("personBD")
public class PersonBD implements PersonDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Person> findAll() {
		String sql = "SELECT * FROM PERSON";
		List<Person> person = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Person>(Person.class));

		return person;
	}

	public void deleteByID(int id) {
		String deleteByID = "DELETE FROM person WHERE id = ?";
		jdbcTemplate.update(deleteByID, id);
	}

	public void updateByID(int id, Person person) {
		String updateByID = "UPDATE person SET first_name = ?, last_name = ?, age = ? where id = ?";
		jdbcTemplate.update(updateByID, person.getFirstName(), person.getLastName(), person.getAge(), id);
	}

	public Person getPersonByID(int id) {
		String sql = "SELECT * FROM PERSON WHERE ID = ?";
		Person person = jdbcTemplate.queryForObject(sql, new Integer[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));
		return person;
	}

	public void deleteAllPerson() {
		String deleteAllPerson = "DELETE FROM PERSON";
		jdbcTemplate.update(deleteAllPerson);
	}

	public void drop() {
		String drop = "drop table if exists person";
		jdbcTemplate.execute(drop);
	}

	public void create() {
		String create = "create table person " + "(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
				+ "first_name TEXT NOT NULL, " + "last_name TEXT NOT NULL, " + "age INTEGER);";

		jdbcTemplate.execute(create);
	}

	public void insert(Person person) {
		String sql = "insert into person (first_name, last_name, age) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] { person.getFirstName(), person.getLastName(), person.getAge() });
	}

}
