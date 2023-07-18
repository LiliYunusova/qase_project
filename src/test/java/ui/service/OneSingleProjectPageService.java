package ui.service;

import ui.pages.OneSingleProjectPage;
import ui.pages.ProjectsPage;

public class OneSingleProjectPageService {

    OneSingleProjectPage oneSingleProjectPage = new OneSingleProjectPage();

    public ProjectsPageService goToProjectPage(){
        oneSingleProjectPage.clickTitleProject();
        return new ProjectsPageService();
    }



    public SettingsProjectService moveSettingsProjectPage(){
        OneSingleProjectPage oneSingleProjectPage = new OneSingleProjectPage();
        oneSingleProjectPage.clickSettingProjectLink();
        return new SettingsProjectService();
    }

    public MilestonePageService moveNewMilestonePage(){
        OneSingleProjectPage oneSingleProjectPage = new OneSingleProjectPage();
        oneSingleProjectPage.clickMilestoneLink();
        return new MilestonePageService();
    }

    public boolean createNewSuite(String nameSuite) {
        OneSingleProjectPage oneSingleProjectPage = new OneSingleProjectPage();
        oneSingleProjectPage.clickCreateNewSuiteButton()
                .clickTitleSuiteNameField(nameSuite)
                .clickSubmitCreateSuiteButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return oneSingleProjectPage.existNewSuite(nameSuite);
    }

    public ProjectsPageService searchProject(String generateNewNameOfProject){
        ProjectsPage projectsPage = new ProjectsPage();
        projectsPage.getNameAndGoToProjectPage(generateNewNameOfProject);
        return new ProjectsPageService();
    }

    public TestCaseService moveToCreateTestCase(){
        OneSingleProjectPage oneSingleProjectPage = new OneSingleProjectPage();
        oneSingleProjectPage.clickCreateTestCase();
        return new TestCaseService();
    }

    public boolean createTestCase(String name){
        OneSingleProjectPage oneSingleProjectPage = new OneSingleProjectPage();
        return oneSingleProjectPage.existNewCase( name);
    }






}
