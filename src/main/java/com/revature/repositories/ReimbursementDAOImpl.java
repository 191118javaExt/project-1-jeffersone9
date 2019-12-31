package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Reimbursements;
import com.revature.util.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO {
	
	private static Logger logger = Logger.getLogger(ReimbursementDAOImpl.class);
	@Override
	public List<Reimbursements> findAll() {
		List<Reimbursements> reimbursements = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM project1.ers_reimbursement";
			//use prepared statements to prevent sql injection
			PreparedStatement stmnt = conn.prepareStatement(sql);
			ResultSet rs = stmnt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("reimb_id");
				double amount = rs.getDouble("reimb_amount");
				Timestamp submitted = rs.getTimestamp("reimb_submitted");
				Timestamp resolved = rs.getTimestamp("reimb_resolved");
				String description = rs.getString("reimb_description");
				byte[] receipt = rs.getBytes("reimb_receipt");
				int authorId = rs.getInt("reimb_author");
				int resolverId = rs.getInt("reimb_resolver");
				int status = rs.getInt("reimb_status_id");
				int type = rs.getInt("reimb_type_id");
				Reimbursements r = new Reimbursements();
				//TODO: finish employee service and have this service
				//use the call by id function
				reimbursements.add(r);
			}
			rs.close();
			
		}catch(SQLException e) {
			logger.warn("Unable to get reimbursements from database", e);
		}
		
		return reimbursements;
	}

	@Override
	public Reimbursements findById(int id) {
		Reimbursements r = new Reimbursements();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM project1.ers_reimbursement ";
			sql += "WHERE reimb_id = " + id;
			PreparedStatement stmnt = conn.prepareStatement(sql);
			ResultSet rs = stmnt.executeQuery();
			while(rs.next()) {
				double amount = rs.getDouble("reimb_amount");
				Timestamp submitted = rs.getTimestamp("reimb_submitted");
				Timestamp resolved = rs.getTimestamp("reimb_resolved");
				String description = rs.getString("reimb_description");
				byte[] receipt = rs.getBytes("reimb_receipt");
				int authorId = rs.getInt("reimb_author");
				int resolverId = rs.getInt("reimb_resolver");
				int status = rs.getInt("reimb_status_id");
				int type = rs.getInt("reimb_type_id");
			}
			rs.close();
		}catch(SQLException e) {
			logger.warn("Reimbursement not found", e);
		}
		return r;
	}
	
	@Override
	public boolean insert(Reimbursements r) {
		// TODO Auto-generated method stub
		return false;
	}


}
