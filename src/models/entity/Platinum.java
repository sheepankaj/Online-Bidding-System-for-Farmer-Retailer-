package models.entity;

public class Platinum implements Priority{

	int priority = 1;
	String priorityType = "platinum";
	
	public Platinum(String type) {
		this.priorityType = type;
	}
	@Override
	public int getPriority() {
		
		return priority;
	}
	
	
}
