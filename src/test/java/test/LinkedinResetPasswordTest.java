package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

public class LinkedinResetPasswordTest extends LinkedinBaseTest{

    @Test
    public void successfulPasswordReset() {
        String userEmail = "mykola.gladchenko@gmail.com";


        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login page is not loaded.");

        LinkedinRequestPasswordResetPage linkedinRequestPasswordResetPage = linkedinLoginPage.clickOnForgotPasswordLink();
        Assert.assertTrue(linkedinRequestPasswordResetPage.isPageLoaded(),
                "RequestPasswordReset page is not loaded.");

        LinkedinRequestPasswordResetSubmitPage linkedinRequestPasswordResetSubmitPage = linkedinRequestPasswordResetPage.submitUserEmail(userEmail);
        Assert.assertTrue(linkedinRequestPasswordResetSubmitPage.isPageLoaded(),
                "RequestPasswordResetSubmit page is not loaded.");

        LinkedinSetNewPasswordPage setNewPasswordPage = linkedinRequestPasswordResetSubmitPage.navigateToLinkFromEmail();
        Assert.assertTrue(setNewPasswordPage.isPageLoaded(),
                "NewPasswordPage page is not loaded.");

        LinkedinPasswordChangeConfirmedPage linkedinPasswordChangeConfirmedPage = setNewPasswordPage.setNewUserPassword();
        Assert.assertTrue(linkedinPasswordChangeConfirmedPage.isPageLoaded(),
                "PasswordChangeConfirmed page is not loaded.");

        LinkedinHomePage linkedinHomePage = linkedinPasswordChangeConfirmedPage.clickOnGoToHomeButton();
        Assert.assertTrue(linkedinHomePage.isPageLoaded(),
                "HomePage page is not loaded.");



    }

}
