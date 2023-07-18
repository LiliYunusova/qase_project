package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfilePage extends BasePage{

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

    public UserProfilePage sendFirstName(String firstName){
        waitVisibilityOf(firstNameField).clear();
        waitVisibilityOf(firstNameField).sendKeys(firstName);
        return this;
    }

    public UserProfilePage sendLastName(String lastName){
        waitVisibilityOf(lastnameField).clear();
        waitVisibilityOf(lastnameField).sendKeys(lastName);
        return this;
    }

    public UserProfilePage sendRole(String nameRole){
        waitVisibilityOf(roleField).clear();
        waitVisibilityOf(roleField).sendKeys(nameRole);
        return this;
    }

    public UserProfilePage clickUpdateSettingsButton(){
        waitVisibilityOf(updateSettingsButton).click();
        return this;
    }
    public void clickWorkspaceLink(){
        waitVisibilityOf(workspaceLink).click();
    }
}

