package com.prep.Queues;

import java.time.Instant;

public abstract class Animal {
	
	public enum AnimalType {
		CAT,
		DOG
	}
	
	private String name;
	
	private Instant arrivalTime;
	
	private AnimalType animalType;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public AnimalType getType() {
		return this.animalType;
	}
	
	public void setType(AnimalType type) {
		this.animalType = type;
	}
	
	public Instant getArrivalTime() {
		return this.arrivalTime;
	}
	
	public void dropOffAtShelter() {
		this.arrivalTime = Instant.now();
	}
}
