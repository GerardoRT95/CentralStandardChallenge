package com.spring.centralstandard.app;

import com.spring.centralstandard.app.model.Word;

public class Factory {
	
	public static Word createWord() {
		Word res = new Word();
		res.setWord("SomeWord");
		return res;
	}

}
