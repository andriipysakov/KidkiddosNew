import Pages.BooksResultsPage;
import Pages.ProductPage;
import Utils.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BooksResultPageTest extends UseCaseBase {

    private static BooksResultsPage booksResultPage;
    public static final Logger logger = LogManager.getLogger(BooksResultPageTest.class);

    @BeforeAll
    public static void classSetup() {
        booksResultPage = new BooksResultsPage();
    }

    @BeforeEach
    public void beforeTest() {
        booksResultPage.navigateToBooksResultsEnglishPage();
    }

    @Test
    public void productPageLoadTest() {
        logger.info("Product Page load test");
        ProductPage productPageLoadTest = new ProductPage();
        productPageLoadTest.navigateToProductPage();
        Boolean success = productPageLoadTest.isProductPageVisible();
        productPageLoadTest.takeScreenshot("ProductPageTest");
        assertTrue(success);
    }

}