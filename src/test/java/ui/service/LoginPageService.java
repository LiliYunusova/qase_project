package ui.service;

import ui.model.User;
import ui.pages.LoginPage;

import static ui.constants.PageUrl.LOGIN_PAGE;

public class LoginPageService {
    LoginPage loginPage = new LoginPage();

    public ProjectsPageService loginQasePage(User user) {
        loginPage.openLoginPage(LOGIN_PAGE)
                .fillInEmail(user.getEmail())
                .fillInPassword(user.getPassword())
                .clickSignInButton();
        return new ProjectsPageService();
    }

    public SignUpPageService pushLinkToCreateNewAccount(){
        loginPage.openLoginPage(LOGIN_PAGE)
                .clickCreateAccountLink();
        return new SignUpPageService();
    }
}
