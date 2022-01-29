package stepDefinitions;

import cucumber.api.java.en.*;
import org.testng.Assert;
import pages.*;

public class SubmenusOfTheAboutUsFunctionality {

    private Home hm;
    private UberUns uberUns;

    public SubmenusOfTheAboutUsFunctionality(Home hm, UberUns uberUns) {
        this.hm = hm;
        this.uberUns = uberUns;
    }

    @Given("^Hover over the About Us button$")
    public void hover_over_the_About_Us_button() {
        uberUns.hoverOverRandomlyOnAnElement(hm.getHomePageAboutUs());
    }

    @Then("^The user should be able to see the sub menus of the About Us page$")
    public void the_user_should_be_able_to_see_the_sub_menus_of_the_Uber_Uns_page() {
        boolean submenuEnabled = hm.getAboutUsSubmenu().isEnabled();
        Assert.assertTrue(submenuEnabled);
    }

    @And("^Click on the TV Ads button$")
    public void clickOnTheTVSpotsButton() {
        uberUns.getTvAds().click();
    }

    @Then("^The user should be able see the TV Ads page\\.$")
    public void theUserShouldBeAbleSeeTheTVAdsPage() {
        uberUns.assertUrl("tv-spots", "tv-reklamlari", "tv-ads");
    }

    @And("^Click on the Impressum button$")
    public void clickOnTheImpressumButton() {
        uberUns.getImpressum().click();
    }

    @Then("^The user should be able to see the Impressum page$")
    public void theUserShouldBeAbleToSeeTheImpressumPage() {
        uberUns.assertUrl("impressum", "kunye", "impressum");
    }

    @And("^Click on the FAQ button$")
    public void clickOnTheFAQButton() {
        uberUns.getFaq().click();
    }

    @Then("^The user should be able to see the FAQ page$")
    public void theUserShouldBeAbleToSeeTheFAQPage() {
        uberUns.assertUrl("haufig-gestellte-fragen", "sss", "faq");
    }
}
