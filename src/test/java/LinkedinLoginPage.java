import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class LinkedinLoginPage {

	private WebDriver webDriver;

	private WebElement userEmailField;
	private WebElement userPasswordField;
	private WebElement signInButton;

	private WebElement errorMesageElement;

	public LinkedinLoginPage(WebDriver webDriver) {
		this.webDriver = webDriver;
        initElements();
	}

	private void initElements() {
        userEmailField = webDriver.findElement(By.xpath("//input[@id='login-email']"));
		userPasswordField = webDriver.findElement(By.xpath("//*[@id='login-password']"));
		signInButton = webDriver.findElement(By.xpath("//*[@id='login-submit']"));


	}

	public void login(String userEmail, String userPassword) {
		userEmailField.sendKeys(userEmail);
		userPasswordField.sendKeys(userPassword);
		signInButton.click();
	}

	public String getErrorMessageText() {
        try {
            sleep (5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        errorMesageElement = webDriver.findElement(By.xpath("//div[@role='alert']"));
        return errorMesageElement.getText();
    }

	public boolean isSignInButtonDisplayed() {
		return signInButton.isDisplayed();
	}

	public String getCurrentPageTitle() {
		return webDriver.getTitle();
	}

}
