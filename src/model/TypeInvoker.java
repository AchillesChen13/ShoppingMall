package model;

import entity.CommodityType;

public class TypeInvoker {
	
	private TypeCommand typeCommand;
	
	public void setCommand(TypeCommand typeCommand) {
		this.typeCommand = typeCommand;
	}
	
	public void startExcuteCommand(CommodityType type) {
		typeCommand.excuteType(type);
	}
}
