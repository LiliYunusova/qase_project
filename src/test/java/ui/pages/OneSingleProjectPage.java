package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

@Log4j2
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

    @Step("Click Title Project")
    public void clickTitleProject() {
        log.info("Click Title Project");
        waitVisibilityOf(titleProject).click();
    }

    @Step("Click Setting Project Link")
    public void clickSettingProjectLink() {
        log.info("Click Setting Project Link");
        waitVisibilityOf(settingProjectLink).click();
    }

    @Step("Click Milestone Link")
    public void clickMilestoneLink() {
        log.info("Click Milestone Link");
        waitElementToBeClickable(milestoneLink).click();
    }

    @Step("Click Create New Suite Button")
    public OneSingleProjectPage clickCreateNewSuiteButton() {
        log.info("Click Create New Suite Button");
        waitElementToBeClickable(createNewSuiteButton).click();
        return this;
    }

    @Step("Click Title Suite Name")
    public OneSingleProjectPage clickTitleSuiteNameField(String nameSuite) {
        log.info("Click Title Suite Name");
        waitVisibilityOf(titleSuiteNameField).sendKeys(nameSuite);
        return this;
    }

    @Step("Click Submit Create Suite Button")
    public OneSingleProjectPage clickSubmitCreateSuiteButton() {
        log.info("Click Submit Create Suite Button");
        waitVisibilityOf(submitCreateSuiteButton).click();
        return this;
    }

    @Step("New Suite displayed")
    public boolean existNewSuite(String nameSuite) {
        log.info("Search new suite");
        for (WebElement element : allOfSuiteOfOneProject) {
            if (element.getText().equals(nameSuite)) {
                return true;
            }
        }
        return false;
    }

    @Step("Click Create Test Case")
    public void clickCreateTestCase() {
        log.info("Click Create Test Case");
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
