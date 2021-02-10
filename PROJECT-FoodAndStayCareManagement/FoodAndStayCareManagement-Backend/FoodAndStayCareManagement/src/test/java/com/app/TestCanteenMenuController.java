package com.app;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.app.controller.CanteenMenuController;
import com.app.pojos.Day;
import com.app.pojos.MealType;
import com.app.pojos.MenuItem;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TestCanteenMenuController {

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
	public void testGetTodaysMenuMehtod() throws Exception {
		MvcResult result=mockMvc.perform(get("/menu")).andDo(print()).andReturn();
		Boolean bool=result.getResponse().getContentAsString().isEmpty();
		if(bool)
			assertEquals(204, result.getResponse().getStatus());
		else
			assertEquals(200, result.getResponse().getStatus());
	}
	
	@Test
	public void testGetMenuListMethod() throws Exception {
		MvcResult result=mockMvc.perform(get("/menu/WEDNESDAY/LUNCH")).andDo(print()).andReturn();
		Boolean bool=result.getResponse().getContentAsString().isEmpty();
		if(bool)
			assertEquals(204, result.getResponse().getStatus());
		else
			assertEquals(200, result.getResponse().getStatus());
	}
	
	@Test
	public void testDeleteMenuItemDetails() throws Exception {
		MvcResult result=mockMvc.perform(delete("/menu/13")).andDo(print()).andReturn();
		if(result.getResponse().getStatus()==200)
			assertEquals(200, result.getResponse().getStatus());
		else
			assertEquals(400, result.getResponse().getStatus());
	}
	
	@Test
	public void testUpdateMenuItemDetailsMethod() throws Exception {
		
		MenuItem item=new MenuItem("Rajma Chawal", 100, "good food", 50, MealType.LUNCH, Day.FRIDAY);
		item.setId(1000);
		mockMvc.perform(put("/menu").contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(item)))
				.andDo(print()).andExpect(status().isForbidden()).andReturn();	
	}
	
	@Test
	public void testAddNewMenuItemMethod() throws Exception {
		
		MenuItem item=new MenuItem("Rajma Chawal", 100, "good food", 50, MealType.LUNCH, Day.FRIDAY);
		mockMvc.perform(post("/menu").contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(item)))
				.andDo(print()).andExpect(status().isCreated()).andReturn();
		
		}
	
	@Test
	public void testGetMenuListMethod() throws Exception {
		MvcResult result=mockMvc.perform(get("/menu/id/1000")).andDo(print()).andReturn();
		Boolean bool=result.getResponse().getContentAsString().isEmpty();
		if(bool)
			assertEquals(400, result.getResponse().getStatus());
		else
			assertEquals(200, result.getResponse().getStatus());
	}*/
	
	
	
	
	

}
