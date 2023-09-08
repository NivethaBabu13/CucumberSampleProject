package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.base.utils.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseClass {
		
	@Given("User should navigate to the application")
	public void userShouldNavigate() {
		browserOpen("firefox");
		loadUrl("https://bookcart.azurewebsites.net/");
		driver.manage().window().maximize();
		}
	@Given("User clicks on the login link")
	public void userClicksOnTheLoginLink() {
	   WebElement login = driver.findElement(By.xpath("//span[text()='Login']")); 
	   login.click();
	}

	/*
	 * @Given("User enter the username as ortoni") public void
	 * userEnterTheUsernameAsOrtoni() {
	 * driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("ortoni")
	 * ; }
	 * 
	 * @Given("User enter the password as pass1234") public void
	 * userEnterThePasswordAsPass1234() {
	 * driver.findElement(By.xpath("//input[@type='password']")).sendKeys("pass1234"
	 * );
	 * 
	 * }
	 */
	@When("User click the login button")
	public void userClickTheLoginButton() {
	   driver.findElement(By.xpath("//span[@class='mat-button-wrapper']//following::span[31]")).click();
	    
	}
	@Then("login should be success")
	public void loginShouldBeSuccess() {
		String text = driver.findElement(By.xpath("//span[contains(text(),' ortoni ')]")).getText();
		System.out.println(text);
		System.out.println("Logged in successful");
		driver.close();
	}

	/*
	 * @Given("User enter the username as koushik") public void
	 * userEnterTheUsernameAsKoushik() {
	 * driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("koushik"
	 * ); }
	 * 
	 * @Given("User enter the password as passkoushik") public void
	 * userEnterThePasswordAsPasskoushik() {
	 * driver.findElement(By.xpath("//input[@type='password']")).sendKeys(
	 * "passkoushik"); }
	 */
	@When("login should fail")
	public void loginShouldFail() {
	   String errorMsg = driver.findElement(By.xpath("//*[contains(text(),'Username or Password is incorrect.')]")).getText();
	   System.out.println(errorMsg);
	   Assert.assertEquals(errorMsg, "Username or Password is incorrect.");
	   driver.close();
	}
	@Given("User enter the username as {string}")
	public void userEnterTheUsernameAs(String username) {
		driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys(username);

	}
	@Given("User enter the password as {string}")
	public void userEnterThePasswordAs(String password) {
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);

	}

}
