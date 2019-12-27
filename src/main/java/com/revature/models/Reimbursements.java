package com.revature.models;

public class Reimbursements {
	private String description;
	private int id;
	private double amount;
	private ReimbursementStatus status;
	private ReimbursementType type;
	private Users author;
	private Users resolver;
	
	
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
	public Users getAuthor() {
		return author;
	}
	public void setAuthor(Users author) {
		this.author = author;
	}
	public Users getResolver() {
		return resolver;
	}
	public void setResolver(Users resolver) {
		this.resolver = resolver;
	}
	
	
}
