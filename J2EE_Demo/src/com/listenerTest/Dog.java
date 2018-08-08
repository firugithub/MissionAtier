package com.listenerTest;

public class Dog {

	private String breed;

	public Dog(String breed) {
		super();
		this.breed = breed;
	}

	public String getDogName() {
		if (this.breed.equals("ALS")) {
			return "LUCY";
		} else {
			return "NO Match";
		}
	}
}
