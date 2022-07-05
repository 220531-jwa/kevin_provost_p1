package dev.provost.controllers;

import dev.provost.models.Employee;
import dev.provost.services.EmployeeService;
import io.javalin.http.Context;

public class EmployeeController {
	private EmployeeService es;

	public EmployeeController(EmployeeService es) {
		this.es = es;
	}

	public void login(Context ctx) {
		Employee e = ctx.bodyAsClass(Employee.class);
		Employee loggedInEmployee = null;
		try {
			loggedInEmployee = es.login(e.getUsername(), e.getPass());
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		if (loggedInEmployee == null) {
			ctx.status(404);
		} else {
			ctx.status(200);
			ctx.json(loggedInEmployee);
		}

	}

}
