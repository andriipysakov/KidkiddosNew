import Pages.BooksResultsPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utils.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HomePageTest extends UseCaseBase {
    private static HomePage homePage;
    public static final Logger logger = LogManager.getLogger(HomePageTest.class);

    @BeforeAll
    public static void classSetup() {
        homePage = new HomePage();
    }

    @BeforeEach
    public void beforeTest() {
        homePage.navigateToHomePage();
    }

    @Test
    public void homePageLoadTest() {
        logger.info("Home Page load test");
        Boolean success = homePage.isLogoVisible();
        homePage.takeScreenshot("HomePageTest");
        assertTrue(success);
    }

    @Test
    public void openLoginPageTest() {
        LoginPage loginPage = homePage.openLoginPage();
        boolean isLoaded = loginPage.isLoginPageTitleVisible();
        assertTrue(isLoaded);
    }

    @Test
    public void booksResultPageLoadTest() {
        logger.info("Books Result Page load test");
        BooksResultsPage booksResultsPage = new BooksResultsPage();
        booksResultsPage.navigateToBooksResultsEnglishPage();
        Boolean success = booksResultsPage.isBooksResultsEnglishPageVisible();
        booksResultsPage.takeScreenshot("BooksResultPageTest");
        assertTrue(success);
    }

}
