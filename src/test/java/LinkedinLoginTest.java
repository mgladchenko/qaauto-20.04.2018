import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkedinLoginTest {

	WebDriver webDriver;

	@BeforeMethod
	public void before() {
		webDriver = new FirefoxDriver();
		webDriver.get("https://www.linkedin.com");
	}

	@AfterMethod
	public void after() {
		webDriver.close();
	}

	@Test
	public void successfulLoginTest() {
		LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
		Assert.assertEquals(linkedinLoginPage.getCurrentPageTitle(), "LinkedIn: Log In or Sign Up",
				"Login page title is wrong.");

		linkedinLoginPage.login("iteatest@i.ua", "1q2w3e_4r5t");

		LinkedinHomePage linkedinHomePage = new LinkedinHomePage(webDriver);

		Assert.assertTrue(linkedinHomePage.isProfileMenuDisplayed(),
				"Profile menu is not displayed after login");

		//Fixme: use inheritance
		Assert.assertEquals(linkedinLoginPage.getCurrentPageTitle(), "LinkedIn",
				"Home page title is wrong.");

	}

	@Test
	public void verifyLoginWithEmptyUsernameAndPassword() {
		LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
		linkedinLoginPage.login("", "");
		Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sing In button is missing");
	}



}
