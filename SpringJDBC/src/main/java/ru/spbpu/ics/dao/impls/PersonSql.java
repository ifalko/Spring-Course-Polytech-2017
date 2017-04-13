package ru.spbpu.ics.dao.impls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import ru.spbpu.ics.dao.interfaces.PersonDao;
import ru.spbpu.ics.dao.interfaces.PersonTable;
import ru.spbpu.ics.dao.objects.Person;

@Component("personSQL")
public class PersonSql implements PersonDao, PersonTable {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertWithJDBC(Person person) {

		Connection conn = null;

		try {
			Class.forName("org.sqlite.JDBC");
			String url = "jdbc:sqlite:db/SpringDB.db";
			conn = DriverManager.getConnection(url, "", "");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String sql = "insert into person (first_name, last_name, age) VALUES (?, ?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, person.getFirstName());
			ps.setString(2, person.getLastName());
			ps.setInt(3, person.getAge());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public void insert(Person person) {
		String sql = "insert into person (first_name, last_name, age) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] {person.getFirstName(), person.getLastName(), person.getAge()});
	}

	// *************************************************************************
	// *************************************************************************
	// *************************************************************************	

	@Override
	public List<Person> findAll() {
		String sql = "SELECT * FROM PERSON";
		List<Person> person = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Person>(Person.class));

		return person;
	}

	@Override
	public void deleteByID(int id) {
		String deleteByID = "DELETE FROM person WHERE id = ?";
		jdbcTemplate.update(deleteByID, id);
	}

	@Override
	 public void updateByID(int id, Person person) {
	 String updateByID = "UPDATE person SET first_name = ?, last_name = ?, age = ? where id = ?";
	 jdbcTemplate.update(updateByID, person.getFirstName(),
	 person.getLastName(), person.getAge(), id);
	 }

	@Override
	public Person getPersonByID(int id) {
		String sql = "SELECT * FROM PERSON WHERE ID = ?";
		Person person = jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));

		return person;
	}

	@Override
	public void deleteAllPerson() {
		String deleteAllPerson = "DELETE FROM PERSON";
		jdbcTemplate.update(deleteAllPerson);
	}
	
	// *************************************************************************
	// *************************************************************************
	// *************************************************************************
	
	@Override
	public void drop() {
		String drop = "drop table if exists person";
		jdbcTemplate.execute(drop);
	}
	
	@Override
	public void create() {
		String create = "create table person " + "(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
				+ "first_name TEXT NOT NULL, " + "last_name TEXT NOT NULL, " + "age INTEGER);";
		
		jdbcTemplate.execute(create);
	}

}
