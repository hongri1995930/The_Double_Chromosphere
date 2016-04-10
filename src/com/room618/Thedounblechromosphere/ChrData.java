package com.room618.Thedounblechromosphere;

public class ChrData {
	public int[] red;
	public int blue;
	public String issue;
	
	public ChrData(){
	}
	public ChrData(int[] red,int blue,String issue) {
		this.red = red;
		this.blue = blue;
		this.issue = issue;
	}
	
	public int[] getRed(){
		return red;
	}
	
	public int getBlue(){
		return blue;
	}
	
	public String getIssue(){
		return issue;
	}
}
