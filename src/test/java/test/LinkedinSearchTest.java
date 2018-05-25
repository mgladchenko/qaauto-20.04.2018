package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinLoginPage;
import page.LinkedinSearchPage;

import java.util.List;

public class LinkedinSearchTest extends LinkedinBaseTest {

    @Test
    public void basicSearchTest() {
        String searchTerm = "HR";

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Linkedin Login page is not loaded.");

        linkedinLoginPage.login("iteatest@i.ua", "1q2w3e_4r5t");

        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(webDriver);
        Assert.assertTrue(linkedinHomePage.isPageLoaded(),
                "Linkedin Home page is not loaded.");

        linkedinHomePage.search(searchTerm);

        LinkedinSearchPage linkedinSearchPage = new LinkedinSearchPage(webDriver);
        Assert.assertTrue(linkedinSearchPage.isPageLoaded(),
                "Linkedin Search page is not loaded.");

        Assert.assertEquals(linkedinSearchPage.getResultsCount(), 10,
                "Search results count is wrong.");

        List<String> resultsList = linkedinSearchPage.getResultsList();

        for (String result:resultsList) {
            Assert.assertTrue(result.contains(searchTerm),
                    "Searchterm "+searchTerm+" is missing in following result:\n"+result);
        }



    }
}
