package dev.provost.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import dev.provost.models.Employee;
import dev.provost.models.Reimbs;
import dev.provost.repositories.EmployeeDAO;
import dev.provost.repositories.ReimbsDAO;

public class ReimbsService {
	private ReimbsDAO reimbsDao;
	public EmployeeDAO employeeDao = new EmployeeDAO();

	public ReimbsService(ReimbsDAO reimbsDao) {
		this.reimbsDao = reimbsDao;
	}

	public List<Reimbs> getReimbsByReimbStatus(int reimbStatus) {

		List<Reimbs> reimbs = reimbsDao.getReimbsByReimbStatus(reimbStatus);

		return reimbs;
	}

	public List<Reimbs> getReimbsByReimbId(int reimbId) {

		List<Reimbs> reimbs = reimbsDao.getReimbsByReimbId(reimbId);

		return reimbs;
	}

	public List<Reimbs> getReimbsByReimbStatusAndEmpId(int reimbStatus, int empId) {

		List<Reimbs> reimbs = reimbsDao.getReimbsByReimbStatusAndEmpId(reimbStatus, empId);

		return reimbs;
	}

	public List<Reimbs> getReimbsByEmpId(int empId) {

		List<Reimbs> reimbs = reimbsDao.getReimbsByEmpId(empId);

		return reimbs;
	}

	public Reimbs createReimb(Reimbs reimbFromRequestBody, int empId) {
		Employee e = employeeDao.getEmployeeByEmpId(empId);
		if (e.getAvailFunds() < reimbFromRequestBody.getReimbAmount()) {
			return null;
		} else {
			Reimbs createdReimb = reimbsDao.createReimb(reimbFromRequestBody, empId);
			double changed = createdReimb.getReimbAmount();
			e.setPendingFunds(e.getPendingFunds() + changed);
			long daysBetween = createdReimb.getReimbSubmitted().until(createdReimb.getEventDate(), ChronoUnit.DAYS);
			if (daysBetween <= 14) {
				createdReimb.setReimbIsUrgent(true);
			}
			return createdReimb;
		}

	}

	public Reimbs editReimbStatus(int reimbStatus, int reimbId, String managerNotes) {
		int empId = employeeDao.getEmployeeIdByReimbId(reimbId);
		Employee e = employeeDao.getEmployeeByEmpId(empId);
		Reimbs r = reimbsDao.getReimbsByReimbId(reimbId).get(0);

		if (reimbStatus == 3) {
			double changed = r.getReimbAmount();
			e.setPendingFunds(e.getPendingFunds() - changed);
			e.setAwardedFunds(e.getAwardedFunds() + changed);
			r.setReimbComplete(LocalDate.now());

			employeeDao.updateAllFunds(e.getAvailFunds(), e.getPendingFunds(), e.getAwardedFunds());
		}

		if (reimbStatus == 4) {
			double changed = r.getReimbAmount();
			e.setPendingFunds(e.getPendingFunds() - changed);

			employeeDao.updateAvailFunds(e.getAvailFunds());
			employeeDao.updatePendingFunds(e.getPendingFunds());
		}
		return reimbsDao.editReimbStatus(reimbStatus, reimbId, managerNotes);
	}

	public Reimbs deleteReimb(int reimbId) {

		reimbsDao.deleteReimb(reimbId);
		return null;
	}

}
