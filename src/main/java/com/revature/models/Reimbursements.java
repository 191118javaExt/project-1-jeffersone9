package com.revature.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Reimbursements implements Serializable{
	private String description;
	private int id;
	private double amount;
	private byte[] receipt;
	private ReimbursementStatus status;
	private ReimbursementType type;
	private Employee author;
	private Employee resolver; 
	private int authorId;
	private int resolverId;
	private Timestamp submitted;
	private Timestamp resolved;
	private static final long serialVersionUID = 1L;
	
	//constructors
	public Reimbursements() {
		super();
	}
	
	public Reimbursements(int id, String description, byte[] receipt, double amount, int status, int type,
			int author, int resolver, Timestamp submitted, Timestamp resolved) {
		super();
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.status = ReimbursementStatus.getStatus(status);
		this.type = ReimbursementType.getType(type);
		this.authorId = author;
		this.resolverId = resolver;
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

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	public byte[] getReceipt() {
		return receipt;
	}

	public void setReceipt(byte[] receipt) {
		this.receipt = receipt;
	}
	
	
	
	
}
