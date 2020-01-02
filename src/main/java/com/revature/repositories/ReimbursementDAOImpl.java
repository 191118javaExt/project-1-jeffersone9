package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.Reimbursements;
import com.revature.util.CloseStreams;
import com.revature.util.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO {
	
	private static Logger logger = LogManager.getLogger(ReimbursementDAOImpl.class);
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
				Reimbursements r = new Reimbursements(id, description, receipt, amount, status, type, authorId, resolverId, submitted, resolved);
				reimbursements.add(r);
			}
			CloseStreams.close(rs);
			
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
				r.setId(id);
				r.setAmount(amount);
				r.setSubmitted(submitted);
				r.setResolved(resolved);
				r.setDescription(description);
				r.setReceipt(receipt);
				r.setAuthorId(authorId);
				r.setResolverId(resolverId);
				r.setStatus(ReimbursementStatus.getStatus(status));
				r.setType(ReimbursementType.getType(type));
			}
			CloseStreams.close(rs);
		}catch(SQLException e) {
			logger.warn("Reimbursement not found", e);
		}
		return r;
	}
	
	@Override
	public boolean insert(Reimbursements r) {
		PreparedStatement stmnt = null;
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO project1.ers_reimbursement VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1, r.getId());
			stmnt.setDouble(2, r.getAmount());
			stmnt.setTimestamp(3, r.getSubmitted());
			stmnt.setTimestamp(4, r.getResolved());
			stmnt.setString(5, r.getDescription());
			stmnt.setBytes(6, r.getReceipt());
			stmnt.setInt(7, r.getAuthorId());
			stmnt.setInt(8, r.getResolverId());
			stmnt.setInt(9, r.getStatus().getValue());
			stmnt.setInt(10, r.getType().getValue());
			if(!stmnt.execute())
			{
				return false;
			}
		}catch(SQLException e) {
			logger.warn("Database failed to insert reimbursements", e);
			return false;
		}finally {
			CloseStreams.close(stmnt);
		}
		return true;
	}


}
