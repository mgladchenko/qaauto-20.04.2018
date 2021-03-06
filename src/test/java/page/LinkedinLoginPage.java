package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

/**
 * PageObject of LinkedinLoginPage with methods and variables
 */
public class LinkedinLoginPage extends LinkedinBasePage {

    @FindBy(xpath = "//input[@id='login-email']")
	private WebElement userEmailField;

    @FindBy(xpath = "//*[@id='login-password']")
	private WebElement userPasswordField;

    @FindBy(xpath = "//*[@id='login-submit']")
	private WebElement signInButton;

    @FindBy(xpath = "//a[@class='link-forgot-password']")
    private WebElement forgotPasswordLink;

    /**
     * Constructor of LinkedinLoginPage class
     * @param webDriver - current webDriver object
     */
	public LinkedinLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
	}

    /**
     * Check if Page is loaded
     * @return true/false
     */
    public boolean isPageLoaded() {
        return signInButton.isDisplayed();
    }

	public LinkedinHomePage login(String userEmail, String userPassword) {
		userEmailField.sendKeys(userEmail);
		userPasswordField.sendKeys(userPassword);
		signInButton.click();
		//return new LinkedinHomePage(webDriver);
        return PageFactory.initElements(webDriver, LinkedinHomePage.class);
	}

    public LinkedinLoginSubmitPage loginWithInvalidData(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        return new LinkedinLoginSubmitPage(webDriver);
    }

    public LinkedinRequestPasswordResetPage clickOnForgotPasswordLink() {
        forgotPasswordLink.click();
	    return new LinkedinRequestPasswordResetPage(webDriver);
    }
}
