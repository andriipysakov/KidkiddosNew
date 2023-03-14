import Pages.CartPage;
import Pages.ProductPage;
import Utils.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class ProductPageTest extends UseCaseBase {

    private static ProductPage productPage;
    public static final Logger logger = LogManager.getLogger(ProductPageTest.class);

    @BeforeAll
    public static void classSetup() {
        productPage = new ProductPage();
    }

    @BeforeEach
    public void beforeTest() {
        productPage.navigateToProductPage();
    }

    @Test
    public void addToCartTest() {
        logger.info("Add to cart test");
        //change format element
        webDriver.findElement(By.xpath("//option[text()='Paperback']")).click();
        WebElement format = webDriver.findElement(By.xpath("//option[text()='Hardcover']"));
        format.click();
        assertNotNull(format);
        //change quantity of element
        WebElement quantity = webDriver.findElement(By.id("Quantity"));
        quantity.clear();
        quantity.sendKeys("5");
        assertNotNull(quantity);
        webDriver.findElement(By.xpath("//span[text()='Add to cart']")).click();
        // assert visibility Cart Page
        logger.info("Cart Page load test");
        CartPage cartPage = new CartPage();
        cartPage.navigateToCartPage();
        Boolean success = cartPage.isCartPageTitleVisible();
        cartPage.takeScreenshot("CartPageTest");
        assertTrue(success);
    }

}