package com.sag.routes.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.sag.routes.model.ImageUrl;

//Image Service Implementation

@Service
public class ImageServiceImpl implements ImageService {
	 @Override
	public String getCities() {
		File file = new File("C:/chennai");
		String[] directories = file.list(new FilenameFilter() {
			@Override
			public boolean accept(File current, String name) {
				return new File(current, name).isDirectory();
			}
		});
		return Arrays.toString(directories);
	}

	@Override
	public List<ImageUrl> getCityImageUrl(String city, HttpServletRequest request) {
		File dir = new File("C:/chennai/" + city);
		List<ImageUrl> list = new ArrayList<>();
		for (String a : dir.list()) {
			ImageUrl d = new ImageUrl();
			String url = request.getRequestURL().toString();
			d.setUrl(url +"/" +a);
			list.add(d);

		}

		return list;
	}

	@Override
	public byte[] getImage(String city, String image) throws IOException {
		BufferedImage buffIm = ImageIO
				.read(new File("C:/chennai/" + city
						+ "/" + image + ".jpg"));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(buffIm, "jpg", baos);
		byte[] imageData = baos.toByteArray();
		return imageData;
	}
}
