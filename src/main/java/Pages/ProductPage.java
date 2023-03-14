package Pages;

import Consts.Consts;

public class ProductPage extends BasePage {

    public static final String PRODUCT_PAGE_HEADER = "//label[text()='Quantity']";

    public void navigateToProductPage() {
        webDriver.get(Consts.PRODUCT_PAGE_URL);
    }
    public boolean isProductPageVisible() {
        return elementExists(PRODUCT_PAGE_HEADER);
    }
}