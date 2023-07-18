package ui.service;

import ui.pages.OneSingleProjectPage;
import ui.pages.ProjectsPage;


public class ProjectsPageService {

    ProjectsPage projectsPage = new ProjectsPage();

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
        ProjectsPage projectsPage = new ProjectsPage();
        projectsPage
                //clickCleanSearchFieldButton()
                .getNameAndGoToProjectPage(generateNewNameOfProject);
        return new OneSingleProjectPageService();
    }

    public OneSingleProjectPageService getNameOfProjects(String generateNewNameOfProject) {
        ProjectsPage projectsPage = new ProjectsPage();
        projectsPage
                .getNameAndGoToProjectPage(generateNewNameOfProject);
        return new OneSingleProjectPageService();
    }

    public boolean searchProjectPage(String projectName){
        ProjectsPage projectsPage = new ProjectsPage();
        return  projectsPage.searchProjectPageField(projectName).existNameOfProject(projectName);
    }

    public String addFilterToProjectPage(){
        ProjectsPage projectsPage = new ProjectsPage();
        return projectsPage.clickAddFilterButton()
                .clickFilterMenu().clickFilterDropDownMilestone()
                .getTextOfFilterProjectPage();
    }

    public WorkspacePageService getWorkspacePage(){
        ProjectsPage projectsPage = new ProjectsPage();
        projectsPage.clickWorkspaceLink();
        return new WorkspacePageService();
    }

}
