package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Drivers;
import utils.Parent;
import java.util.List;

public class Home extends Parent {

    public Home() {
        PageFactory.initElements(Drivers.getDriver(), this);
    }

    @FindBy(id = "mailchimp-top-bar__email")
    private WebElement HomeEmailInput;

    @FindBy(css = "label[class='mctb-response-label']")
    private WebElement HomeEMailBarMenuMessage;

    @FindBy(className = "mctb-button")
    private WebElement HomeEmailSubmit;

    @FindBy(xpath = "//span[.='Accept all']")
    private WebElement HomeCookiseAccept;

    @FindBy(css = "ul[id='menu-ana-menu']>:nth-child(1)")
    private WebElement HomePageHome;

    @FindBy(xpath = "(//ul[@id='menu-ana-menu']//li)[2]")
    private WebElement HomePageProduct;

    @FindBy(css = "ul[id='menu-ana-menu']>:nth-child(3)")
    private WebElement HomePageAboutUs;

    @FindBy(xpath = "//span[text()='BLOG']")
    private WebElement HomePageBlog;

    @FindBy(css = "ul[id='menu-ana-menu']>:nth-child(5)")
    private WebElement HomePageContact;

    @FindBy(className = "mctb-response-label")
    private WebElement HomeMailSubmitAnswer;

    @FindBy(xpath = "//a[text()='Facebook']")
    private WebElement HomeFacebook;

    @FindBy(xpath = "//a[text()=' Instagram']")
    private WebElement HomeInstagram;

    @FindBy(xpath = "//a[text()=' Twitter']")
    private WebElement HomeTwitter;

    @FindBy(css = "div#sbi_load>span>a")
    private WebElement HomeInstagramBottomButton;

    @FindBy(className = "icon-bag-fine")
    private WebElement HomeTopCart;

    @FindBy(css = "ul[id='menu-ana-menu']>:nth-child(6)")
    private WebElement allFlags;

    @FindBy(id = "menu-item-22453")
    private WebElement TcFlage;

    @FindBy(id = "menu-item-22455")
    private WebElement EnFlage;

    @FindBy(id = "menu-item-22454")
    private WebElement DeFlage;

    @FindBy(className = "mctb-close")
    private WebElement closeEMail;

    @FindBy(className = "icon-menu-fine")
    private WebElement hamburger;

    @FindBy(id = "slide-cart")
    private WebElement mobilCart;

    @FindBy(xpath = "(//li//span[@class='menu-toggle'])[3]")
    private WebElement toggleFlags;

    @FindBy(className = "mctb-label")
    private WebElement eMailMessage;

    @FindBy(css = "li[id='menu-item-21588']>ul.sub-menu[style='display: block;']")
    private WebElement aboutUsSubmenu;

    @FindBy(css = "li[id='menu-item-22796']>ul.sub-menu[style='display: block;']")
    private WebElement productSubMenu;

    @FindBy(css = "#menu-item-22796>ul a")
    private List<WebElement> productSubMenuList;

    @FindBy(css = "input[name='EMAIL']")
    private WebElement HomeEmailBottomInput;

    @FindBy(css = "center>input")
    private WebElement HomeEmailBottomSend;

    @FindBy(css = "div[class='mc4wp-alert mc4wp-success']>p")
    private WebElement HomeEmailBottomSuccessMessage;

    @FindBy(className = "mc4wp-response")
    private WebElement HomeEmailBottomSendenAnswer;

    @FindBy(css = ".widget_mfn_menu ul li a")
    private List<WebElement> footerMenuList;

    public List<WebElement> getFooterMenuList() {
        return footerMenuList;
    }
    public List<WebElement> getProductSubMenuList() {
        return productSubMenuList;
    }

    public WebElement getProductSubMenu() {
        return productSubMenu;
    }

    public WebElement getAboutUsSubmenu() {
        return aboutUsSubmenu;
    }

    public WebElement getTcFlage() {
        return TcFlage;
    }

    public WebElement getEnFlage() {
        return EnFlage;
    }

    public WebElement getDeFlage() {
        return DeFlage;
    }

    public WebElement getHomeTopCart() {
        return HomeTopCart;
    }

    public WebElement getHomeFacebook() {
        return HomeFacebook;
    }

    public WebElement getHomeInstagram() {
        return HomeInstagram;
    }

    public WebElement getHomeTwitter() {
        return HomeTwitter;
    }

    public WebElement getHomeInstagramBottomButton() {
        return HomeInstagramBottomButton;
    }

    public WebElement getHomeMailSubmitAnswer() {
        return HomeMailSubmitAnswer;
    }

    public WebElement getHomeEmailInput() {
        return HomeEmailInput;
    }

    public WebElement getHomeCookiseAccept() {
        return HomeCookiseAccept;
    }

    public WebElement getHomePageHome() {
        return HomePageHome;
    }

    public WebElement getHomePageProduct() {
        return HomePageProduct;
    }

    public WebElement getHomePageAboutUs() {
        return HomePageAboutUs;
    }

    public WebElement getHomePageBlog() {
        return HomePageBlog;
    }

    public WebElement getHomePageContact() {
        return HomePageContact;
    }

    public WebElement getHomeEmailSubmit() {
        return HomeEmailSubmit;
    }

    public WebElement getCloseEMail() {
        return closeEMail;
    }

    public WebElement getHamburger() {
        return hamburger;
    }

    public WebElement getMobilCart() {
        return mobilCart;
    }

    public WebElement getAllFlags() {
        return allFlags;
    }

    public WebElement getToggleFlags() {
        return toggleFlags;
    }

    public WebElement geteMailMessage() {
        return eMailMessage;
    }

    public WebElement getHomeEmailBottomInput() {
        return HomeEmailBottomInput;
    }

    public WebElement getHomeEmailBottomSend() {
        return HomeEmailBottomSend;
    }

    public WebElement getHomeEmailBottomSendenAnswer() {
        return HomeEmailBottomSendenAnswer;
    }

    public WebElement getHomeEmailBottomSuccessMessage() {
        return HomeEmailBottomSuccessMessage;
    }

    public WebElement getHomeEMailBarMenuMessage() {
        return HomeEMailBarMenuMessage;
    }

}
