package com.revature.repositories;

import java.util.List;

import com.revature.models.Reimbursements;

public interface ReimbursementDAO {
	public List<Reimbursements> findAll();
	public Reimbursements findById(int id);
	public boolean insert(Reimbursements r);
	public boolean update(Reimbursements r, int id);
}
