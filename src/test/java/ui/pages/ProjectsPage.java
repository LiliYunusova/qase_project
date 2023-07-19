package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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
        return waitVisibilityOf(nameOfHeaderOfProjectPage).getText();
    }

    @Step("Click to Button Create new Project ")
    public ProjectsPage clickCreateNewProjectButton() {
        waitElementToBeClickable(createNewProjectButton).click();
        return this;
    }

    @Step("Filling name Project")
    public ProjectsPage fillInNameOfNewProject(String generateNewNameOfProject) {
        waitVisibilityOf(nameOfNewProject).sendKeys(generateNewNameOfProject);
        return this;
    }

    @Step("Click checkbox Public")
    public ProjectsPage clickNamePublicCheckBoxButton() {
        waitElementToBeClickable(namePublicCheckBoxButton).click();
        return this;
    }

    @Step("Click button In form Create Button")
    public void clickCreateProjectInFormButton() {
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

    public ProjectsPage searchProjectPageField(String projectName) {
        waitVisibilityOf(searchProjectPageField).clear();
        waitElementToBeClickable(searchProjectPageField).sendKeys(projectName);
        return this;
    }

    public ProjectsPage clickCleanSearchFieldButton() {
        waitElementToBeClickable(cleanSearchFieldButton).click();
        return this;
    }

    public ProjectsPage getNameAndGoToProjectPage(String name) {
        for (WebElement element : nameOfAllProjects) {
            if (element.getText().equals(name)) {
                element.click();
                return this;
            }
        }
        return this;
    }

    public ProjectsPage clickAddFilterButton() {
        waitVisibilityOf(addFilterButton).click();
        return this;
    }

    public ProjectsPage clickFilterMenu() {
        waitVisibilityOf(filterMenu).click();
        return this;
    }

    public ProjectsPage clickFilterDropDownMilestone() {
        waitVisibilityOf(filterDropDownMilestone).click();
        return this;
    }

    public String getTextOfFilterProjectPage() {
        return waitVisibilityOf(textOfAddFilterProjectPage).getText();
    }

    public void clickWorkspaceLink() {
        waitVisibilityOf(workspaceLink).click();
    }

}
