package com.stratpoint.javajunior;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/profile")
@Controller
public class ProfileController {

	@Autowired
	private ProfileService profileService;

	@RequestMapping(value = "/redirect", produces = "text/html")
	public String profileHome(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam("picture") String picture, @RequestParam("profile") String profile,
			@RequestParam("email") String email, @RequestParam("phone") String phone,
			@RequestParam("address") String address, @RequestParam("age") String age,
			@RequestParam("balance") String balance, Model uiModel) {
		uiModel.addAttribute("id", id);
		uiModel.addAttribute("name", name);
		uiModel.addAttribute("picture", picture);
		uiModel.addAttribute("profile", profile);
		uiModel.addAttribute("email", email);
		uiModel.addAttribute("phone", phone);
		uiModel.addAttribute("address", address);
		uiModel.addAttribute("age", age);
		uiModel.addAttribute("balance", balance);
		return "profile/redirect";
	}

	@RequestMapping(value = "/all", produces = "text/html")
	public ResponseEntity<String> getAllProfile(Model uiModel) {
		String result = profileService.getData(profileService.getAllProfile());

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		return new ResponseEntity<String>(result, headers, HttpStatus.OK);
	}

}
