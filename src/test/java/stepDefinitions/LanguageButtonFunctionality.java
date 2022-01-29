package stepDefinitions;

import cucumber.api.java.en.*;
import org.openqa.selenium.interactions.Actions;
import pages.Home;
import utils.Drivers;

public class LanguageButtonFunctionality {
    private Home hm;
    private Actions actions;

    public LanguageButtonFunctionality(Home hm) {
        this.hm = hm;
        actions = new Actions(Drivers.getDriver());
    }

    @Given("^Hover over the Language Button$")
    public void hoverOverTheLanguageButton() {
        actions.moveToElement(hm.getAllFlags()).build().perform();
    }

    @And("^Select  \"([^\"]*)\" from the options$")
    public void selectFromTheOptions(String language) {
        if (language.equals("DE")) {
            hm.clickElement(hm.getDeFlage());
        } else if (language.equals("TR")) {
            hm.clickElement(hm.getTcFlage());
        } else {
            hm.clickElement(hm.getEnFlage());
        }
    }

    @Then("^The user should be able to see the web Page in selected \"([^\"]*)\"$")
    public void theUserShouldBeAbleToSeeTheWebPageInSelected(String language) {
        if (language.equals("DE")) {
            hm.assertUrl("mevlanacay.de");
        } else if (language.equals("TR")) {
            hm.assertUrl("de/tr");
        } else {
            hm.assertUrl("de/en/");
        }
    }
}
