package Pages;

import Consts.Consts;

public class BooksResultsPage extends BasePage {

    public static final String BOOKS_RESULTS_PAGE_ENGLISH_HEADER = "//h1[text()='English Only']";

    public void navigateToBooksResultsEnglishPage() {
        webDriver.get(Consts.BOOKS_RESULTS_PAGE_ENGLISH_URL);
    }
    public boolean isBooksResultsEnglishPageVisible() {
        return elementExists(BOOKS_RESULTS_PAGE_ENGLISH_HEADER);
    }
}