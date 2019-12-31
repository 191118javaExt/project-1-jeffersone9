package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	private static Logger logger = Logger.getLogger(EmployeeDAOImpl.class);
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
				Employee emp = new Employee();
				employees.add(emp);
			}
			rs.close();
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
			}
			rs.close();
		}catch(SQLException e) {
			logger.warn("Could not get the employee from the db", e);
		}
		return emp;
	}
	@Override
	public boolean insert(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}


}
