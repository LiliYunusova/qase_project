package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class UserProfilePage extends BasePage {

    @FindBy(xpath = "//input[@id = 'firstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id = 'lastName']")
    private WebElement lastnameField;

    @FindBy(xpath = "//input[@id = 'role']")
    private WebElement roleField;

    @FindBy(xpath = "//div[@id = 'application-content']//form//button/span[contains(text(), 'Update settings')]")
    private WebElement updateSettingsButton;

    @FindBy(xpath = "//div[@id = 'layout']//a[contains(@href, '/workspace') and contains(text(), 'Workspace')]")
    private WebElement workspaceLink;

    @Step("Send First Name in Field")
    public UserProfilePage sendFirstName(String firstName) {
        log.info("Send First Name");
        waitVisibilityOf(firstNameField).clear();
        waitVisibilityOf(firstNameField).sendKeys(firstName);
        return this;
    }

    @Step("Send Last Name in Field")
    public UserProfilePage sendLastName(String lastName) {
        log.info("Send Last Name");
        waitVisibilityOf(lastnameField).clear();
        waitVisibilityOf(lastnameField).sendKeys(lastName);
        return this;
    }

    @Step("send Role in Field")
    public UserProfilePage sendRole(String nameRole) {
        log.info("send Role");
        waitVisibilityOf(roleField).clear();
        waitVisibilityOf(roleField).sendKeys(nameRole);
        return this;
    }

    @Step("Click Update Settings")
    public UserProfilePage clickUpdateSettingsButton() {
        log.info("Click Update Settings");
        waitVisibilityOf(updateSettingsButton).click();
        return this;
    }

    @Step("Click Workspace Link")
    public void clickWorkspaceLink() {
        log.info("Click Workspace Link");
        waitVisibilityOf(workspaceLink).click();
    }
}

