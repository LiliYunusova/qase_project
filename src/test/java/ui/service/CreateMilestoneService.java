package ui.service;

import ui.pages.CreateMilestonePage;
import ui.pages.ProjectsPage;

public class CreateMilestoneService {

    public MilestonePageService fillMilestonePage(String generateNewNameOfMilestone){
        CreateMilestonePage createMilestonePage = new CreateMilestonePage();
        createMilestonePage.sendNameMilestone(generateNewNameOfMilestone)
                .sendDescriptionMilestoneField(generateNewNameOfMilestone)
                .clickCreateMilestoneButton();
        return new MilestonePageService();
    }

    public OneSingleProjectPageService searchProject(String generateNewNameOfProject){
        ProjectsPage projectsPage = new ProjectsPage();
        projectsPage.getNameAndGoToProjectPage(generateNewNameOfProject);
        return new OneSingleProjectPageService();
    }



}
