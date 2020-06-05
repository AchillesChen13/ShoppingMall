package model;

import entity.Commodity;
import entity.CommodityType;

public class CommodityInvoker {
	
	private CommodityCommand command;
	
	public void setCommand(CommodityCommand command) {
		this.command = command;
	}
	
	public void startExcuteCommand(Commodity comm) {
		command.excuteType(comm);
	}
}
