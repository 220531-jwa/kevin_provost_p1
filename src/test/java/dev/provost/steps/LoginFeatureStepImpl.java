package dev.provost.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.provost.pages.LoginPage;
import dev.provost.runners.LoginRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFeatureStepImpl {

	private WebDriver driver = LoginRunner.driver;
	private LoginPage loginPage = LoginRunner.loginPage;

	@Given("a Manager is on the LoginPage")
	public void a_manager_is_on_the_login_page() {
		driver.get("http://localhost:8080/login.html");
	}

	@When("the Manager types in their {string} and {string} and clicks the LoginButton")
	public void the_manager_types_in_their_username_and_password_and_clicks_the_login_button(String username,
			String password) {
		loginPage.usernameInput.sendKeys(username);
		loginPage.passwordInput.sendKeys(password);
		loginPage.loginButton.click();
	}

	@Then("the Manager should be on ManagerLanding")
	public void the_manager_should_be_on_the_manager_landing_page() {
		// we need to incorporate a WAIT here....
		// here's an Explicit Wait
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.titleContains("Manager Landing Page"));

		assertEquals("Manager Landing Page", driver.getTitle());
	}

}
