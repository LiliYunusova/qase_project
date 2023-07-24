package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class WorkspacePage extends BasePage {

    @FindBy(xpath = "//div[@class = 'dropdown']//a[@data-bs-toggle = 'dropdown']")
    private WebElement dropdownEditButton;

    @FindBy(xpath = "//div[@class = 'dropdown-item']//a[contains(text(), 'Edit profile')]")
    private WebElement editProfileButton;

    @FindBy(xpath = "//span[contains(@class, 'team-member-name')]")
    private WebElement FirstNameAndLastNameUser;

    @Step("Click Edit DropDown Button")
    public WorkspacePage clickDropdownEditButton() {
        log.info("Click Edit DropDown");
        waitVisibilityOf(dropdownEditButton).click();
        return this;
    }

    @Step("Click Edit Profile Button")
    public void clickEditProfileButton() {
        log.info("Click Edit Profile");
        waitVisibilityOf(editProfileButton).click();
    }
    @Step("Get First name and Last Name")
    public String getFirstNameAndLastNameUser() {
        log.info("First Name and Last name");
        return waitVisibilityOf(FirstNameAndLastNameUser).getText();
    }
}
