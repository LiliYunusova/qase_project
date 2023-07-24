package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class TestCasePage extends BasePage {
    @FindBy(xpath = "//input[@id='title']")
    private WebElement titleField;
    @FindBy(xpath = "//button/span[text() = 'Save']")
    private WebElement saveButton;

    @Step("Fill test case title")
    public TestCasePage fillInTestCaseTitle(String nameTitleCase) {
        log.info("Fill test case title");
        waitVisibilityOf(titleField).sendKeys(nameTitleCase);
        return this;
    }
    @Step("Click Save Case Button")
    public void clickSaveButton() {
        log.info("Click Save Case Button");
        waitElementToBeClickable(saveButton).click();
    }
}
