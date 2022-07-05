package dev.provost.runners;

import java.io.File;

import org.junit.jupiter.api.Tag;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.provost.pages.LoginPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

@Suite
@Tag("CucumberTests")
@IncludeTags("CucumberTests")
@ExcludeTags("DaoTests")
public class LoginRunner {

	public static WebDriver driver;
	public static LoginPage loginPage;

	@BeforeAll
	public static void setup() {

		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		driver = new ChromeDriver();

		loginPage = new LoginPage(driver);
	}

	@AfterAll
	public static void teardown() {
		driver.quit();
	}

}
