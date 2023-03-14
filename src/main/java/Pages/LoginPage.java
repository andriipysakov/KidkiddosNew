package Pages;

import Consts.Consts;

public class LoginPage extends BasePage {

    public static final String LOGIN_HEADER = "//h1[text()='Login']";
    public static final String LOGIN_ERROR = "//li[text()='Incorrect email or password.']";

    public void navigateToLoginPage() {
        webDriver.get(Consts.LOGIN_PAGE_URL);
    }

    public boolean isLoginPageTitleVisible() {
        return elementExists(LOGIN_HEADER);
    }

    public boolean isLoginPageErrorVisible() {
        return elementExists(LOGIN_ERROR);
    }
}
