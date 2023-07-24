package ui.tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.model.User;
import ui.service.*;
import ui.utils.Retry;
import ui.utils.TestDataGeneration;

public class CreateNewMilestoneTest {

    private ProjectsPageService projectsPageService;
    private LoginPageService loginPageService;
    private OneSingleProjectPageService oneSingleProjectPageService;
    private CreateMilestoneService newCreateMilestoneService;
    private MilestonePageService newMilestonePageService;


    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
        projectsPageService = new ProjectsPageService();
        oneSingleProjectPageService = new OneSingleProjectPageService();
        newCreateMilestoneService = new CreateMilestoneService();
        newMilestonePageService = new MilestonePageService();
    }

    @Test(retryAnalyzer = Retry.class)
    @Description("Create new Milestone")
    public void verifyCreateNewMilestoneTest(){
        String generateNewName = TestDataGeneration.getName();
        String nameProject = "AQA20";
        User user = new User(System.getProperty("email"), System.getProperty("password"));
        ProjectsPageService projectsPageService = loginPageService.loginQasePage(user);
        OneSingleProjectPageService oneSingleProjectPageService = projectsPageService.getNameOfProjects(nameProject);
        MilestonePageService milestonePageService = oneSingleProjectPageService.moveNewMilestonePage();
        CreateMilestoneService createMilestoneService = milestonePageService.createMilestone();
        MilestonePageService milestonePageService1 = createMilestoneService.fillMilestonePage(generateNewName);
        boolean newMilestoneName = milestonePageService.existNewMilestone(generateNewName);
        Assert.assertTrue(newMilestoneName, "New Milestone does not create");

    }
}
