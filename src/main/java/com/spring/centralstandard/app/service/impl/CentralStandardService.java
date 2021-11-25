package com.spring.centralstandard.app.service.impl;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.spring.centralstandard.app.model.Word;
import com.spring.centralstandard.app.service.ICentralStandardService;
import com.spring.centralstandard.app.utils.Constants;
import com.spring.centralstandard.app.utils.Vowels;

@Service
public class CentralStandardService implements ICentralStandardService {

	@Override
	public Word pigLatin(Word request) {
		Word response = null;
		if(request != null) {
			response = translate(request);
		}
		return response;
	}
	
	private Word translate(Word request) {
		Word response = new Word();
		if(!isVowel(request.getWord().charAt(0))) {
			//Second case, The word starts with two consonants
			if(!isVowel(request.getWord().charAt(1))) {
				response.setWord(secondCase(new StringBuilder(request.getWord())));
			}//First case, The word starts with a consonant and then a vowel
			else {
				response.setWord(firstCase(new StringBuilder(request.getWord())));
			}
		}//Third case, when the word starts with a vowel
		else {
			response.setWord(thirdCase(new StringBuilder(request.getWord())));
		}
		return response;
	}
	
	private String firstCase(StringBuilder stringAux) {
		String aux = stringAux.substring(0, 1);
		stringAux.delete(0, 1);
		stringAux.append(aux);
		stringAux.append(Constants.AY);
		return stringAux.toString();
	}
	
	private String secondCase(StringBuilder stringAux) {
		String aux = stringAux.substring(0, 2);
		stringAux.delete(0, 2);
		stringAux.append(aux);
		stringAux.append(Constants.AY);
		return stringAux.toString();
	}
	
	private String thirdCase(StringBuilder stringAux) {
		stringAux.append(Constants.WAY);
		return stringAux.toString();
	}
	
	/*	Check if the given letter is a vowel
		Return true if is a vowel, false if not*/
	private boolean isVowel(char aux) {
		return Arrays.stream(Vowels.values()).anyMatch(vowel -> vowel.toString().charAt(0) == aux);
	}

}
