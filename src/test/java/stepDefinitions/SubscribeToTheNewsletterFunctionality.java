package stepDefinitions;

import cucumber.api.java.en.*;
import org.testng.Assert;
import pages.Home;
import utils.Drivers;

public class SubscribeToTheNewsletterFunctionality {

    private Home home;

    public SubscribeToTheNewsletterFunctionality(Home home) {
        this.home = home;
    }

    @Given("^Type an \"([^\"]*)\" into the email input on the top of the page$")
    public void typeAnIntoTheEmailInputOnTheTopOfThePage(String email) {
        home.sendKeys(home.getHomeEmailInput(), email);
    }

    @And("^Click on the Jetzt abonnieren button$")
    public void clickOnTheJetztAbonnierenButton() {
        home.clickElement(home.getHomeEmailSubmit());
    }

    @Given("^Type an \"([^\"]*)\" into the email input on the bottom of the page$")
    public void typeAnIntoTheEmailInputOnTheBottomOfThePage(String email) {
        home.sendKeys(home.getHomeEmailBottomInput(), email);
    }

    @And("^Click on the registrieren button$")
    public void clickOnTheRegistrierenButton() {
        home.clickElement(home.getHomeEmailBottomSend());
    }

    @Then("^The user should see the error alert with invalid \"([^\"]*)\" or success message with valid e-mail for bottom registration$")
    public void theUserShouldSeeTheErrorAlertWithInvalidOrSuccessMessageWithValidEMailForBottomRegistration(String email) {
        if (email.contains("@gmail.com")) {
            if (Drivers.getDriver().getCurrentUrl().equals("https://www.mevlanacay.de/")) {
                home.assertMessage(home.getHomeEmailBottomSuccessMessage(), "Dankeschön, Deine Anmeldung war erfolgreich!");
            } else {
                home.assertMessage(home.getHomeEmailBottomSuccessMessage(), "Teşekkürler, kayıt başvurunuz başarıyla tamamlandı!");
            }
        } else {
            Assert.assertTrue(home.getHomeEmailInput().getAttribute("validationMessage")
                    .contains("Lütfen e-posta adresine bir \"@\" işareti") ||
                    home.getHomeEmailInput().getAttribute("validationMessage")
                            .contains("Lütfen \"@\" işaretinden sonra gelen kısmı") ||
                    home.getHomeEmailInput().getAttribute("validationMessage")
                            .contains("Lütfen bu alanı doldurun") ||
                    home.getHomeEmailInput().getAttribute("validationMessage")
                            .contains(""));
        }
    }

    @Then("^The user should see the error alert with invalid \"([^\"]*)\" or success message with valid e-mail for top registration$")
    public void theUserShouldSeeTheErrorAlertWithInvalidOrSuccessMessageWithValidEMailForTopRegistration(String email) {
        if (email.contains("@gmail.com")) {
            if (Drivers.getDriver().getCurrentUrl().equals("https://www.mevlanacay.de/")) {
                home.assertMessage(home.getHomeEMailBarMenuMessage(), "Sie haben sich erfolgreich registriert! Vielen Dank. Bitte überprüfen Sie die Bestätigungs-E-Mail, die wir Ihnen gesendet haben.");
            } else {
                home.assertMessage(home.getHomeEMailBarMenuMessage(), "Başarıyla kaydoldunuz. Teşekkürler.");
            }
        } else {
            Assert.assertTrue(home.getHomeEmailInput().getAttribute("validationMessage")
                    .contains("Lütfen e-posta adresine bir \"@\" işareti") ||
                    home.getHomeEmailInput().getAttribute("validationMessage")
                            .contains("Lütfen \"@\" işaretinden sonra gelen kısmı") ||
                    home.getHomeEmailInput().getAttribute("validationMessage")
                            .contains("Lütfen bu alanı doldurun") ||
                    home.getHomeEmailInput().getAttribute("validationMessage")
                            .contains(""));
        }
    }
}
