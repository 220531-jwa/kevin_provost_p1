package dev.provost.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reimbs {
	private int reimbId;
	private int empId;
	private int reimbType;
	private int gradingFormat;
	private int minPassingGrade;
	private double reimbAmount;
	private LocalDate reimbSubmitted;
	private LocalDate eventDate;
	private LocalTime eventTime;
	private String eventLocation;
	private String reimbDesc;
	private LocalDate reimbComplete;
	private int reimbStatus;
	private String managerNotes;
	private boolean reimbIsUrgent;

	public Reimbs() {
		super();
	}

	public Reimbs(int reimbId, int empId, int reimbType, int gradingFormat, int minPassingGrade, double reimbAmount,
			LocalDate reimbSubmitted, LocalDate eventDate, LocalTime eventTime, String eventLocation, String reimbDesc,
			LocalDate reimbComplete, int reimbStatus, String managerNotes, boolean reimbIsUrgent) {
		super();
		this.reimbId = reimbId;
		this.empId = empId;
		this.reimbType = reimbType;
		this.gradingFormat = gradingFormat;
		this.minPassingGrade = minPassingGrade;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.eventLocation = eventLocation;
		this.reimbDesc = reimbDesc;
		this.reimbComplete = reimbComplete;
		this.reimbStatus = reimbStatus;
		this.managerNotes = managerNotes;
		this.reimbIsUrgent = reimbIsUrgent;
	}

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getReimbType() {
		return reimbType;
	}

	public void setReimbType(int reimbType) {
		this.reimbType = reimbType;
	}

	public int getGradingFormat() {
		return gradingFormat;
	}

	public void setGradingFormat(int gradingFormat) {
		this.gradingFormat = gradingFormat;
	}

	public int getMinPassingGrade() {
		return minPassingGrade;
	}

	public void setMinPassingGrade(int minPassingGrade) {
		this.minPassingGrade = minPassingGrade;
	}

	public double getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public LocalDate getReimbSubmitted() {
		return reimbSubmitted;
	}

	public void setReimbSubmitted(LocalDate reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public LocalTime getEventTime() {
		return eventTime;
	}

	public void setEventTime(LocalTime eventTime) {
		this.eventTime = eventTime;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getReimbDesc() {
		return reimbDesc;
	}

	public void setReimbDesc(String reimbDesc) {
		this.reimbDesc = reimbDesc;
	}

	public LocalDate getReimbComplete() {
		return reimbComplete;
	}

	public void setReimbComplete(LocalDate reimbComplete) {
		this.reimbComplete = reimbComplete;
	}

	public int getReimbStatus() {
		return reimbStatus;
	}

	public void setReimbStatus(int reimbStatus) {
		this.reimbStatus = reimbStatus;
	}

	public String getManagerNotes() {
		return managerNotes;
	}

	public void setManagerNotes(String managerNotes) {
		this.managerNotes = managerNotes;
	}

	public boolean getReimbIsUrgent() {
		return reimbIsUrgent;
	}

	public void setReimbIsUrgent(boolean reimbIsUrgent) {
		this.reimbIsUrgent = reimbIsUrgent;
	}

}
