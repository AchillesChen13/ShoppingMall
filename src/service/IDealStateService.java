package service;

public interface IDealStateService {
	
	public void requestState(int id,String state);
	
	public void setNextState(IDealStateService iStateService);
}
