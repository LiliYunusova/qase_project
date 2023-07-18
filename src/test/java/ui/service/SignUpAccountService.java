package ui.service;

import ui.pages.SignUpAccountPage;

public class SignUpAccountService {

    SignUpAccountPage signUpAccountPage = new SignUpAccountPage();

    public String actualTextOfCreateNewAccount(){
        return signUpAccountPage.getTextCreateSuccessfulAccount();
    }
}
