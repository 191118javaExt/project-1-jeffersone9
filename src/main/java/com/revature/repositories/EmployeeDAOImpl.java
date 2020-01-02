package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Employee;
import com.revature.models.EmployeeRole;
import com.revature.util.CloseStreams;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	private static Logger logger = LogManager.getLogger(EmployeeDAOImpl.class);
	@Override
	public List<Employee> findAll() {
		List<Employee> employees = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM project1.ers_users";
			PreparedStatement stmnt = conn.prepareStatement(sql);
			ResultSet rs = stmnt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("ers_user_id");
				String user = rs.getString("ers_username");
				String pass = rs.getString("ers_password");
				String first = rs.getString("user_first_name");
				String last = rs.getString("user_last_name");
				String email = rs.getString("user_email");
				int role = rs.getInt("user_role_id");
				Employee emp = new Employee(id, user, pass, first, last, email, EmployeeRole.getRole(role));
				employees.add(emp);
			}
			CloseStreams.close(rs);
		}catch(SQLException e) {
			logger.warn("Could not get employees from the db", e);
		}
		return employees;
	}

	@Override
	public Employee findById(int id) {
		Employee emp = new Employee();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM project1.ers_users ";
			sql += "WHERE ers_user_id = " + id;
			PreparedStatement stmnt = conn.prepareStatement(sql);
			ResultSet rs = stmnt.executeQuery();
			while(rs.next()) {
				String user = rs.getString("ers_username");
				String pass = rs.getString("ers_password");
				String first = rs.getString("user_first_name");
				String last = rs.getString("user_last_name");
				String email = rs.getString("user_email");
				int role = rs.getInt("user_role_id");
				emp.setId(id);
				emp.setUsername(user);
				emp.setPassword(pass);
				emp.setFirstName(first);
				emp.setLastName(last);
				emp.setEmail(email);
				emp.setRole(EmployeeRole.getRole(role));
			}
			CloseStreams.close(rs);
		}catch(SQLException e) {
			logger.warn("Could not get the employee from the db", e);
		}
		return emp;
	}
	@Override
	public boolean insert(Employee e) {
		PreparedStatement stmnt = null;
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO project1.ers_users VALUES(?, ?, ?, ?, ?, ?, ?);";
			stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1, e.getId());
			stmnt.setString(2,  e.getUsername());
			stmnt.setString(3, e.getPassword());
			stmnt.setString(4, e.getFirstName());
			stmnt.setString(5,  e.getLastName());
			stmnt.setString(6,  e.getEmail());
			stmnt.setInt(7, e.getRole().getValue());
			if(!stmnt.execute()) {
				return false;
			}
		}catch(SQLException ex) {
			logger.warn("Could not create new employee for database", ex);
		}finally {
			CloseStreams.close(stmnt);
		}
		return true;
	}


}
