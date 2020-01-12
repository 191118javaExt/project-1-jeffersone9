package com.revature.models;

import java.io.Serializable;

public class ReimbursementTemplate implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	public ReimbursementTemplate() {
		super();
	}
	
	public ReimbursementTemplate(int id) {
		super();
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
