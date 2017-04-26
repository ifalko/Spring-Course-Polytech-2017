package rest.tests;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.nio.charset.Charset;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import ru.spbpu.ics.interfaces.PersonDAO;
import ru.spbpu.ics.main.Main;
import ru.spbpu.ics.objects.Person;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
@WebAppConfiguration
public class PersonControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private PersonDAO personBD;

	private MockMvc mockMvc = webAppContextSetup(webApplicationContext).build();
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@Before
	public void setup() {

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

	}

	@After
	public void tearDown() {
		personBD.drop();
	}

	@Test
	public void getPerson() throws Exception {
		mockMvc.perform(get("/get_person").param("id", "1").contentType(contentType)).andExpect(status().isOk());
	}

	@Test
	public void getPersonParamNull() throws Exception {
		mockMvc.perform(get("/get_person").param("id", "").contentType(contentType)).andExpect(status().isIAmATeapot());
	}

	@Test
	public void personNotFound() throws Exception {
		mockMvc.perform(get("/get_person").param("id", "999").contentType(contentType))
				.andExpect(status().isNotFound());
	}

	@Test
	public void getAllPerson() throws Exception {
		mockMvc.perform(get("/get_all")).andExpect(jsonPath("$", hasSize(4)))
				.andExpect(content().contentType(contentType)).andExpect(status().isOk());

	}

	@Test
	public void postPerson() throws Exception {
		mockMvc.perform(post("/post_person").content("{\"firstName\":\"Kimi\",\"lastName\":\"Raikkonen\",\"age\":37}")
				.contentType(contentType)).andExpect(status().isCreated());

	}

}
