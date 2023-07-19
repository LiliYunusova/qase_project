package ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.model.User;
import ui.service.*;
import ui.utils.TestDataGeneration;

public class CreateNewMilestoneTest {

    public String generateNewName = TestDataGeneration.getName();

    public String nameProject = "AQA20";
    private ProjectsPageService projectsPageService;
    private LoginPageService loginPageService;
    private OneSingleProjectPageService oneSingleProjectPageService;
    private CreateMilestoneService newCreateMilestoneService;
    private MilestonePageService newMilestonePageService;
    User user = new User(System.getProperty("email"), System.getProperty("password"));

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
        projectsPageService = new ProjectsPageService();
        oneSingleProjectPageService = new OneSingleProjectPageService();
        newCreateMilestoneService = new CreateMilestoneService();
        newMilestonePageService = new MilestonePageService();
    }

    @Test
    public void createNewMilestone(){
        ProjectsPageService projectsPageService = loginPageService.loginQasePage(user);
        OneSingleProjectPageService oneSingleProjectPageService = projectsPageService.getNameOfProjects(nameProject);
        MilestonePageService milestonePageService = oneSingleProjectPageService.moveNewMilestonePage();
        CreateMilestoneService createMilestoneService = milestonePageService.createMilestone();
        MilestonePageService milestonePageService1 = createMilestoneService.fillMilestonePage(generateNewName);
        boolean newMilestoneName = milestonePageService.existNewMilestone(generateNewName);
        Assert.assertTrue(newMilestoneName, "New Milestone does not create");

    }
}
