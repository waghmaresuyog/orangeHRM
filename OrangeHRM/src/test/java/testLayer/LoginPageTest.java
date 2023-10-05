package testLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

public class LoginPageTest extends TestBase {

    @Test
    public void verifyLogin() throws InterruptedException {
        loginPage.enterUsername();
        Thread.sleep(10);
        loginPage.enterPassword();
        loginPage.clickOnSubmit();

        WebElement successMessage = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']"));
        String message = successMessage.getText();
        // Assert that the success message is displayed
        if (message.equals("Dashboard"))
            Assert.assertEquals(successMessage, "Dashboard");
        Assert.assertTrue(successMessage.isDisplayed(), "Login was not successful.");
    }
}
