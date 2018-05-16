import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class LinkedinLoginSubmitPage {


    private WebDriver webDriver;

    private WebElement errorMessageElement;

    public LinkedinLoginSubmitPage(WebDriver webDriver) {
       this.webDriver = webDriver;
       initElements();
    }

    private void initElements() {
        try {
            sleep (3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        errorMessageElement = webDriver.findElement(By.xpath("//div[@role='alert']"));
    }

    public String getErrorMessageText() {
        return errorMessageElement.getText();
    }
}
