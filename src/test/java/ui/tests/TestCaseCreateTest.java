package ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.model.User;
import ui.service.LoginPageService;
import ui.service.OneSingleProjectPageService;
import ui.service.ProjectsPageService;
import ui.service.TestCaseService;
import ui.utils.TestDataGeneration;

public class TestCaseCreateTest {

    public String generateNewNameOfProject = TestDataGeneration.getName();
    public String nameProject = "AQA20";

    private ProjectsPageService projectsPageService;
    private LoginPageService loginPageService;
    private OneSingleProjectPageService oneSingleProjectPageService;
    private TestCaseService testCaseService;
    User user = new User(System.getProperty("email"), System.getProperty("password"));

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
        projectsPageService = new ProjectsPageService();
        oneSingleProjectPageService = new OneSingleProjectPageService();
        testCaseService = new TestCaseService();
    }

    @Test
    public void createTestCase(){
        ProjectsPageService projectsPageService = loginPageService.loginQasePage(user);
        OneSingleProjectPageService oneSingleProjectPageService = projectsPageService.getNameOfProjects("WWW");
        TestCaseService testCaseService = oneSingleProjectPageService.moveToCreateTestCase();
        OneSingleProjectPageService oneSingleProjectPageService1 = testCaseService.fillTestCase(generateNewNameOfProject);
        boolean newTestCase = oneSingleProjectPageService.createTestCase(generateNewNameOfProject);
        Assert.assertTrue(newTestCase, "Test case does not create");
    }
}
