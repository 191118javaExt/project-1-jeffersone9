package com.revature.models;

public enum EmployeeRole {
	Employee(1, "employee"), FinanceManager(2, "finance_manager");

	private final int value;
	private final String desc;
	EmployeeRole(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public String getDescription() {
		return this.desc;
	}
	
	public static EmployeeRole getRole(int value) {
		for(EmployeeRole role : EmployeeRole.values()) {
			if(role.getValue() == value) {
				return role;
			}
		}
		return null;
	}
	
	public static EmployeeRole getRole(String value) {
		for(EmployeeRole role : EmployeeRole.values()) {
			if(role.getDescription() == value) {
				return role;
			}
		}
		return null;
	}

	
}
