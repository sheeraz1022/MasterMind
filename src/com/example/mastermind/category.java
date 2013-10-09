package com.example.mastermind;

public class category {
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
