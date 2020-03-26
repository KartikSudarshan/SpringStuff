package com.landonhotel.eventsapp.conroller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.landonhotel.eventsapp.controller.QuoteRequestController;
import com.landonhotel.eventsapp.domain.QuoteRequest;

@RunWith(SpringRunner.class)
@WebMvcTest(QuoteRequestController.class)
public class QuoteRequestControllerUnitTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
	private QuoteRequestController quoteRequestController;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetQuoteForm() throws Exception{
		
		mockMvc.perform(get("/newquote"))
				.andExpect(status().is(200))
				.andReturn();
				
		
	}
	
	@Test
	public void testPostQuoteForm() throws Exception{
		
		QuoteRequest aFormBean=new QuoteRequest();
		//simulate the form submit (post)
		mockMvc.perform(post("/newquote",aFormBean))
		.andExpect(status().is(200))
		.andReturn();
		
	}
	
}
