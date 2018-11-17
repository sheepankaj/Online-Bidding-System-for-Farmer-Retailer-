package models.entity;

public class NoPriority implements Priority {

	int priority = -1;
	String priorityType = "nopriority";
	
	public NoPriority(String type) {
		this.priorityType = type;
	}
	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return priority;
	}

}
