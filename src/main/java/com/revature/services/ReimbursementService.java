package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursements;
import com.revature.models.ReimbursementsDTO;
import com.revature.repositories.ReimbursementDAOImpl;

public class ReimbursementService {
	
	public static List<Reimbursements> findAll(){
		return new ReimbursementDAOImpl().findAll();
	}
	
	public static Reimbursements findById(int id) {
		return new ReimbursementDAOImpl().findById(id);
	}
	
	public static boolean insert(Reimbursements r) {
		return new ReimbursementDAOImpl().insert(r);
	}
	
	public static ReimbursementsDTO convertToDTO(Reimbursements r) {
		return new ReimbursementsDTO(r.getId(), r.getDescription(), r.getReceipt(), r.getAmount(),
									r.getStatus(), r.getType(), r.getAuthor(), r.getResolver(),
									r.getSubmitted().toString(), r.getResolved().toString());
	}
}
