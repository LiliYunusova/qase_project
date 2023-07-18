package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@name = 'email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name = 'password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type= 'submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@href = '/signup']")
    private WebElement createAccountLink;

    @Step("Opening  https://app.qase.io")
    public LoginPage openLoginPage(String url) {
        driver.get(url);
        return this;
    }

    @Step("Entering the email {email}")
    public LoginPage fillInEmail(String email) {
        waitVisibilityOf(emailField).sendKeys(email);
        return this;
    }

    @Step("Entering the password {password}")
    public LoginPage fillInPassword(String password) {
        waitVisibilityOf(passwordField).sendKeys(password);
        return this;
    }

    @Step("Clicking the sign in button")
    public void clickSignInButton() {
        waitElementToBeClickable(signInButton).click();
    }

    @Step("Clicking the link to create New Account")
    public void clickCreateAccountLink() {
        waitElementToBeClickable(createAccountLink).click();
    }
}
