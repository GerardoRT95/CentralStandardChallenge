package com.spring.centralstandard.app.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Word implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String word;

}
