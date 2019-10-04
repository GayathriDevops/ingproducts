package com.ing.products.controller;



import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ing.products.service.ProductServiceImpl;



@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class ProductControllerTest {

	MockMvc mockMvc;

	@InjectMocks
	ProductController productController;

	@Mock
	ProductServiceImpl productServiceImpl;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
	}

	@Test
	public void testAccountSummary() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/products/{productId}",1)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isFound());
	}

	
}
