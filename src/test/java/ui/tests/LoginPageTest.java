package ui.tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.model.User;
import ui.service.LoginPageService;
import ui.service.ProjectsPageService;
import ui.utils.Retry;

public class LoginPageTest extends BaseTest {

    private LoginPageService loginPageService;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
    }

    @Test(retryAnalyzer = Retry.class, description = "Login to https://app.qase.io")
    @Description("Login to https://app.qase.io")
    public void loginTest() {
        User user = new User(System.getProperty("email"), System.getProperty("password"));
        ProjectsPageService projectsPageService = loginPageService.loginQasePage(user);
        String actualTextOfProjectPage = projectsPageService.actualTextNameOfHeaderOfProjectPage();
        String expectedTextOfProjectPage = "Projects";
        Assert.assertEquals(actualTextOfProjectPage, expectedTextOfProjectPage, "The actual text of the page " +
                "does not match expected!");
    }
}
