package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestCasePage extends BasePage{
    @FindBy(xpath = "//input[@id='title']")
    private WebElement titleField;
    @FindBy(xpath = "//button/span[text() = 'Save']")
    private WebElement saveButton;


    public TestCasePage fillInTestCaseTitle(String nameTitleCase) {
        waitVisibilityOf(titleField).sendKeys(nameTitleCase);
        return this;
    }

    public void clickSaveButton() {
        waitElementToBeClickable(saveButton).click();
    }

}
