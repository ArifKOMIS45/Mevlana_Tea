package stepDefinitions;

import cucumber.api.java.en.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import pages.*;
import utils.Drivers;

public class ProductFunctionality {
    private String numberOfStock;
    private int number;
    private int rand;
    private String val;
    private Product product;
    private Products products;
    private Home home;
    private Cart cart;
    private Actions action;
    private WebDriverWait wait;

    public ProductFunctionality(Product product, Products products, Home home, Cart cart) {
        this.product = product;
        this.products = products;
        this.home = home;
        this.cart = cart;
        action = new Actions(Drivers.getDriver());
        wait = new WebDriverWait(Drivers.getDriver(), 10);
    }

    @And("^Click on one of the products randomly which is in the stocks$")
    public void clickOnOneOfTheProductsRandomlyWhichIsInTheStocks() {
        products.javaScriptClick(products.getProductList().get(product.randomIndexForLists(products.getProductList())));
    }

    @When("^Click on the In den Warenkorb button$")
    public void clickOnTheInDenWarenkorbButton() {
        product.clickElement(product.getAddToCart());
    }

    @Then("^The product should have been added to the cart$")
    public void theProductShouldHaveBeenAddedToTheCart() {
        product.waitUntilVisible(product.getSuccessMsg());
        products.assertMessage(product.getSuccessMsg(), "wurde deinem Warenkorb hinzugefügt.");
    }

    @And("^Change the number of the product randomly less than the number in the stocks$")
    public void changeTheNumberOfTheProductRandomlyLessThanTheNumberInTheStocks() {
        numberOfStock = product.getStockNumber().getText().replaceAll("[^0-9]", "");
        number = Integer.parseInt(numberOfStock);
        rand = 1 + (int) (Math.random() * number);
        val = String.valueOf(rand);
        if (number == 1) {
            product.clickElement(product.getAddToCart());
        } else {
            products.sendKeys(product.getQuantityOfProduct(), val);
        }
    }

    @Then("^The correct number of the product should have been added to the cart$")
    public void theCorrectNumberOfTheProductShouldHaveBeenAddedToTheCart() {
        Assert.assertEquals(product.getQuantityOfProduct().getAttribute("value"),val);
        product.assertMessage(product.getSuccessMsg(),"Warenkorb hinzugefügt");
    }

    @When("^Click on the In den Warenkorb aktualisieren button$")
    public void clickOnTheInDenWarenkorbAktualisierenButton() {
        product.waitUntilVisible(product.getQuantityOfProduct());
        int index = 1 + (int) (Math.random() * Integer.parseInt(numberOfStock));
        product.sendKeys(product.getQuantityOfProduct(), String.valueOf(index));
        cart.clickElement(cart.getIconCancelBtn());
        cart.clickElement(cart.getUpdateShoppingCartBtn());
    }

    @Then("^The user should be able to update the cart$")
    public void theUserShouldBeAbleToUpdateTheCart() {
        wait.until(ExpectedConditions.invisibilityOf(product.getSuccessMsg()));
        if (!product.getQuantityOfProduct().getText().replaceAll("[^0-9]", "").equals("1")) {
            cart.assertMessage(product.getSuccessMsg(), "Warenkorb aktualisiert.");
        }
    }

    @When("^Click on the X button$")
    public void clickOnTheXButton() {
        cart.waitUntilVisible(cart.getXbtn());
        cart.clickElement(cart.getXbtn());
    }

    @Then("^The user should be able to delete the product from the cart$")
    public void theUserShouldBeAbleToDeleteTheProductFromTheCart() {
        cart.assertMessage(cart.getDeletedMessage(), "Dein Warenkorb ist gegenwärtig leer.");
    }

    @And("^Hover over one of the products' image randomly which is in the stocks$")
    public void hoverOverOneOfTheProductsImageRandomlyWhichIsInTheStocks() {
        rand = products.randomIndexForLists(products.getProductList());
        action.moveToElement(products.getProductList().get(rand)).build().perform();
    }

    @Then("^The user should be able to see the product details$")
    public void theUserShouldBeAbleToSeeTheProductDetails() {
        Assert.assertTrue(product.getProductDescription().isDisplayed());
    }

    @When("^Click on the Cart icon$")
    public void clickOnTheCartIcon() {
        products.getProductListBasket().get(rand).click();
    }

    @When("^Click on the Rückgängig button$")
    public void clickOnTheRückgängigButton() {
        cart.waitUntilVisible(cart.getRuckgangigBtn());
        cart.clickElement(cart.getRuckgangigBtn());
    }

    @Then("^The user should be able to readd the product to the cart$")
    public void theUserShouldBeAbleToReaddTheProductToTheCart() {
        cart.waitUntilVisible(cart.getItemText());
        Assert.assertTrue(cart.getItemText().isDisplayed());
    }

    @When("^Click on the Weiter einkaufen button$")
    public void clickOnTheWeiterEinkaufenButton() {
        cart.waitUntilVisible(cart.getWeiterEinkaufenBtn());
        cart.clickElement(cart.getWeiterEinkaufenBtn());
    }

    @Then("^The user should be able to see the Produkte page$")
    public void theUserShouldBeAbleToSeeTheProduktePage() {
        Assert.assertTrue(home.getHomePageProduct().isDisplayed());
    }

    @When("^Click on one of the products randomly which is in the out of stocks$")
    public void clickOnOneOfTheProductsRandomlyWhichIsInTheOutOfStocks() {
        products.javaScriptClick(products.getProductListOutofStoc().get(products.randomIndexForLists(products.getProductListOutofStoc())));
    }

    @Then("^The out of stock message should be seen$")
    public void theOutOfStockMessageShouldBeSeen() {
        products.assertMessage(products.getUtOfStocGetText(), "Nicht vorrätig");
    }
}
