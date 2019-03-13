package Locations;

import interfaces.Payable;
import interfaces.Visitable;

public class Museum extends Node implements Payable, Visitable {
	int entryFee;
	String openingHour = new String();
	String closingHour = new String();
	
	public Museum(String name) {
		super.setName(name);
		Visitable.super.defaultSchedule();
	}
	
	@Override
	public void setName(String name) {
		super.setName(name);
	}
	
	@Override
	public String  getName() {
		return this.getName();
	}
	
	@Override
	public void setEntryFee(int entryFee) {
		this.entryFee=entryFee;
	}
	
	@Override
	public int getEntryFee() {
		return this.entryFee;
	}
	
	@Override
	public void setOpeningHour(String openingHour) {
		this.openingHour=openingHour;
	}
	
	@Override
	public String getOpeningHour() {
		return this.openingHour;
	}

	@Override
	public void setClosingHour(String closingHour) {
		this.closingHour = closingHour;
	}

	public String getClosingHour() {
		return closingHour;
	}

	@Override
	public void setAddress(String address) {
		super.setAddress(address);
	}
	
	@Override
	public String getAddress() {
		return super.getAddress();
	}

	@Override
	public boolean isVisited (Node n) {return super.isVisited(n);}
}
