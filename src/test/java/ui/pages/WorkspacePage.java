package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkspacePage extends BasePage{

    @FindBy(xpath = "//div[@class = 'dropdown']//a[@data-bs-toggle = 'dropdown']")
    private WebElement dropdownEditButton;

    @FindBy(xpath = "//div[@class = 'dropdown-item']//a[contains(text(), 'Edit profile')]")
    private WebElement editProfileButton;

    @FindBy(xpath = "//span[contains(@class, 'team-member-name')]")
    private WebElement FirstNameAndLastNameUser;

    public WorkspacePage clickDropdownEditButton(){
        waitVisibilityOf(dropdownEditButton).click();
        return this;
    }

    public void clickEditProfileButton(){
        waitVisibilityOf(editProfileButton).click();
    }

    public String getFirstNameAndLastNameUser(){
        return waitVisibilityOf(FirstNameAndLastNameUser).getText();
    }

}
