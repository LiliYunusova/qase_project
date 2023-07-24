package ui.service;

import ui.model.NewAccount;
import ui.pages.SignUpPage;


public class SignUpPageService {

    public SignUpAccountService signUpAccount(NewAccount newAccount){
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.fillInEmailToSignUp(newAccount.getEmailToSignUp())
                .fillInPasswordToSignUp(newAccount.getPasswordToSignUp())
                .fillInPasswordToConfirmToSignUp(newAccount.getConfirmPasswordToSignUp())
                .clickSignUpButton();
        return new SignUpAccountService();
    }
}
