package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
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

    @Step("Entering the email")
    public LoginPage fillInEmail(String email) {
        log.info("Enter email");
        waitVisibilityOf(emailField).sendKeys(email);
        return this;
    }

    @Step("Entering the password")
    public LoginPage fillInPassword(String password) {
        log.info("Enter password");
        waitVisibilityOf(passwordField).sendKeys(password);
        return this;
    }

    @Step("Clicking the sign in button")
    public void clickSignInButton() {
        log.info("Click Sign In button");
        waitElementToBeClickable(signInButton).click();
    }

    @Step("Clicking the link to create New Account")
    public void clickCreateAccountLink() {
        log.info("Click create Account Link");
        waitElementToBeClickable(createAccountLink).click();
    }
}
