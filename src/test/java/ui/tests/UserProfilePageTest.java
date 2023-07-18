package ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.model.User;
import ui.service.LoginPageService;
import ui.service.ProjectsPageService;
import ui.service.UserProfilePageService;
import ui.service.WorkspacePageService;
import ui.utils.TestDataGeneration;

public class UserProfilePageTest {

    public String generateNewFirstName = TestDataGeneration.getName();
    public String generateNewLastName = TestDataGeneration.getName();
    public String generateRole = TestDataGeneration.getName();

    private ProjectsPageService projectsPageService;
    private LoginPageService loginPageService;
    private WorkspacePageService workspacePageService;
    private UserProfilePageService userProfilePageService;

    User user = new User(System.getProperty("email"), System.getProperty("password"));

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
        projectsPageService = new ProjectsPageService();
        workspacePageService = new WorkspacePageService();
        userProfilePageService = new UserProfilePageService();
    }

    @Test
    public void updateUserProfile() {
        ProjectsPageService projectsPageService = loginPageService.loginQasePage(user);
        WorkspacePageService workspacePageService = projectsPageService.getWorkspacePage();
        UserProfilePageService userProfilePageService = workspacePageService.editUserProfile();
        String actualProfileUser = userProfilePageService
                .updateUserProfile(generateNewFirstName,generateNewLastName,generateRole)
                .getTextUser();
        Assert.assertEquals(actualProfileUser,generateNewFirstName+" "+generateNewLastName);
    }
}
