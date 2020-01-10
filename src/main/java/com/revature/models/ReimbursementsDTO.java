package com.revature.models;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ReimbursementsDTO implements Serializable{
	private String description;
	private int id;
	private double amount;
	private ReimbursementStatus status;
	private ReimbursementType type;
	private Employee author;
	private Employee resolver; 
	private String submitted;
	private String resolved;
	private static final long serialVersionUID = 1L;
	
	//constructors
	public ReimbursementsDTO() {
		super();
	}
	
	public ReimbursementsDTO(int id, String description, double amount, ReimbursementStatus status, ReimbursementType type,
			Employee author, Employee resolver, String submitted, String resolved) {
		super();
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.status = status;
		this.type = type;
		this.author = author;
		this.resolver = resolver;
		this.submitted = submitted;
		this.resolved = resolved;
	}
	//getters and setters
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public ReimbursementStatus getStatus() {
		return status;
	}
	public void setStatus(ReimbursementStatus status) {
		this.status = status;
	}
	public ReimbursementType getType() {
		return type;
	}
	public void setType(ReimbursementType type) {
		this.type = type;
	}
	public Employee getAuthor() {
		return author;
	}
	public void setAuthor(Employee author) {
		this.author = author;
	}
	public Employee getResolver() {
		return resolver;
	}
	public void setResolver(Employee resolver) {
		this.resolver = resolver;
	}

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}

	public String getResolved() {
		return resolved;
	}

	public void setResolved(String resolved) {
		this.resolved = resolved;
	}
	
}
