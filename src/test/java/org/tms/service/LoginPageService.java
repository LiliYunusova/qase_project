package org.tms.service;

import org.tms.model.User;
import org.tms.pages.LoginPage;

import static org.tms.constants.PageUrl.LOGIN_PAGE;

public class LoginPageService {

    public ProjectsPageService loginQasePage(User user) {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage(LOGIN_PAGE)
                .fillInEmail(user.getEmail())
                .fillInPassword(user.getPassword())
                .clickSignInButton();
        return new ProjectsPageService();
    }
}
