package ui.service;

import ui.pages.WorkspacePage;

public class WorkspacePageService {
    private final WorkspacePage workspacePage = new WorkspacePage();

    public UserProfilePageService editUserProfile(){
        workspacePage.clickDropdownEditButton().clickEditProfileButton();
        return new UserProfilePageService();
    }

    public String  getTextUser(){
       return workspacePage.getFirstNameAndLastNameUser();
    }
}
