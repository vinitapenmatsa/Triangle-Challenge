package com.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.challenge.exception.UnsupportedShapeException;

import com.challenge.dto.PolygonDTO;
import com.challenge.service.ShapeService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SpringRunner.class)
@WebMvcTest(value = ShapeController.class, secure = false)
public class ShapeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ShapeService shapeService;
	
	@Test
	public void getTriangleTypeTest() throws Exception{
		//test get triangle type end point
		when(shapeService.getPolygonType(any(PolygonDTO.class))).thenReturn("ISOSCELES");

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/shape/triangle/type?sides=3&sides=3&sides=4");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	
		assertEquals("ISOSCELES", result.getResponse().getContentAsString());

		
	}
	
	@Test
	public void unsupportedShapeExceptionTest() throws Exception {
		//test Rest Exception handler for Unsupported shape exception
		when(shapeService.getPolygonType(any(PolygonDTO.class))).thenThrow(UnsupportedShapeException.class);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/shape/triangle/type?sides=3&sides=3&sides=4");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		assertTrue(result.getResolvedException() instanceof UnsupportedShapeException);	
	}
	
	@Test
	public void exceptionTest() throws Exception {
		//test Rest Exception handler for all other runtime exceptions
		when(shapeService.getPolygonType(any(PolygonDTO.class))).thenThrow(NullPointerException.class);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/shape/triangle/type?sides=3&sides=3&sides=4");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
        assertTrue(result.getResolvedException() instanceof NullPointerException);		
	}
	

}
