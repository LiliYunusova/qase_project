package ui.tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.model.User;
import ui.service.LoginPageService;
import ui.service.OneSingleProjectPageService;
import ui.service.ProjectsPageService;
import ui.utils.TestDataGeneration;

public class CreateNewSuiteTest {

    public String generateNewNameOfSuite = TestDataGeneration.getName();
    public String nameProject = "AQA20";


    private LoginPageService loginPageService;
    private OneSingleProjectPageService oneSingleProjectPageService;

    private ProjectsPageService projectsPageService;


    User user = new User(System.getProperty("email"), System.getProperty("password"));

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
        projectsPageService = new ProjectsPageService();
        oneSingleProjectPageService = new OneSingleProjectPageService();
    }

    @Test
    @Description("Create new Suite")
    public void createNewSuite() {
        ProjectsPageService projectsPageService = loginPageService.loginQasePage(user);
        oneSingleProjectPageService.searchProject(nameProject);
        boolean projectPageService = oneSingleProjectPageService.createNewSuite(generateNewNameOfSuite);
        Assert.assertTrue(projectPageService, "Suite does not create");
    }


}
