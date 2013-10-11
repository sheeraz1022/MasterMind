package com.example.mastermind;

import java.io.Serializable;

public class category implements Serializable{
	
	private static final long serialVersionUID = 5824834976687841691L;
	private String name;
	
	//category constructors
	public category(String name){
		this.name = name;
	}
	//getter setter for category name
	public void setCategoryName(String name){
		this.name = name;
	}
	
	public String getCategoryName(){
		return this.name;
	}

}
