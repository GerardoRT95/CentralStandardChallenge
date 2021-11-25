package com.spring.centralstandard.app.service.impl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.centralstandard.app.Factory;
import com.spring.centralstandard.app.model.Word;

@SpringBootTest
public class CentralStandardServiceTest {
	
	@Autowired
	private CentralStandardService service;
	
	@Test
	public void pigLatinFirstCaseTest() {
		Word request = Factory.createWord();
		request.setWord("Happy");
		Word res = service.pigLatin(request);
		Assert.assertEquals("appyHay", res.getWord());
		System.out.println("res = " + res);
	}
	
	@Test
	public void pigLatinSecondCaseTest() {
		Word request = Factory.createWord();
		request.setWord("Child");
		Word res = service.pigLatin(request);
		Assert.assertEquals("ildChay", res.getWord());
		System.out.println("res = " + res);
	}
	
	@Test
	public void pigLatinThirdCaseTest() {
		Word request = Factory.createWord();
		request.setWord("Awesome");
		Word res = service.pigLatin(request);
		Assert.assertEquals("Awesomeway", res.getWord());
		System.out.println("res = " + res);
	}

}
