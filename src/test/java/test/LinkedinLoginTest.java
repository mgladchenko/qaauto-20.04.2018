package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinLoginSubmitPage;

public class LinkedinLoginTest extends LinkedinBaseTest{

    @DataProvider
    public Object[][] ValidDataProvider() {
        return new Object[][]{
                { "iteatest@i.ua", "1q2w3e_4r5t" },
                //{ "iteatest@I.UA", "1q2w3e_4r5t" }
        };
    }

    @Test(dataProvider = "ValidDataProvider")
	public void successfulLoginTest(String userEmail, String userPassword) {
		Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login page is not loaded");

        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(userEmail, userPassword);

		Assert.assertTrue(linkedinHomePage.isPageLoaded(),
				"Home page is not loaded");

	}

	@Test
	public void verifyLoginWithEmptyUsernameAndPassword() {
		linkedinLoginPage.login("", "");
		Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login page is not loaded.");
	}

    @Test
    public void verifyLoginWithValidUsernameAndShortPassword() {

        LinkedinLoginSubmitPage linkedinLoginSubmitPage = linkedinLoginPage.loginWithInvalidData("iteatest@i.ua", "1");

        Assert.assertEquals(linkedinLoginSubmitPage.getErrorMessageText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Error message text is wrong.");
    }






}
