package models.entity;

public class Gold implements Priority{

	int priority = 2;
	String priorityType = "gold";
	
	public Gold(String type) {
		this.priorityType = type;
	}
	
	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return priority;
	}
	
	
}
