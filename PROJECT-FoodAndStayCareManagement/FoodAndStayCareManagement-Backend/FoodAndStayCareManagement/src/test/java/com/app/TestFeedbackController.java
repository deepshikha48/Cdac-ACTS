package com.app;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.app.controller.UserController;
import com.app.pojos.Feedback;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TestFeedbackController {

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
	public void testGetAllFeedbackListMethod() throws Exception {
		mockMvc.perform(get("/feedback/list")).andExpect(status().isOk()).andDo(print());
	}
	
	@Test
	public void testAddFeedbackMetod() throws Exception {
		Feedback feedback= new Feedback(5, "Awesome!", null, LocalDateTime.now());
		mockMvc.perform(post("/feedback/1").contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(feedback)))
				.andDo(print()).andExpect(status().isCreated()).andReturn();
		
		}*/
}
