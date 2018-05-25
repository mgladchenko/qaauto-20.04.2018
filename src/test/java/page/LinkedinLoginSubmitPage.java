package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.LinkedinBasePage;

import static java.lang.Thread.sleep;

public class LinkedinLoginSubmitPage extends LinkedinBasePage {

    private WebElement userEmailField;
    private WebElement errorMessageElement;

    public LinkedinLoginSubmitPage(WebDriver webDriver) {
        super(webDriver);
        initElements();
    }

    @Override
    boolean isPageLoaded() {
        return userEmailField.isDisplayed();
    }

    private void initElements() {
        try {
            sleep (3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userEmailField = webDriver.findElement(By.xpath("//input[@id='session_key-login']"));
        errorMessageElement = webDriver.findElement(By.xpath("//div[@role='alert']"));
    }

    public String getErrorMessageText() {
        return errorMessageElement.getText();
    }
}
