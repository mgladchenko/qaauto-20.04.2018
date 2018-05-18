import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @DataProvider
    public Object[][] ValidDataProvider() {
        return new Object[][]{
                { "iteatest@i.ua", "1q2w3e_4r5t" },
                //{ "iteatest@I.UA", "1q2w3e_4r5t" }
        };
    }

    @Test(dataProvider = "ValidDataProvider")
	public void successfulLoginTest(String userEmail, String userPassword) {
		LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
		Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login page is not loaded");

		linkedinLoginPage.login(userEmail, userPassword);

		LinkedinHomePage linkedinHomePage = new LinkedinHomePage(webDriver);
		Assert.assertTrue(linkedinHomePage.isPageLoaded(),
				"Home page is not loaded");

	}

	@Test
	public void verifyLoginWithEmptyUsernameAndPassword() {
		LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
		linkedinLoginPage.login("", "");
		Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login page is not loaded.");
	}

    @Test
    public void verifyLoginWithValidUsernameAndShortPassword() {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(webDriver);
        linkedinLoginPage.login("iteatest@i.ua", "1");
        Assert.assertEquals(linkedinLoginSubmitPage.getErrorMessageText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Error message text is wrong.");
    }






}
