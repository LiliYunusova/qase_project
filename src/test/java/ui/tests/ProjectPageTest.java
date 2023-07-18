package ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.model.User;
import ui.pages.OneSingleProjectPage;
import ui.service.LoginPageService;
import ui.service.OneSingleProjectPageService;
import ui.service.ProjectsPageService;
import ui.service.SettingsProjectService;
import ui.utils.Retry;
import ui.utils.TestDataGeneration;


public class ProjectPageTest {

    public String generateNewNameOfProject = TestDataGeneration.getName();
    public String nameProject = "AQA20";

    private ProjectsPageService projectsPageService;
    private LoginPageService loginPageService;
    private OneSingleProjectPageService oneSingleProjectPageService;
    User user = new User(System.getProperty("email"), System.getProperty("password"));



    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
        projectsPageService = new ProjectsPageService();
        oneSingleProjectPageService = new OneSingleProjectPageService();
    }

    @Test(retryAnalyzer = Retry.class)
    public void createNewProjectTest() {
        ProjectsPageService projectsPageService = loginPageService.loginQasePage(user);
        OneSingleProjectPage oneSingleProjectPage = projectsPageService.createNewProjectPage(generateNewNameOfProject);
        ProjectsPageService toProjectsPageService = oneSingleProjectPageService.goToProjectPage();
        boolean newProjectPageName = toProjectsPageService.existProjectOnMainPageOfProjects(generateNewNameOfProject);
        Assert.assertTrue( newProjectPageName,"Project does not create");
    }

    @Test(retryAnalyzer = Retry.class)
    public void searchProjectPageTest(){
        ProjectsPageService projectsPageService = loginPageService.loginQasePage(user);
        boolean projectPageService = projectsPageService.searchProjectPage(nameProject);
        Assert.assertTrue(projectPageService, "Project does not found");

    }

    @Test(dependsOnMethods = "createNewProjectTest", retryAnalyzer = Retry.class)
    public void deleteProjectPageTest() {
        ProjectsPageService projectsPageService = loginPageService.loginQasePage(user);
        OneSingleProjectPageService oneSingleProjectPage = projectsPageService.getNameAndGoToPage(generateNewNameOfProject);
        SettingsProjectService settingsProjectService = oneSingleProjectPageService.moveSettingsProjectPage();
        ProjectsPageService projectPageService = settingsProjectService.deleteProjectPage(generateNewNameOfProject);
        boolean existDeletePage = projectsPageService.searchProjectPage(generateNewNameOfProject);
        Assert.assertFalse(existDeletePage, "Project found");
    }

    @Test
    public void addFilterToSearchProjectPageTest(){
        ProjectsPageService projectsPageService = loginPageService.loginQasePage(user);
        String actualTextOfAddFilterProjectPage = projectsPageService.addFilterToProjectPage();
        Assert.assertEquals(actualTextOfAddFilterProjectPage, "Milestones");
    }

}
