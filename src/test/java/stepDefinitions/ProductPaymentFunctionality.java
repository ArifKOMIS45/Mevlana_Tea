package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.*;
import pages.*;
import utils.Drivers;

public class ProductPaymentFunctionality {
    private Product product;
    private CheckOut checkOut;
    private Cart cart;
    private WebDriverWait wait;

    public ProductPaymentFunctionality(Product product, CheckOut checkOut, Cart cart) {
        this.checkOut = checkOut;
        this.product = product;
        this.cart = cart;
        wait = new WebDriverWait(Drivers.getDriver(), 15);
    }

    @When("^Click on the PayPal button$")
    public void clickOnThePayPalButton() {
//        wait.until(ExpectedConditions.visibilityOf(product.getiFrame()));
//        Drivers.getDriver().switchTo().frame(product.getiFrame());
       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(product.getiFrame()));
        product.clickElement(product.getPayPall());
    }

    @Then("^The user should be able to see PayPal login page$")
    public void theUserShouldBeAbleToSeePayPalLoginPage() {
        product.switchToNewTab();
        wait.until(ExpectedConditions.visibilityOf(product.getPayPalButton()));
        product.assertUrl("paypal.com");
    }

    @Then("^Click on the Weiter zur Kasse button$")
    public void clickOnTheWeiterZurKasseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(cart.getCheckOutBtn()));
        cart.clickElement(cart.getCheckOutBtn());
    }

    @And("^Fill the name \"([^\"]*)\"$")
    public void fillTheName(String name) {
        checkOut.sendKeys(checkOut.getFirstName(), name);
    }


    @And("^Fill the nachname \"([^\"]*)\"$")
    public void fillTheNachname(String nachname) {
        checkOut.sendKeys(checkOut.getLastName(), nachname);
    }

    @And("^Fill the straße \"([^\"]*)\"$")
    public void fillTheStraße(String street) {
        checkOut.sendKeys(checkOut.getAddress(), street);
    }

    @And("^Fill the postleitzahl \"([^\"]*)\"$")
    public void fillThePostleitzahl(String postcode) {
        checkOut.sendKeys(checkOut.getPostCode(), postcode);
    }

    @And("^Fill the Ort \"([^\"]*)\"$")
    public void fillTheOrt(String city) {
        checkOut.sendKeys(checkOut.getCity(), city);
    }

    @And("^Fill the telefon  \"([^\"]*)\"$")
    public void fillTheTelefon(String number) {
        checkOut.sendKeys(checkOut.getPhone(), number);
    }

    @And("^Fill the email \"([^\"]*)\"$")
    public void fillTheEmail(String email) {
        checkOut.sendKeys(checkOut.getEmail(), email);
    }



    @And("^Select the ([^\"]*)$")
    public void selectThe(Boolean term) {
        wait.until(ExpectedConditions.elementToBeClickable(checkOut.getTermsAndConditions()));
        if (term) checkOut.clickElement(checkOut.getTermsAndConditions());
    }

    @Then("^The user shoul be able to see the appropriate \"([^\"]*)\"$")
    public void theUserShoulBeAbleToSeeTheAppropriate(String message) {
        if (!(message.equals(""))) {
            checkOut.assertMessage(checkOut.getErrorMessage(), message);
        }
    }

    @When("^Click on the \"([^\"]*)\"$")
    public void clickOnThe(Boolean bessellen) {
        if (bessellen) checkOut.clickElement(checkOut.getPlaceOrder());
    }

    @Then("^Click on the Gutschein message$")
    public void click_on_the_Gutschein_message() {
        checkOut.clickElement(checkOut.getShowCoupon());
    }

    @Then("^Fill the Gutschein code field randomly \"([^\"]*)\"$")
    public void fill_the_Gutschein_code_field_randomly(String couponNo) {
        checkOut.sendKeys(checkOut.getCouponCodeInput(), couponNo);
    }

    @When("^click on the Gutschein anwenden button$")
    public void click_on_the_Gutschein_anwenden_button() {
        checkOut.clickElement(checkOut.getApplyCoupon());
    }

    @Then("^The user should be able to see Der Gutschein  message$")
    public void the_user_should_be_able_to_see_Der_Gutschein_message() {
        checkOut.assertMessage(checkOut.getCouponErrorMessage(), "existiert nicht");
    }

    @When("^Select ([^\"]*) as payment option$")
    public void selectAsPaymentOption(Boolean msj) {
        if (msj) {
            checkOut.clickElement(checkOut.getBankTransferRadio());
        }
    }

    @When ("^Select ([^\"]*) as payment \"([^\"]*)\"$")
        public void selectAsPayment(Boolean payment, String option) {
        if (payment) {
            checkOut.waitUntilVisible(checkOut.getiFrame());
            if (!checkOut.getCreditCardRadio().isSelected()) {
                checkOut.clickElement(checkOut.getCreditCardRadio());
            }
            Drivers.getDriver().switchTo().frame(product.getiFrame());
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("[class= 'nameRow']"), 1));
            switch (option) {
                case "Paypal":
                    if (!checkOut.getPaymentMethods().get(0).isSelected())
                        checkOut.javaScriptClick(checkOut.getPaymentMethods().get(0));
                    break;
                case "Lastschrift":
                    checkOut.javaScriptClick(checkOut.getPaymentMethods().get(1));
                    break;
                case "Kreditkarte":
                    checkOut.javaScriptClick(checkOut.getPaymentMethods().get(2));
                    break;
            }
            Drivers.getDriver().switchTo().defaultContent();
        }
    }
}
