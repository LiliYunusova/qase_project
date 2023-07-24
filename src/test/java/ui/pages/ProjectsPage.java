package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Log4j2
public class ProjectsPage extends BasePage {

    @FindBy(xpath = "//div/h1")
    private WebElement nameOfHeaderOfProjectPage;

    @FindBy(xpath = "//*[@id = 'createButton']")
    private WebElement createNewProjectButton;

    @FindBy(xpath = "//input[@id = 'project-name']")
    private WebElement nameOfNewProject;

    @FindBy(xpath = "//div[@id = 'modals']//span[contains(text(), 'Public')]")
    private WebElement namePublicCheckBoxButton;

    @FindBy(xpath = "//div[@id = 'modals']//span[contains(text(), 'Create project')]")
    private WebElement createProjectInFormButton;

    @FindBy(xpath = "//table[@class = 'table projects-table mt-3']//tbody/tr//a[@class = 'defect-title']")
    private List<WebElement> nameOfAllProjects;

    @FindBy(xpath = "//input[@name = 'title']")
    private WebElement searchProjectPageField;

    @FindBy(xpath = "//button[contains(@class, 'input-clear-btn') and contains(@class, 'btn')]")
    private WebElement cleanSearchFieldButton;

    @FindBy(xpath = "//button[@class = 'add-filter-button']")
    private WebElement addFilterButton;

    @FindBy(xpath = "//button[contains(text(), 'Milestones')]")
    private WebElement filterMenu;

    @FindBy(xpath = "//input[@id= 'milestones-1']")
    private WebElement filterDropDownMilestone;

    @FindBy(xpath = "//div[@class = 'filter-item']//span[contains(text(), 'Milestones')]")
    private WebElement textOfAddFilterProjectPage;

    @FindBy(xpath = "//div[@id = 'layout']//a[contains(@href, '/workspace') and contains(text(), 'Workspace')]")
    private WebElement workspaceLink;

    @Step("Text of Header Project Page")
    public String getTextOfNameOfHeaderOfProjectPage() {
        log.info("Get 'Projects' name");
        return waitVisibilityOf(nameOfHeaderOfProjectPage).getText();
    }

    @Step("Click to Button Create new Project ")
    public ProjectsPage clickCreateNewProjectButton() {
        log.info("Click to Button Create new Project");
        waitElementToBeClickable(createNewProjectButton).click();
        return this;
    }

    @Step("Filling name Project")
    public ProjectsPage fillInNameOfNewProject(String generateNewNameOfProject) {
        log.info("Filling name Project");
        waitVisibilityOf(nameOfNewProject).sendKeys(generateNewNameOfProject);
        return this;
    }

    @Step("Click checkbox Public")
    public ProjectsPage clickNamePublicCheckBoxButton() {
        log.info("Click checkbox Public");
        waitElementToBeClickable(namePublicCheckBoxButton).click();
        return this;
    }

    @Step("Click button In form Create Button")
    public void clickCreateProjectInFormButton() {
        log.info("Click button In form Create Button");
        waitElementToBeClickable(createProjectInFormButton).click();
    }


    public boolean existNameOfProject(String name) {
        for (WebElement element : nameOfAllProjects) {
            if (element.getText().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Step("Search Project Page")
    public ProjectsPage searchProjectPageField(String projectName) {
        log.info("Search Project Page");
        waitVisibilityOf(searchProjectPageField).clear();
        waitElementToBeClickable(searchProjectPageField).sendKeys(projectName);
        return this;
    }

    @Step("Click Clean Search field Button")
    public ProjectsPage clickCleanSearchFieldButton() {
        log.info("Click Clean Search field Button");
        waitElementToBeClickable(cleanSearchFieldButton).click();
        return this;
    }

    @Step("Get project name and go to Project page")
    public ProjectsPage getNameAndGoToProjectPage(String name) {
        log.info("Get project name and go to Project page");
        for (WebElement element : nameOfAllProjects) {
            if (element.getText().equals(name)) {
                element.click();
                return this;
            }
        }
        return this;
    }

    @Step("Click Add Filter Button")
    public ProjectsPage clickAddFilterButton() {
        log.info("Click Add Filter Button");
        waitVisibilityOf(addFilterButton).click();
        return this;
    }

    @Step("Click FilterMenu Button")
    public ProjectsPage clickFilterMenu() {
        log.info("Click FilterMenu");
        waitVisibilityOf(filterMenu).click();
        return this;
    }

    @Step("Click Filter DropDown Milestone Button")
    public ProjectsPage clickFilterDropDownMilestone() {
        log.info("Click Filter DropDown Milestone");
        waitVisibilityOf(filterDropDownMilestone).click();
        return this;
    }

    @Step("Get text of filter")
    public String getTextOfFilterProjectPage() {
        log.info("Text of Filter");
        return waitVisibilityOf(textOfAddFilterProjectPage).getText();
    }

    @Step("Click Workspace Link")
    public void clickWorkspaceLink() {
        log.info("Click Workspace Link");
        waitVisibilityOf(workspaceLink).click();
    }
}
