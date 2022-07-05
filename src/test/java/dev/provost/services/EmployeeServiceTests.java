package dev.provost.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.provost.models.Employee;
import dev.provost.repositories.EmployeeDAO;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTests {
	@InjectMocks
	private static EmployeeService employeeService;

	@Mock
	private static EmployeeDAO employeeDaoMock;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		employeeService = new EmployeeService(employeeDaoMock);
	}

	@Test
	public void loginWithValidInput() {
		Employee mockEmployee = new Employee(1, "name", "lname", "username", "pass", 1, 1000, 0, 0);

		when(employeeDaoMock.getEmployeeByUsername(anyString())).thenReturn(mockEmployee);

		Employee loggedInEmployee = employeeService.login("username", "pass");

		assertEquals(mockEmployee, loggedInEmployee);
	}

	@Test
	public void loginWithInvalidUsernameShouldReturnNull() {
//		Employee mockEmployee = new Employee(1, "name", "lname", "username", "pass", 1, 1000);

		when(employeeDaoMock.getEmployeeByUsername(anyString())).thenReturn(null);

		Employee loggedInUser = employeeService.login("username", "pass");

		assertEquals(null, loggedInUser);
	}

	@Test
	public void loginWithValidUsernameInvalidPasswordShouldReturnNull() {

		Employee mockEmployee = new Employee(1, "name", "lname", "username", "pass", 1, 1000, 0, 0);

		when(employeeDaoMock.getEmployeeByUsername(anyString())).thenReturn(mockEmployee);

		Employee loggedInUser = employeeService.login("username", "pa$$word");

		assertEquals(null, loggedInUser);
	}

}
