package com.sag.routes.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sag.routes.model.ImageUrl;

//Image Service

public interface ImageService {
	
	//Get All Cities
	String getCities();
	//Get All the Image Url for given City
	List<ImageUrl> getCityImageUrl(String cityname, HttpServletRequest request);
	//Get the image for given URL
	byte[] getImage(String cityname, String imagename) throws IOException;
}
