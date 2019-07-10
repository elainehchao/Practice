package com.prep.Queues;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

import com.prep.Queues.Animal.AnimalType;

public class AnimalShelter {
	private List<Animal> dogs;
	
	private List<Animal> cats;
	
	public AnimalShelter() {
		dogs = new LinkedList<>();
		cats = new LinkedList<>();
	}
	
	public void dropOffAnimal(Animal animal) {
		animal.dropOffAtShelter();
		if (animal.getType() == AnimalType.DOG) {
			dogs.add(animal);
		} else if (animal.getType() == AnimalType.CAT) {
			cats.add(animal);
		}
	}
	
	public Animal adopt(AnimalType type) {
		if (type == null) {
			return getOldestPet();
		}
		Animal pet = null;
		if (type == AnimalType.DOG) {
			pet = dogs.get(0);
			dogs.remove(0);
		} else if (type == AnimalType.CAT) {
			pet = cats.get(0);
			cats.remove(0);
		}
		return pet;
	}
	
	private Animal getOldestPet() {
		Instant oldestDog = dogs.get(0).getArrivalTime();
		Instant oldestCat = cats.get(0).getArrivalTime();
		Animal toAdopt = null;
		if (oldestDog.isBefore(oldestCat)) {
			toAdopt = dogs.get(0);
			dogs.remove(0);
		} else {
			toAdopt = cats.get(0);
			cats.remove(0);
		}
		return toAdopt;
	}
	
//	List<Animal> shelterList;
//	
//	public AnimalShelter() {
//		shelterList = new LinkedList<>();
//	}
//	
//	public void dropOffAnimal(Animal animal) {
//		animal.dropOffAtShelter();
//		shelterList.add(animal);
//	}
//	
//	public Animal adopt(AnimalType type) {
//		int index = getOldest(type);
//		Animal animal = shelterList.get(index);
//		shelterList.remove(index);
//		return animal;
//	}
//	
//	/**
//	 * Gets the oldest pet index based on arrival time. 
//	 * 
//	 * If the type is null or no pet of that type exists, 0 is returned
//	 * 
//	 * @param type The type of pet
//	 * @return The order index of the pet
//	 */
//	public int getOldest(AnimalType type) {
//		if (type == null) {
//			return 0;
//		}
//		
//		for (int i = 0; i < shelterList.size(); i++) {
//			if (shelterList.get(i).getType() == type) {
//				return i;
//			}
//		}
//		return 0;
//	}
}
