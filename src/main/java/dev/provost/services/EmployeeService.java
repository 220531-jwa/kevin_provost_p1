package dev.provost.services;

import dev.provost.models.Employee;
import dev.provost.repositories.EmployeeDAO;

public class EmployeeService {
	private EmployeeDAO employeeDao;

	public EmployeeService(EmployeeDAO employeeDao) {
		this.employeeDao = employeeDao;
	}

	public Employee login(String username, String pass) {

		Employee e = employeeDao.getEmployeeByUsername(username);

		if (e != null) {
			if (e.getPass().equals(pass)) {
				return e;
			}
		}
		return null;
	}
}
