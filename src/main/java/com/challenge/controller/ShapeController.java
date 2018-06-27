package com.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dto.PolygonDTO;
import com.challenge.service.ShapeService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author vinitapenmatsa
 */
@RestController
@RequestMapping("/api/shape")
@ApiResponses(value= {
		@ApiResponse(code =400,message= "Bad Request"),
		@ApiResponse(code =404,message= "Resource Not Found"),
		@ApiResponse(code =500,message= "Internal Server Error")	
})
public class ShapeController {
	
	@Autowired
	ShapeService shapeService;

	@RequestMapping(path = "/triangle/type" , method = RequestMethod.GET )
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String getTriangleType(PolygonDTO polygonDTO) {
	   return shapeService.getPolygonType(polygonDTO);
	}
	
	@RequestMapping(path = "/triangle/isValid" , method = RequestMethod.GET )
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Boolean isValidTriangle(PolygonDTO polygonDTO){
		return shapeService.isValidPolygon(polygonDTO);		
	}	
	
}
