import Pages.LoginPage;
import Utils.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class LoginPageTest extends UseCaseBase {

    private static LoginPage loginPage;
    public static final Logger logger = LogManager.getLogger(LoginPageTest.class);

    @BeforeAll
    public static void classSetup() {
        loginPage = new LoginPage();
    }

    @BeforeEach
    public void beforeTest() {
        loginPage.navigateToLoginPage();
    }

    @Test
    public void inputEmptyUserPassTest() {
        logger.info("Login Page empty username and password test");
        //find email element
        WebElement emailElement = webDriver.findElement(By.xpath("//input[@type='email']"));
        // send text
        emailElement.sendKeys("");
        WebElement passwordElement = webDriver.findElement(By.xpath("//input[@type='password']"));
        // send text
        passwordElement.sendKeys("");
        //get text from browser
        String emailValue = emailElement.getAttribute("value");
        //verify text is correct
        assertEquals("", emailValue);
        //get text from browser
        String passwordValue = passwordElement.getAttribute("value");
        //verify text is correct
        assertEquals("", passwordValue);
        webDriver.findElement(By.xpath("//input[@type='submit']")).click();
        Boolean success = loginPage.isLoginPageErrorVisible();
        loginPage.takeScreenshot("LoginPageTest");
        assertTrue(success);
    }

    @Test
    public void inputIncorrectUserPassTest() {
        logger.info("Login Page incorrect username and password test");
        //find email element
        WebElement emailElement = webDriver.findElement(By.xpath("//input[@type='email']"));
        // send text
        emailElement.sendKeys("hello@sdv.sef");
        WebElement passwordElement = webDriver.findElement(By.xpath("//input[@type='password']"));
        // send text
        passwordElement.sendKeys("123456");
        //get text from browser
        String emailValue = emailElement.getAttribute("value");
        //verify text is correct
        assertEquals("hello@sdv.sef", emailValue);
        //get text from browser
        String passwordValue = passwordElement.getAttribute("value");
        //verify text is correct
        assertEquals("123456", passwordValue);
        webDriver.findElement(By.xpath("//input[@type='submit']")).click();
        Boolean success = loginPage.isLoginPageErrorVisible();
        loginPage.takeScreenshot("LoginPageTest");
        assertTrue(success);
    }

}