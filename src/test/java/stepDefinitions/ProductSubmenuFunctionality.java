package stepDefinitions;

import cucumber.api.java.en.*;
import org.testng.Assert;
import pages.Home;

public class ProductSubmenuFunctionality {

    private Home hm;

    public ProductSubmenuFunctionality(Home hm) {
        this.hm = hm;
    }

    @Given("^Hover over the Product Button$")
    public void hover_over_the_Product_Button() {
        hm.hoverOverRandomlyOnAnElement(hm.getHomePageProduct());
    }

    @Then("^User should be able to see the sub menus of the Product page$")
    public void userShouldBeAbleToSeeTheSubMenusOfTheProductPage() {
        boolean submenuEnabled = hm.getProductSubMenu().isEnabled();
        Assert.assertTrue(submenuEnabled);
    }

    @Then("^Click on the sub menus of the Product Button$")
    public void click_on_the_sub_menus_of_the_Product_Button() {
        for (int i = 0; i < hm.getProductSubMenuList().size(); i++) {
            hm.hoverOverRandomlyOnAnElement(hm.getHomePageProduct());
            hm.getProductSubMenuList().get(i).click();
            String url = hm.getProductSubMenuList().get(i).getAttribute("href");
            hm.assertUrl(url);
        }
    }
}
