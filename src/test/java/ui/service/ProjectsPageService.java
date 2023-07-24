package ui.service;

import ui.pages.OneSingleProjectPage;
import ui.pages.ProjectsPage;


public class ProjectsPageService {

    private final ProjectsPage projectsPage = new ProjectsPage();

    public String actualTextNameOfHeaderOfProjectPage() {
        return projectsPage.getTextOfNameOfHeaderOfProjectPage();
    }

    public OneSingleProjectPage createNewProjectPage(String generateNewNameOfProject){
        projectsPage.clickCreateNewProjectButton()
                .fillInNameOfNewProject(generateNewNameOfProject)
                .clickNamePublicCheckBoxButton()
                .clickCreateProjectInFormButton();
        return new OneSingleProjectPage();
    }

    public boolean existProjectOnMainPageOfProjects(String generateNewNameOfProject){
         return projectsPage.existNameOfProject(generateNewNameOfProject);
    }

    public OneSingleProjectPageService getNameAndGoToPage(String generateNewNameOfProject) {
        projectsPage
                .clickCleanSearchFieldButton()
                .getNameAndGoToProjectPage(generateNewNameOfProject);
        return new OneSingleProjectPageService();
    }

    public OneSingleProjectPageService getNameOfProjects(String generateNewNameOfProject) {
        projectsPage
                .getNameAndGoToProjectPage(generateNewNameOfProject);
        return new OneSingleProjectPageService();
    }

    public boolean searchProjectPage(String projectName){
        return  projectsPage.searchProjectPageField(projectName).existNameOfProject(projectName);
    }

    public String addFilterToProjectPage(){
        return projectsPage.clickAddFilterButton()
                .clickFilterMenu().clickFilterDropDownMilestone()
                .getTextOfFilterProjectPage();
    }

    public WorkspacePageService getWorkspacePage(){
        projectsPage.clickWorkspaceLink();
        return new WorkspacePageService();
    }
}
