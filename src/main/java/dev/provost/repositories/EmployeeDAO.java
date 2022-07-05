package dev.provost.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.provost.models.Employee;
import dev.provost.utils.ConnectionUtil;

public class EmployeeDAO {

	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	// Get an Employee by Username
	public Employee getEmployeeByUsername(String username) {
		String sql = "select * from employees where username = ?";

		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Employee(rs.getInt("emp_id"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("username"), rs.getString("pass"), rs.getInt("employee_type"),
						rs.getDouble("pending_funds"), rs.getDouble("awarded_funds"), rs.getDouble("avail_funds"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Get an Employee by Employee ID
	public Employee getEmployeeByEmpId(int empId) {
		String sql = "select * from employees where emp_id = ?";

		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, empId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Employee(rs.getInt("emp_id"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("username"), rs.getString("pass"), rs.getInt("employee_type"),
						rs.getDouble("pending_funds"), rs.getDouble("awarded_funds"), rs.getDouble("avail_funds"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Get an Employee by one of their Reimbursement ID's
	public int getEmployeeIdByReimbId(int reimbId) {
		String sql = "select emp_id from reimbs where reimb_id = ?";

		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return rs.getInt("emp_id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	// Update Available Funds
	public Employee updateAvailFunds(double availBalance) {
		String sql = "update employees set avail_funds = ?";

		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, availBalance);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Employee(rs.getInt("emp_id"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("username"), rs.getString("pass"), rs.getInt("employee_type"),
						rs.getDouble("pending_funds"), rs.getDouble("awarded_funds"), rs.getDouble("avail_funds"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Update Pending Funds
	public Employee updatePendingFunds(double pendingFunds) {
		String sql = "update employees set avail_funds = ?";

		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, pendingFunds);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Employee(rs.getInt("emp_id"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("username"), rs.getString("pass"), rs.getInt("employee_type"),
						rs.getDouble("pending_funds"), rs.getDouble("awarded_funds"), rs.getDouble("avail_funds"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Update Awarded Funds
	public Employee updateAwardedFunds(double awardedFunds) {
		String sql = "update employees set awarded_funds = ?";

		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, awardedFunds);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Employee(rs.getInt("emp_id"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("username"), rs.getString("pass"), rs.getInt("employee_type"),
						rs.getDouble("pending_funds"), rs.getDouble("awarded_funds"), rs.getDouble("avail_funds"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateAllFunds(double availFunds, double pendingFunds, double awardedFunds) {
		updateAvailFunds(availFunds);
		updatePendingFunds(pendingFunds);
		updateAwardedFunds(awardedFunds);
	}

}
