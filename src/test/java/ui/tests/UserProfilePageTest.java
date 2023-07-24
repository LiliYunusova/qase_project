package ui.tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.model.User;
import ui.service.LoginPageService;
import ui.service.ProjectsPageService;
import ui.service.UserProfilePageService;
import ui.service.WorkspacePageService;
import ui.utils.Retry;
import ui.utils.TestDataGeneration;

public class UserProfilePageTest {
    private ProjectsPageService projectsPageService;
    private LoginPageService loginPageService;
    private WorkspacePageService workspacePageService;
    private UserProfilePageService userProfilePageService;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
        projectsPageService = new ProjectsPageService();
        workspacePageService = new WorkspacePageService();
        userProfilePageService = new UserProfilePageService();
    }

    @Test(retryAnalyzer = Retry.class)
    @Description("Update user Profile")
    public void verifyUpdateUserProfileTest() {
        String generateNewFirstName = TestDataGeneration.getName();
        String generateNewLastName = TestDataGeneration.getName();
        String generateRole = TestDataGeneration.getName();
        User user = new User(System.getProperty("email"), System.getProperty("password"));
        ProjectsPageService projectsPageService = loginPageService.loginQasePage(user);
        WorkspacePageService workspacePageService = projectsPageService.getWorkspacePage();
        UserProfilePageService userProfilePageService = workspacePageService.editUserProfile();
        String actualProfileUser = userProfilePageService
                .updateUserProfile(generateNewFirstName,generateNewLastName,generateRole)
                .getTextUser();
        Assert.assertEquals(actualProfileUser,generateNewFirstName+" "+generateNewLastName);
    }
}
