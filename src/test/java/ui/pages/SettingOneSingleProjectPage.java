package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class SettingOneSingleProjectPage extends BasePage {

    @FindBy(xpath = "//div[@id = 'layout']//span[contains(text(),' Delete project')]")
    private WebElement deleteProjectButton;

    @FindBy(xpath = "//div[@id = 'modals']//span[contains(text(),'Delete project')]")
    private WebElement confirmDeleteProjectButton;

    @Step("Click Delete Project Button")
    public SettingOneSingleProjectPage clickDeleteProjectButton() {
        log.info("Click Delete Project Button");
        waitVisibilityOf(deleteProjectButton).click();
        return this;
    }

    @Step("Click Confirm Delete Button")
    public void clickConfirmDeleteButton() {
        log.info("Click Confirm Delete Button");
        waitVisibilityOf(confirmDeleteProjectButton).click();
    }
}
