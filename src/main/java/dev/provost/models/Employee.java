package dev.provost.models;

public class Employee {

	private int empId;
	private String firstName;
	private String lastName;
	private String username;
	private String pass;
	private int employeeType;
	private final double totalFunds = 1000;
	private double pendingFunds;
	private double awardedFunds;
	private double availFunds = (totalFunds - pendingFunds - awardedFunds);

	public Employee() {
		super();
	}

	public Employee(int empId, String firstName, String lastName, String username, String pass, int employeeType,
			double pendingFunds, double awardedFunds, double availFunds) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.pass = pass;
		this.employeeType = employeeType;
		this.pendingFunds = pendingFunds;
		this.awardedFunds = awardedFunds;
		this.availFunds = availFunds;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(int employeeType) {
		this.employeeType = employeeType;
	}

	public double getAvailFunds() {
		return availFunds;
	}

	public double getPendingFunds() {
		return pendingFunds;
	}

	public void setPendingFunds(double pendingFunds) {
		this.pendingFunds = pendingFunds;
	}

	public double getAwardedFunds() {
		return awardedFunds;
	}

	public void setAwardedFunds(double awardedFunds) {
		this.awardedFunds = awardedFunds;
	}

	public double getTotalFunds() {
		return totalFunds;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", pass=" + pass + ", employeeType=" + employeeType + ", totalFunds=" + totalFunds
				+ ", pendingFunds=" + pendingFunds + ", awardedFunds=" + awardedFunds + ", availFunds=" + availFunds
				+ "]";
	}

}
