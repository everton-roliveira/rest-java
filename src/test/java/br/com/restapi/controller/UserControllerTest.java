package br.com.restapi.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;

import br.com.restapi.RestApiApplication;
import br.com.restapi.entity.User;
import br.com.restapi.service.UserService;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestApiApplication.class)
public class UserControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	UserController controller;
	
	@MockBean
	UserService service;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	
	
	@Test
	public void create() throws Exception {
		User user = new User();
		user.setId(1L);
		user.setName("Teste 1");
		user.setGender('M');
		user.setEmail("teste1@email.com");
		user.setIsActive(true);
		
		when(service.save(user)).thenReturn(user);
		
		String requestJson = new Gson().toJson(user);
		this.mockMvc.perform(MockMvcRequestBuilders
				.post("/users")
				.contentType(MediaType.APPLICATION_JSON).content(requestJson.toString()))
		.andExpect(MockMvcResultMatchers.status().isCreated());
	}

}