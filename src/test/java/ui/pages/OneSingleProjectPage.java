package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class OneSingleProjectPage extends BasePage {

    @FindBy(xpath = "//div[@id = 'layout']//div//a[contains(text(), 'Projects')]")
    private WebElement titleProject;

    @FindBy(xpath = "//div[@id = 'layout']//span[contains(text(), 'Settings')]")
    private WebElement settingProjectLink;

    @FindBy(xpath = "//div[@id = 'layout']//span[contains(text(), 'Milestones')]")
    private WebElement milestoneLink;

    @FindBy(xpath = "//a[@id = 'create-suite-button']")
    private WebElement createNewSuiteButton;

    @FindBy(xpath = "//input[@id = 'title']")
    private WebElement titleSuiteNameField;

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement submitCreateSuiteButton;

    @FindBy(xpath = "//div[@class = 'Pane vertical Pane1  ']//div[@draggable = 'true']//a[@title]")
    private List<WebElement> allOfSuiteOfOneProject;

    @FindBy(xpath = "//a[@id = 'create-case-button']")
    private WebElement createTestCase;

    @FindBy(xpath = "//div[contains(@data-suite-body-id, '0') and contains(@draggable, 'true')]//div[5]")
    private List<WebElement> listAllCases;


    public void clickTitleProject() {
        waitVisibilityOf(titleProject).click();
    }

    public void clickSettingProjectLink() {
        waitVisibilityOf(settingProjectLink).click();
    }

    public void clickMilestoneLink() {
        waitElementToBeClickable(milestoneLink).click();
    }

    public OneSingleProjectPage clickCreateNewSuiteButton() {
        waitElementToBeClickable(createNewSuiteButton).click();
        return this;
    }

    public OneSingleProjectPage clickTitleSuiteNameField(String nameSuite) {
        waitVisibilityOf(titleSuiteNameField).sendKeys(nameSuite);
        return this;
    }

    public OneSingleProjectPage clickSubmitCreateSuiteButton() {
        waitVisibilityOf(submitCreateSuiteButton).click();
        return this;
    }

    public boolean existNewSuite(String nameSuite) {
        for (WebElement element : allOfSuiteOfOneProject) {
            if (element.getText().equals(nameSuite)) {
                return true;
            }
        }
        return false;
    }

    public void clickCreateTestCase() {
        waitElementToBeClickable(createTestCase).click();
    }


    public boolean existNewCase(String nameCase) {
        for (WebElement element : listAllCases) {
            if (element.getText().equals(nameCase)) {
                return true;
            }
        }
        return false;
    }


}
