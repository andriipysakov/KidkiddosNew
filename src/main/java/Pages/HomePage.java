package Pages;

import Consts.Consts;

public class HomePage extends BasePage {
    private static final String LOGO_IMG = "//img[@itemprop='logo']";
    private static final String LOGIN_PAGE = "//a[@href='/account/login']";
    private static final String BOOKS_BY_LANG_MENU = "//a[@href='/collections']";

    public void navigateToHomePage() {
        webDriver.get(Consts.HOME_PAGE_URL);
    }

    public boolean isLogoVisible() {
        Boolean isVisible = elementExists(LOGO_IMG);
        return isVisible;
    }

    public LoginPage openLoginPage() {
        clickElementByXpath(LOGIN_PAGE);
        return new LoginPage();
    }

}
