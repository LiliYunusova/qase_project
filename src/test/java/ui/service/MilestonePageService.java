package ui.service;

import ui.pages.BasePage;
import ui.pages.MilestonePage;

public class MilestonePageService extends BasePage {

    private final MilestonePage milestonePage = new MilestonePage();

    public CreateMilestoneService createMilestone(){
        milestonePage.clickCreateMilestoneButton();
        return new CreateMilestoneService();
    }

    public boolean existNewMilestone(String name){
        return milestonePage.existNewMilestone(name);
    }
}
