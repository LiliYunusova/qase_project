package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class SignUpAccountPage extends BasePage {

    @FindBy(xpath = "//p[text() = 'We have successfully created your account and sent a confirmation email to:']")
    private WebElement createSuccessfulAccount;

    @Step("Get Text Create Account")
    public String getTextCreateSuccessfulAccount() {
        log.info("Text Account is Created is Displayed");
        return waitVisibilityOf(createSuccessfulAccount).getText();
    }
}
