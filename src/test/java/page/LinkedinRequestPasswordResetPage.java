package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

public class LinkedinRequestPasswordResetPage extends LinkedinBasePage {

    @FindBy(xpath = "//input[@id='username']")
    private WebElement userEmailField;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement submitButton;


    public LinkedinRequestPasswordResetPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        return userEmailField.isDisplayed();
    }

    public LinkedinRequestPasswordResetSubmitPage submitUserEmail(String userEmail) {
        gMailService.connect();
        userEmailField.sendKeys(userEmail);
        submitButton.click();
        return new LinkedinRequestPasswordResetSubmitPage(webDriver);
    }
}
