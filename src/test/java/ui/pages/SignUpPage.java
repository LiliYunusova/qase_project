package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class SignUpPage extends BasePage {

    @FindBy(xpath = "//input[@name = 'email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name = 'password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name = 'passwordConfirmation']")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//button[@type= 'submit']")
    private WebElement signUpButton;

    @Step("Fill email to Sign Up Field")
    public SignUpPage fillInEmailToSignUp(String email) {
        log.info("Fill email to Sign Up");
        waitVisibilityOf(emailField).sendKeys(email);
        return this;
    }

    @Step("Fill password to Sign Up Field")
    public SignUpPage fillInPasswordToSignUp(String password) {
        log.info("Fill password to Sign Up");
        waitVisibilityOf(passwordField).sendKeys(password);
        return this;
    }

    @Step("Confirm Password to Sign Up")
    public SignUpPage fillInPasswordToConfirmToSignUp(String confirmPassword) {
        log.info("Confirm Password to Sign Up");
        waitVisibilityOf(confirmPasswordField).sendKeys(confirmPassword);
        return this;
    }

    @Step("Click Sign Up Button")
    public void clickSignUpButton() {
        log.info("Click Sign Up ");
        waitElementToBeClickable(signUpButton).click();
    }
}
