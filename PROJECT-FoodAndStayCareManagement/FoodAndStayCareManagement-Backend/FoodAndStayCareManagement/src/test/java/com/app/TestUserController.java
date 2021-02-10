package com.app;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;
import com.app.controller.UserController;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TestUserController {
	@LocalServerPort
	private int serverPort;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private UserController controller;
	/*@Test
	void sanityTest() {
		assertNotNull(controller);
	}


	@Test
	public void testAddNewUserMetod() throws Exception {
		
		User user= new User("Ram","Singh","rammsyingiih@gmail.com","7089998989","Ram@123",Role.STUDENT);
		MvcResult result = mockMvc
				.perform(post("/user").contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(user)))
				.andDo(print()).andExpect(status().isCreated()).andReturn();
		
		//user.setId(15);
		 assertEquals(201, result.getResponse().getStatus());
		//assertEquals(mapper.writeValueAsString(user), result.getResponse().getContentAsString());
	}
	@Test
	public void testAuthenticateUserMethod() throws Exception {
		
		User user= new User("deepshikhagurjar040895@gmail.com","Deep@123");
		MvcResult result = mockMvc
				.perform(post("/user/login").contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(user)))
				.andDo(print()).andExpect(status().isOk()).andReturn();
		
		assertEquals(200, result.getResponse().getStatus());
		
	}
	
	@Test
	public void testDeleteUserByIdMethod() throws Exception {
		mockMvc.perform(delete("/user/1000")).andDo(print()).andExpect(status().isBadRequest()).andReturn();
	}
	
	@Test
	public void testUpdateProductDetailsMethod() throws Exception {
		
		User user= new User("Ram","Singh","ramsingh@gmail.com","9999998989","Ram@123",Role.STUDENT);
		user.setId(1000);
		mockMvc.perform(put("/user").contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(user)))
				.andDo(print()).andExpect(status().isForbidden()).andReturn();	
	}
	
	@Test
	public void testGetUserListMethod() throws Exception {
		mockMvc.perform(get("/user/list/STUDENT")).andExpect(status().isOk()).andDo(print());
	}*/
	
}
