package one.catAndDogQueue;

import java.util.LinkedList;
import java.util.Queue;

import one.catAndDogQueue.entity.Cat;
import one.catAndDogQueue.entity.Dog;
import one.catAndDogQueue.entity.Pet;
import one.catAndDogQueue.entity.TimePet;

public class DogCatQueue {

	private Queue<TimePet> dogQ;
	private Queue<TimePet> catQ;

	public DogCatQueue() {
		dogQ = new LinkedList<TimePet>();
		catQ = new LinkedList<TimePet>();
	}

	public void add(Pet pet) {
		TimePet timePet = new TimePet(pet);
		if (pet.getType().equals("dog")) {
			dogQ.add(timePet);
		} else
			catQ.add(timePet);
	}
	
	public Dog pollDog() {
		if (dogQ.isEmpty())
			throw new RuntimeException("狗空");
		return (Dog)dogQ.poll().getPet();
	}
	
	public Cat pollCat() {
		if (catQ.isEmpty())
			throw new RuntimeException("猫空");
		return (Cat)catQ.poll().getPet();
	}
	
	public boolean isEmpty() {
		return (dogQ.isEmpty() && catQ.isEmpty());
	}

	public boolean isDogEmpty() {
		return (dogQ.isEmpty());
	}
	
	public boolean isCatEmpty() {
		return (catQ.isEmpty());
	}
	
	public Queue<Pet> pollAll() {
		Queue<Pet> result = new LinkedList<Pet>();
		while (!dogQ.isEmpty() && !catQ.isEmpty()) {
			if (dogQ.peek().getTime() >= catQ.peek().getTime())
				result.add(catQ.poll().getPet());
			else
				result.add(dogQ.poll().getPet());
		}
		while (!dogQ.isEmpty()) {
			result.add(dogQ.poll().getPet());
		}
		while (!catQ.isEmpty()) {
			result.add(catQ.poll().getPet());
		}
		return result;
	}
}
