package dev.provost.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import dev.provost.models.Reimbs;
import dev.provost.utils.ConnectionUtil;

public class ReimbsDAO {

	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	// Allow someone to view All Reimbursements by Employee ID
	public List<Reimbs> getReimbsByEmpId(int empId) {

		List<Reimbs> reimbs = new ArrayList<>();

		String sql = "select * from reimbs where emp_id = ?";

		try (Connection conn = cu.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, empId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int reimbId = rs.getInt("reimb_id");
				int reimbType = rs.getInt("reimb_type");
				int gradingFormat = rs.getInt("grading_format");
				int minPassingGrade = rs.getInt("reimb_amount");
				double reimbAmount = rs.getDouble("reimb_amount");
				LocalDate reimbSubmitted = rs.getObject("reimb_submitted", LocalDate.class);
				LocalDate eventDate = rs.getObject("event_date", LocalDate.class);
				LocalTime eventTime = rs.getObject("event_time", LocalTime.class);
				String eventLocation = rs.getString("event_location");
				String reimbDesc = rs.getString("reimb_desc");
				LocalDate reimbComplete = rs.getObject("reimb_complete", LocalDate.class);
				int reimbStatus = rs.getInt("reimb_status");
				String managerNotes = rs.getString("manager_notes");
				boolean reimbIsUrgent = rs.getBoolean("reimb_is_urgent");

				Reimbs r = new Reimbs(reimbId, empId, reimbType, gradingFormat, minPassingGrade, reimbAmount,
						reimbSubmitted, eventDate, eventTime, eventLocation, reimbDesc, reimbComplete, reimbStatus,
						managerNotes, reimbIsUrgent);

				reimbs.add(r);

			}
			return reimbs;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	// Allow someone to view all Reimbursements by Reimbursement Status
	public List<Reimbs> getReimbsByReimbStatus(int reimbStatus) {

		List<Reimbs> reimbs = new ArrayList<>();

		String sql = "select * from reimbs where reimb_status = ?";

		try (Connection conn = cu.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbStatus);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int reimbId = rs.getInt("reimb_id");
				int empId = rs.getInt("emp_id");
				int reimbType = rs.getInt("reimb_type");
				int gradingFormat = rs.getInt("grading_format");
				int minPassingGrade = rs.getInt("reimb_amount");
				double reimbAmount = rs.getDouble("reimb_amount");
				LocalDate reimbSubmitted = rs.getObject("reimb_submitted", LocalDate.class);
				LocalDate eventDate = rs.getObject("event_date", LocalDate.class);
				LocalTime eventTime = rs.getObject("event_time", LocalTime.class);
				String eventLocation = rs.getString("event_location");
				String reimbDesc = rs.getString("reimb_desc");
				LocalDate reimbComplete = rs.getObject("reimb_complete", LocalDate.class);
				String managerNotes = rs.getString("manager_notes");
				boolean reimbIsUrgent = rs.getBoolean("reimb_is_urgent");

				Reimbs r = new Reimbs(reimbId, empId, reimbType, gradingFormat, minPassingGrade, reimbAmount,
						reimbSubmitted, eventDate, eventTime, eventLocation, reimbDesc, reimbComplete, reimbStatus,
						managerNotes, reimbIsUrgent);

				reimbs.add(r);

			}
			return reimbs;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	// Allow someone to view Reimbursements by Reimbursement Status & Employee ID
	public List<Reimbs> getReimbsByReimbStatusAndEmpId(int reimbStatus, int empId) {
		List<Reimbs> reimbs = new ArrayList<>();

		String sql = "select * from reimbs where reimb_status = ? and emp_id = ?";

		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbStatus);
			ps.setInt(2, empId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int reimbType = rs.getInt("reimb_type");
				int gradingFormat = rs.getInt("grading_format");
				int minPassingGrade = rs.getInt("reimb_amount");
				double reimbAmount = rs.getDouble("reimb_amount");
				LocalDate reimbSubmitted = rs.getObject("reimb_submitted", LocalDate.class);
				LocalDate eventDate = rs.getObject("event_date", LocalDate.class);
				LocalTime eventTime = rs.getObject("event_time", LocalTime.class);
				String eventLocation = rs.getString("event_location");
				String reimbDesc = rs.getString("reimb_desc");
				LocalDate reimbComplete = rs.getObject("reimb_complete", LocalDate.class);
				int reimbId = rs.getInt("reimb_id");
				String managerNotes = rs.getString("manager_notes");
				boolean reimbIsUrgent = rs.getBoolean("reimb_is_urgent");

				Reimbs r = new Reimbs(reimbId, empId, reimbType, gradingFormat, minPassingGrade, reimbAmount,
						reimbSubmitted, eventDate, eventTime, eventLocation, reimbDesc, reimbComplete, reimbStatus,
						managerNotes, reimbIsUrgent);

				reimbs.add(r);

			}
			return reimbs;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	// Allow someone to view a Reimbursement by Reimbursement ID
	public List<Reimbs> getReimbsByReimbId(int reimbId) {

		List<Reimbs> reimbs = new ArrayList<>();

		String sql = "select * from reimbs where reimb_id = ?";

		try (Connection conn = cu.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int empId = rs.getInt("emp_id");
				int reimbType = rs.getInt("reimb_type");
				int gradingFormat = rs.getInt("grading_format");
				int minPassingGrade = rs.getInt("reimb_amount");
				double reimbAmount = rs.getDouble("reimb_amount");
				LocalDate reimbSubmitted = rs.getObject("reimb_submitted", LocalDate.class);
				LocalDate eventDate = rs.getObject("event_date", LocalDate.class);
				LocalTime eventTime = rs.getObject("event_time", LocalTime.class);
				String eventLocation = rs.getString("event_location");
				String reimbDesc = rs.getString("reimb_desc");
				LocalDate reimbComplete = rs.getObject("reimb_complete", LocalDate.class);
				int reimbStatus = rs.getInt("reimb_status");
				String managerNotes = rs.getString("manager_notes");
				boolean reimbIsUrgent = rs.getBoolean("reimb_is_urgent");

				Reimbs r = new Reimbs(reimbId, empId, reimbType, gradingFormat, minPassingGrade, reimbAmount,
						reimbSubmitted, eventDate, eventTime, eventLocation, reimbDesc, reimbComplete, reimbStatus,
						managerNotes, reimbIsUrgent);

				reimbs.add(r);

			}
			return reimbs;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	// Create a new Reimbursement Request
	public Reimbs createReimb(Reimbs reimbFromRequestBody, int empId) {

		String sql = "insert into reimbs values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default, default, default, default) returning *";

		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, empId);
			ps.setInt(2, reimbFromRequestBody.getReimbType());
			ps.setInt(3, reimbFromRequestBody.getGradingFormat());
			ps.setInt(4, reimbFromRequestBody.getMinPassingGrade());
			ps.setDouble(5, reimbFromRequestBody.getReimbAmount());
			ps.setObject(6, reimbFromRequestBody.getReimbSubmitted());
			ps.setObject(7, reimbFromRequestBody.getEventDate());
			ps.setObject(8, reimbFromRequestBody.getEventTime());
			ps.setString(9, reimbFromRequestBody.getEventLocation());
			ps.setString(10, reimbFromRequestBody.getReimbDesc());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Reimbs(rs.getInt("reimb_id"), rs.getInt("emp_id"), rs.getInt("reimb_type"),
						rs.getInt("grading_format"), rs.getInt("reimb_amount"), rs.getDouble("reimb_amount"),
						rs.getObject("reimb_submitted", LocalDate.class), rs.getObject("event_date", LocalDate.class),
						rs.getObject("event_time", LocalTime.class), rs.getString("event_location"),
						rs.getString("reimb_desc"), rs.getObject("reimb_complete", LocalDate.class),
						rs.getInt("reimb_status"), rs.getString("manager_notes"), rs.getBoolean("reimb_is_urgent"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	// Edit a Reimbursement Status
	public Reimbs editReimbStatus(int reimbStatus, int reimbId, String managerNotes) {

		String sql = "update reimbs set reimb_status = ?, manager_notes = ? where reimb_id = ? returning *";

		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbStatus);
			ps.setString(2, managerNotes);
			ps.setInt(3, reimbId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Reimbs(rs.getInt("reimb_id"), rs.getInt("emp_id"), rs.getInt("reimb_type"),
						rs.getInt("grading_format"), rs.getInt("reimb_amount"), rs.getDouble("reimb_amount"),
						rs.getObject("reimb_submitted", LocalDate.class), rs.getObject("event_date", LocalDate.class),
						rs.getObject("event_time", LocalTime.class), rs.getString("event_location"),
						rs.getString("reimb_desc"), rs.getObject("reimb_complete", LocalDate.class),
						rs.getInt("reimb_status"), rs.getString("manager_notes"), rs.getBoolean("reimb_is_urgent"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	// Allow someone to delete a Reimbursement Request
	public Reimbs deleteReimb(int reimbId) {
		String sql = "delete from reimbs where reimb_id = ? returning *";

		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Reimbs(rs.getInt("reimb_id"), rs.getInt("emp_id"), rs.getInt("reimb_type"),
						rs.getInt("grading_format"), rs.getInt("reimb_amount"), rs.getDouble("reimb_amount"),
						rs.getObject("reimb_submitted", LocalDate.class), rs.getObject("event_date", LocalDate.class),
						rs.getObject("event_time", LocalTime.class), rs.getString("event_location"),
						rs.getString("reimb_desc"), rs.getObject("reimb_complete", LocalDate.class),
						rs.getInt("reimb_status"), rs.getString("manager_notes"), rs.getBoolean("reimb_is_urgent"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
}
