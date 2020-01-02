package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursements;
import com.revature.repositories.ReimbursementDAOImpl;

public class ReimbursementService {
	private static ReimbursementDAOImpl repository = new ReimbursementDAOImpl();
	
	public static List<Reimbursements> findAll(){
		return repository.findAll();
	}
	
	public static Reimbursements findById(int id) {
		return repository.findById(id);
	}
	
	public static boolean insert(Reimbursements r) {
		return repository.insert(r);
	}
}
