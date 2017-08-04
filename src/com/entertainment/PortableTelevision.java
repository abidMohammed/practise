package com.entertainment;

public class PortableTelevision extends Television{

	private int rechargeLevel=10;

	public int getRechargeLevel() {
		return rechargeLevel;
	}

	public void setRechargeLevel(int rechargeLevel) {
		this.rechargeLevel = rechargeLevel;
	}
	
	@Override
	public String toString() {
		return "PortableTelevision [rechargeLevel=" + rechargeLevel +" " + super.toString()+"]";
	}


}
