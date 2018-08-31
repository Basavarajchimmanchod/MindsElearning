package com.sag.routes.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sag.routes.model.ImageUrl;
import com.sag.routes.service.ImageService;

//Rest Controller with all REST endpoints
@CrossOrigin
@RestController
@RequestMapping("/cities")
public class ImageController {
	
	/*
	 * @GetMapping--specifies GET method
	 * 
	 */
	@Autowired
	private ImageService imageService;
	@GetMapping("")// Sample: localhost:8080/rest/city
	public String getCities() {
		String folders=imageService.getCities();
		return folders;
	}

	@GetMapping("/{city}") //Sample: localhost:8080/rest/city/Guindy
	public List<ImageUrl> getCity(@PathVariable("city") String city, HttpServletRequest request) {
		List<ImageUrl> cityimages=imageService.getCityImageUrl(city,request);
		return cityimages;
	}
   
	@GetMapping(value = "/{city}/{image}")
	public byte[] getImage(@PathVariable("city") String city, @PathVariable("image") String image)
			throws IOException {
		byte[] images=imageService.getImage( city, image);
				return images;
	}
}
