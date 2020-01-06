package com.revature.models;

//remember to use enum.ordinal when using services and make sure the db id values
//correspond to the enum values
public enum ReimbursementStatus {
	//Using .ordinal is actually a bad idea because we could run into problems adding more enums
	//in the future, so we will give each enum a value and return it.
	Pending(1, "pending"), Approved(2, "approved"), Denied(3, "denied");

	private final int value;
	private final String desc;
	 private ReimbursementStatus(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	 //for adding a status value to the db
	 public int getValue() {
		 return this.value;
	 }
	 
	 public String getDescription() {
		 return this.desc;
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
	
	public static ReimbursementStatus getStatus(String value) {
		for(ReimbursementStatus status : ReimbursementStatus.values()) {
			if(status.getDescription() == value) {
				return status;
			}
		}
		return null;
	}
}
