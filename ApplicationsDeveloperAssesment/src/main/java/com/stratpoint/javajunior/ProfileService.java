package com.stratpoint.javajunior;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ProfileService {

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * 
	 * @param url
	 * @return
	 */
	private String doGetObject(String url) {
		String result = null;
		try {
			result = restTemplate.getForObject(url, String.class);
		} catch (RestClientException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	/**
	 * get all
	 * 
	 * @return
	 */
	public String getAllProfile() {
		String url = "http://s3-ap-southeast-1.amazonaws.com/fundo/js/profiles.json";
		return doGetObject(url);
	}

	public String getData(String jsonStr) {
		String newJsonStr = "{\"aaData\" : " + jsonStr + "}";
		return newJsonStr;
	}
	
	public Profile getProfile(String profileJson){
		Profile profile = new Profile();
		
		
		
		return profile;
	}

}