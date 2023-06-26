package org.tms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@name = 'email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name = 'password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type= 'submit']")
    private WebElement signInButton;

    public LoginPage openLoginPage(String url) {
        driver.get(url);
        return this;
    }

    public LoginPage fillInEmail(String email) {
        waitVisibilityOf(emailField).sendKeys(email);
        return this;
    }

    public LoginPage fillInPassword(String password) {
        waitVisibilityOf(passwordField).sendKeys(password);
        return this;
    }

    public void clickSignInButton() {
        waitElementToBeClickable(signInButton).click();
    }

}
