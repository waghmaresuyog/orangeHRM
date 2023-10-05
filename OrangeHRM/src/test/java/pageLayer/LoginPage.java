package pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.TestBase;


public class LoginPage extends TestBase {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active' and @name='username']")
    private WebElement username;

    public void enterUsername() {
        username.sendKeys("Admin");
    }

    @FindBy(xpath = "//input[@type=\"password\"]")
    private WebElement password;

    public void enterPassword(){
        password.sendKeys("admin123");
    }

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement loginButton;

    public void clickOnSubmit(){
        loginButton.click();
    }


}
