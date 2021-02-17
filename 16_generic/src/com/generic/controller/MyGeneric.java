package com.generic.controller;

public class MyGeneric<T> {

	private T temp;
	
	public MyGeneric() {
		// TODO Auto-generated constructor stub
	}

	public MyGeneric(T temp) {
		super();
		this.temp = temp;
	}

	public T getTemp() {
		return temp;
	}

	public void setTemp(T temp) {
		this.temp = temp;
	}
	
	
}
