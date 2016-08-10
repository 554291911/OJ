package one.catAndDogQueue.entity;

public class TimePet {
	
	private Pet pet;
	private long time;

	public TimePet(Pet pet) {
		this.pet = pet;
		this.time = System.currentTimeMillis();
	}

	public Pet getPet() {
		return pet;
	}
	
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
	public long getTime() {
		return time;
	}
	
	public void setTime(long time) {
		this.time = time;
	}

}
