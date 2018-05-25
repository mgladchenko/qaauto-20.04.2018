package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.LinkedinBasePage;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class LinkedinSearchPage extends LinkedinBasePage {
    WebElement resultsCounter;
    List<WebElement> searchResults;


    public LinkedinSearchPage(WebDriver webDriver) {
        super(webDriver);
        initElements();
    }

    private void initElements() {
        try {
            sleep (3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //resultsCounter = webDriver.findElement(By.xpath("//h3[contains(text(), 'results')]"));
        searchResults = webDriver.findElements(By.xpath("//li[contains(@class, 'search-result__occluded-item')]"));
    }

    @Override
    public boolean isPageLoaded() {
        return true;
        //return resultsCounter.isDisplayed();
    }

    public int getResultsCount() {
        return searchResults.size();
    }

    public List<String> getResultsList() {
        List<String> searchResultsList = new ArrayList();
        for (WebElement searchResult:searchResults) {
            ((JavascriptExecutor)webDriver).executeScript(
                    "arguments[0].scrollIntoView();", searchResult);

            String searchResultText = searchResult.getText();
            searchResultsList.add(searchResultText);
        }
        return searchResultsList;
    }
}
