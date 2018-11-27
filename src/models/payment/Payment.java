package models.payment;

public class Payment {

	private IPaymentStates state;
	private StringBuilder builder = new StringBuilder();
	
	public Payment()
	{
		state = new Initiated();
	}
	
	public void previousState() {
        state.prev(this);
    }
 
    public void nextState() {
        state.next(this);
    }
 
    public void printStatus() {
        state.printStatus(this);
    }

	public StringBuilder getBuilder() {
		return builder;
	}

	public IPaymentStates getState() {
		return state;
	}

	public void setState(IPaymentStates state) {
		this.state = state;
	}
    
	
    
}
