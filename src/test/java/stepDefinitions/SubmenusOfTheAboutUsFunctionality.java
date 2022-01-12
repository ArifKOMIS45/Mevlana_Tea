package stepDefinitions;

import cucumber.api.java.en.*;
import org.testng.Assert;
import pages.Home;
import pages.UberUns;
import utils.Drivers;

public class SubmenusOfTheAboutUsFunctionality {

    Home hm;
    UberUns uberUns;
    public SubmenusOfTheAboutUsFunctionality (Home hm,UberUns uberUns) {
        this.hm = hm;
        this.uberUns =uberUns;
    }

    @Given("^Hover over the About Us button$")
    public void hover_over_the_About_Us_button() {
        hm.hoverOverRandomlyOnAnElement(hm.getHome_page_About_Us());
    }

    @Then("^The user should be able to see the sub menus of the About Us page$")
    public void the_user_should_be_able_to_see_the_sub_menus_of_the_Uber_Uns_page()  {
        boolean submenuEnabled=hm.getAbout_Us_Submenu().isEnabled();
        Assert.assertTrue(submenuEnabled);
    }

    @And("^Click on the TV Ads button$")
    public void clickOnTheTVSpotsButton() {
        uberUns.getTvAds().click();
    }

    @Then("^The user should be able see the TV Ads page\\.$")
    public void theUserShouldBeAbleSeeTheTVAdsPage() {

        switch (Drivers.threadLanguage.get())
        {
            case "DE":hm.assertUrl("tv-spots");
                break;
            case "TR":hm.assertUrl("tv-reklamlari");
                break;
            case "EN": hm.assertUrl("tv-ads");
                break;
        }
    }

    @And("^Click on the Impressum button$")
    public void clickOnTheImpressumButton() {
        uberUns.getImpressum().click();
    }

    @Then("^The user should be able to see the Impressum page$")
    public void theUserShouldBeAbleToSeeTheImpressumPage() {

        switch (Drivers.threadLanguage.get())
        {
            case "DE":
            case "EN":
                hm.assertUrl("impressum");
            break;
            case "TR":hm.assertUrl("kunye");
            break;
        }
    }

    @And("^Click on the FAQ button$")
    public void clickOnTheFAQButton() {
        uberUns.getFaq().click();
    }

    @Then("^The user should be able to see the FAQ page$")
    public void theUserShouldBeAbleToSeeTheFAQPage() {
        switch (Drivers.threadLanguage.get())
        {
            case "DE":hm.assertUrl("haufig-gestellte-fragen");
                break;
            case "TR":hm.assertUrl("sss");
                break;
            case "EN": hm.assertUrl("faq");
                break;
        }
    }


}
