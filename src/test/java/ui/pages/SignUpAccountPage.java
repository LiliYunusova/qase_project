package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpAccountPage extends BasePage{

    @FindBy(xpath = "//p[text() = 'We have successfully created your account and sent a confirmation email to:']")
    private WebElement createSuccessfulAccount;

    public String getTextCreateSuccessfulAccount(){
        return waitVisibilityOf(createSuccessfulAccount).getText();
    }
}
