package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import com.app.controller.CanteenMenuController;
import com.app.pojos.Day;
import com.app.pojos.MealType;
import com.app.pojos.MenuItem;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TestOrderController {

	@LocalServerPort
	private int serverPort;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private CanteenMenuController controller;
	/*@Test
	void sanityTest() {
		assertNotNull(controller);
	}
	
	@Test
	public void testOrderListOfMenuMethod() throws Exception {
		
		MenuItem[] menuItems= {new MenuItem("Rajma Chawal", 1000, "good food", 50, MealType.LUNCH, Day.FRIDAY)};
		menuItems[0].setId(15);
		MvcResult result=mockMvc.perform(post("/order/1").contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(menuItems)))
				.andDo(print()).andReturn();
		
		Boolean bool=result.getResponse().getContentAsString().isEmpty();
		if(bool)
			assertEquals(406, result.getResponse().getStatus());
		else
			assertEquals(200, result.getResponse().getStatus());
		
		}*/
}
