package models.entity;

public class Silver implements Priority{

	int priority = 3;
	String priorityType = "silver";
	
	public Silver(String type) {
		this.priorityType = type;
	}
	
	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return priority;
	}
	
	

}
