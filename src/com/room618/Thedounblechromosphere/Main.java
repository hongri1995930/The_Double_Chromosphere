package com.room618.Thedounblechromosphere;

public class Main {

	static UI ui;
	public static void main(String[] args) {
		try{
			ui = new UI();
			new InputData();
			new Sort();
		}
		catch(Exception e){
		}
	}
}
