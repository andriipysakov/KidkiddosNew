package Pages;

import Consts.Consts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CartPage extends BasePage {

    public static final String CART_PAGE_HEADER = "//h1[text()='Your cart']";
    public void navigateToCartPage() {
        webDriver.get(Consts.CART_PAGE_URL);
    }

    public void navigateToCompleteCartPage() {
        webDriver.get(Consts.PRODUCT_PAGE_URL);
        //change quantity of element
        WebElement quantity = webDriver.findElement(By.id("Quantity"));
        quantity.clear();
        quantity.sendKeys("5");
        assertNotNull(quantity);
        webDriver.findElement(By.id("AddToCartText-product-template")).click();
    }

    public boolean isCartPageTitleVisible() {
        return elementExists(CART_PAGE_HEADER);
    }

}
