package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    @FindBy(xpath = "//input[@name = 'email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name = 'password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name = 'passwordConfirmation']")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//button[@type= 'submit']")
    private WebElement signUpButton;


    public SignUpPage fillInEmailToSignUp(String email) {
        waitVisibilityOf(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage fillInPasswordToSignUp(String password) {
        waitVisibilityOf(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage fillInPasswordToConfirmToSignUp(String confirmPassword) {
        waitVisibilityOf(confirmPasswordField).sendKeys(confirmPassword);
        return this;
    }

    public void clickSignUpButton() {
        waitElementToBeClickable(signUpButton).click();
    }
}
