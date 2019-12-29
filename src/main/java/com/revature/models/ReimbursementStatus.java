package com.revature.models;

//remember to use enum.ordinal when using services and make sure the db id values
//correspond to the enum values
public enum ReimbursementStatus {
	//Using .ordinal is actually a bad idea because we could run into problems adding more enums
	//in the future, so we will give each enum a value and return it.
	Pending(1), Approved(2), Denied(3);

	private final int value;
	
	 private ReimbursementStatus(int value) {
		this.value = value;
	}
	
	 //for adding a status value to the db
	 public int getValue() {
		 return this.value;
	 }
	 
	 //to get a status from the db value
	public static ReimbursementStatus getStatus(int value) {
		for(ReimbursementStatus status : ReimbursementStatus.values()) {
			if(status.getValue() == value) {
				return status;
			}
		}
		return null;
	}
}
