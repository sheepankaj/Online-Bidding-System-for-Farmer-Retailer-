package models.entity;

public class NoPriority implements Priority {

	int priority = -1;
	
	
	public NoPriority(String type) {
		
	}
	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return priority;
	}

}
