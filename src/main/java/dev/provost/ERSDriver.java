package dev.provost;

import static io.javalin.apibuilder.ApiBuilder.delete;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.patch;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

import dev.provost.controllers.EmployeeController;
import dev.provost.controllers.ReimbsController;
import dev.provost.repositories.EmployeeDAO;
import dev.provost.repositories.ReimbsDAO;
import dev.provost.services.EmployeeService;
import dev.provost.services.ReimbsService;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class ERSDriver {

	public static void main(String[] args) {
		EmployeeController ec = new EmployeeController(new EmployeeService(new EmployeeDAO()));
		ReimbsController rc = new ReimbsController(new ReimbsService(new ReimbsDAO()));

		Javalin app = Javalin.create(config -> {
			config.enableCorsForAllOrigins();
			config.addStaticFiles("/public", Location.CLASSPATH);
		});

		app.start(8080);

		app.routes(() -> {

			path("/login", () -> {
				post(ec::login);
			});

			path("/employeeLanding", () -> {
				path("/{empId}", () -> {
					get(rc::getReimbsByEmpId);
					post(rc::createReimb);
					path("/{reimbId}", () -> {
						get(rc::getReimbsByReimbId);
						patch(rc::editReimbStatus);
						delete(rc::deleteReimb);
					});
					path("/status/{reimbStatus}", () -> {
						get(rc::getReimbsByReimbStatusAndEmpId);
					});

				});
			});

			path("/managerLanding", () -> {
				path("/status/{reimbStatus}", () -> {
					get(rc::getReimbsByReimbStatus);
				});
				path("/emp/{empId}", () -> {
					get(rc::getReimbsByEmpId);
				});
				path("/edit/{reimbId}/{reimbStatus}", () -> {
					patch(rc::editReimbStatus);
				});
			});

		});

//			path("/getSession", () -> {
//			get(ctx -> {
//				// once set, we can access that session attribute
//				User loggedInUser = ctx.sessionAttribute("loggedInUser");
//				System.out.println(loggedInUser);
//			});
//		});
//			path("/logout", () -> {
//				delete(ctx -> {
//					// invalidating session so loggedInUser is null
//					ctx.req.getSession(false).invalidate();
//				});
//			});

	}
}
