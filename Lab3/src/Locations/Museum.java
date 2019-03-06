package Locations;

import interfaces.Payable;
import interfaces.Visitable;

public class Museum extends Node implements Payable, Visitable {
	int entryFee;
	String openingHour = new String;
	
	public Museum(String name) {
		super.setName(name);
	}
	
	@Override
	public void setName(String name) {
		super.setName(name);
	}
	
	@Override
	public void getName() {
		return this.getName();
	}
	
	@Override
	public void setEntryFee(int entryFee) {
		this.entryFee=entryFee;
	}
	
	@Override
	public void getEntryFee() {
		return this.entryFee;
	}
	
	@Override
	public void setOpeningHour(String openingHour) {
		this.openingHour=openingHour;
	}
	
	@Override
	public void getOpeningHour() {
		return this.openingHour;
	}
	
	@Override
	public void setAddress(String address) {
		super.setAddress(address);
	}
	
	@Override
	public void getAddress() {
		return super.getAddress();
	}
}
