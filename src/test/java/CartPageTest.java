import Pages.CartPage;
import Utils.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class CartPageTest extends UseCaseBase {

    private static CartPage cartPage;
    public static final Logger logger = LogManager.getLogger(CartPageTest.class);

    @BeforeAll
    public static void classSetup() {
        cartPage = new CartPage();
    }

    @BeforeEach
    public void beforeTest() {
        cartPage.navigateToCompleteCartPage();
    }

    @Test
    public void changeQuantityCartTest() {
        logger.info("Change quantity cart test");
        String currentPrice = webDriver.findElement(By.xpath("//span[@class='cart__subtotal']")).getText();
        //change quantity of element
        WebElement quantity = webDriver.findElement(By.xpath("//input[@type='number']"));
        quantity.clear();
        quantity.sendKeys("6");
        assertNotNull(quantity);
        webDriver.findElement(By.xpath("//input[@class='btn btn--secondary cart__update cart__update--large small--hide']")).click();
        // assert changed quantity
        assertEquals("6", webDriver.findElement(By.xpath("//input[@value='6']")).getAttribute("value"));
        // assert changed price
        String newPrice = webDriver.findElement(By.xpath("//span[@class='cart__subtotal']")).getText();
        assertNotEquals(newPrice, currentPrice);
    }

}