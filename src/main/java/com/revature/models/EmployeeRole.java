package com.revature.models;

public enum EmployeeRole {
	Employee(1), FinanceManager(2);

	private final int value;
	
	EmployeeRole(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public static EmployeeRole getRole(int value) {
		for(EmployeeRole role : EmployeeRole.values()) {
			if(role.getValue() == value) {
				return role;
			}
		}
		return null;
	}
	
}
