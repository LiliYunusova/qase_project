package ui.service;

import ui.model.NewAccount;
import ui.pages.SignUpPage;


public class SignUpPageService {
    SignUpPage signUpPage = new SignUpPage();

    public SignUpAccountService signUpAccount(NewAccount newAccount){
        signUpPage.fillInEmailToSignUp(newAccount.getEmailToSignUp())
                .fillInPasswordToSignUp(newAccount.getPasswordToSignUp())
                .fillInPasswordToConfirmToSignUp(newAccount.getConfirmPasswordToSignUp())
                .clickSignUpButton();
        return new SignUpAccountService();
    }

}
