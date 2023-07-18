package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingOneSingleProjectPage extends BasePage{

    @FindBy(xpath = "//div[@id = 'layout']//span[contains(text(),' Delete project')]")
    private WebElement deleteProjectButton;

    @FindBy(xpath = "//div[@id = 'modals']//span[contains(text(),'Delete project')]")
    private WebElement confirmDeleteProjectButton;

    public SettingOneSingleProjectPage clickDeleteProjectButton(){
        waitVisibilityOf(deleteProjectButton).click();
        return this;
    }

    public void clickConfirmDeleteButton(){
        waitVisibilityOf(confirmDeleteProjectButton).click();
    }
}
