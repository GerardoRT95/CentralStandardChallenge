package com.spring.centralstandard.app.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.centralstandard.app.Factory;
import com.spring.centralstandard.app.model.Word;
import com.spring.centralstandard.app.service.impl.CentralStandardService;

@WebMvcTest(CentralStandardController.class)
public class CentralStandardControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CentralStandardService service;
	
	@Test
	public void pigLatinTest() throws Exception {
		Word request = Factory.createWord();
		Word word = new Word();
		word.setWord(Mockito.anyString());
		Mockito.when(service.pigLatin(request)).thenReturn(word);
		mockMvc.perform(post("/centralStandard/pigLatin", request)
				.contentType(MediaType.APPLICATION_JSON)
				.content(toJsonString(request)))
			.andExpect(status().isOk());
	}

	public static String toJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
}
