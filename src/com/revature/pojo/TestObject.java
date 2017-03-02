package com.revature.pojo;

public class TestObject {

	private String name;
	private int age;
	
	public TestObject(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public TestObject(){
		name = "nothing";
		age = 0;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	@Override
	public String toString(){
		String string = "Name: " + name + "\nAge: " + age;
		return string;
	}
	
}
