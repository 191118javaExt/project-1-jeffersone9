package com.revature.models;

//remember to use enum.ordinal when using services and make sure the db id values
//correspond to the enum values
public enum ReimbursementType {
	//Using .ordinal is actually a bad idea because we could run into problems adding more enums
	//in the future, so we will give each enum a value and return it.
	LODGING(1), FOOD(2), TRAVEL(3), OTHER(4);
	
	private final int value;
	
	private ReimbursementType(int value) {
		this.value = value;
	}
	
	//for getting an int value to return to the db
	public int getValue() {
		return this.value;
	}
	
	//for getting a type value to return to the app from the db
	public static ReimbursementType getType(int value) {
		for(ReimbursementType type : ReimbursementType.values()) {
			if(type.getValue() == value) {
				return type;
			}
		}
		return null;
	}
}
