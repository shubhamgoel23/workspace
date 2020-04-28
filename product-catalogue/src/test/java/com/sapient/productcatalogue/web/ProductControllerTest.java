package com.sapient.productcatalogue.web;

import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.sapient.productcatalogue.repositories.ProductRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ProductRepository productRepository;

	@Test
	public void listProducts() throws Exception {
		mockMvc.perform(get("/api/v1/product").param("price", "100").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.content[0].price", is("100.00")));
	}

	@Test
	public void getProductBySku() throws Exception {
		mockMvc.perform(get("/api/v1/product/sku/" + "1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.sku", is("1")))
				.andExpect(jsonPath("$.name", is("ProductNotFound")));

	}
	
	@Test
	public void findProductBySku() throws Exception {
//		given
//		System.out.println(productRepository.findAllBySku("zaq-wsx-cde").getBrand());
		assertEquals("test", productRepository.findAllBySku("zaq-wsx-cde").getBrand());
	}
}
