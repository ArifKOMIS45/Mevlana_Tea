package stepDefinitions;
import cucumber.api.java.en.*;
import pages.Home;

public class SocialMediaButtonFunctionality {

    private Home hm;
    public SocialMediaButtonFunctionality (Home hm) {
        this.hm = hm;
    }

    @Given("^Click on the \"([^\"]*)\" button$")
    public void clickOnTheButton(String name) {
        switch (name) {
            case "Facebook":
                hm.getHomeFacebook().click();
                break;
            case "Twitter":
                hm.getHomeTwitter().click();
                break;
            case "Instagram":
                hm.getHomeInstagram().click();
                break;
            case "InstagramBottom":
                hm.getHomeInstagramBottomButton().click();
                break;
        }
    }

    @Then("^The user should be able to see the \"([^\"]*)\" page of the company$")
    public void theUserShouldBeAbleToSeeThePageOfTheCompany(String socialMediaPageUrl)  {
        hm.switchToNewTab();
        hm.assertUrl(socialMediaPageUrl);
    }
}





