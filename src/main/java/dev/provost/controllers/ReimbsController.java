package dev.provost.controllers;

import java.util.List;

import dev.provost.models.Reimbs;
import dev.provost.services.ReimbsService;
import io.javalin.http.Context;

public class ReimbsController {
	private ReimbsService rs;

	public ReimbsController(ReimbsService rs) {
		this.rs = rs;
	}

	public void createReimb(Context ctx) throws Exception {
		int empId = Integer.parseInt(ctx.pathParam("empId"));
		Reimbs reimbFromRequestBody = ctx.bodyAsClass(Reimbs.class);

		try {
			rs.createReimb(reimbFromRequestBody, empId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void getReimbsByReimbStatus(Context ctx) {
		int reimbStatus = Integer.parseInt(ctx.pathParam("reimbStatus"));
		List<Reimbs> reimbs = null;
		try {
			reimbs = rs.getReimbsByReimbStatus(reimbStatus);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (reimbs != null) {
			ctx.status(200);
			ctx.json(reimbs);
		} else {
			ctx.status(404);
		}
	}

	public void getReimbsByReimbId(Context ctx) {
		int reimbId = Integer.parseInt(ctx.pathParam("reimbId"));
		List<Reimbs> reimbs = null;
		try {
			reimbs = rs.getReimbsByReimbId(reimbId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (reimbs != null) {
			ctx.status(200);
			ctx.json(reimbs);
		} else {
			ctx.status(404);
		}
	}

	public void getReimbsByReimbStatusAndEmpId(Context ctx) {
		int empId = Integer.parseInt(ctx.pathParam("empId"));
		int reimbStatus = Integer.parseInt(ctx.pathParam("reimbStatus"));
		List<Reimbs> reimbs = null;
		try {
			reimbs = rs.getReimbsByReimbStatusAndEmpId(reimbStatus, empId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (reimbs != null) {
			ctx.status(200);
			ctx.json(reimbs);
		} else {
			ctx.status(404);
		}
	}

	public void getReimbsByEmpId(Context ctx) {
		int empId = Integer.parseInt(ctx.pathParam("empId"));
		List<Reimbs> reimbs = null;
		try {
			reimbs = rs.getReimbsByEmpId(empId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (reimbs != null) {
			ctx.status(200);
			ctx.json(reimbs);
		} else {
			ctx.status(404);
		}
	}

	public void editReimbStatus(Context ctx) {
		int reimbId = Integer.parseInt(ctx.pathParam("reimbId"));
		int reimbStatus = Integer.parseInt(ctx.pathParam("reimbStatus"));
		Reimbs r = ctx.bodyAsClass(Reimbs.class);
		ctx.status(205);
		try {
			rs.editReimbStatus(reimbStatus, reimbId, r.getManagerNotes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteReimb(Context ctx) {
		int reimbId = Integer.parseInt(ctx.pathParam("reimbId"));
		ctx.status(205);
		try {
			rs.deleteReimb(reimbId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
