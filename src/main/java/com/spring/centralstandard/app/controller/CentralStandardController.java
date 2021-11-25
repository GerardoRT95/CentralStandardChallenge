package com.spring.centralstandard.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.centralstandard.app.model.Word;
import com.spring.centralstandard.app.service.ICentralStandardService;

@RestController
@RequestMapping("/centralStandard")
public class CentralStandardController {
	
	@Autowired
	private ICentralStandardService service;
	
	@PostMapping("/pigLatin")
	public Word pigLatin(@RequestBody Word request) {
		Word response = null;
		if(request != null) {
			response = service.pigLatin(request);
		}
		return response;
	}

}
