package ui.service;

import ui.pages.SignUpAccountPage;

public class SignUpAccountService {

    public String actualTextOfCreateNewAccount(){
        SignUpAccountPage signUpAccountPage = new SignUpAccountPage();
        return signUpAccountPage.getTextCreateSuccessfulAccount();
    }
}
