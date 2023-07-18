package ui.service;

import ui.pages.UserProfilePage;

public class UserProfilePageService {

    public WorkspacePageService updateUserProfile(String firstName, String lastName, String role) {
        UserProfilePage userProfilePage = new UserProfilePage();
        userProfilePage.sendFirstName(firstName)
                .sendLastName(lastName)
                .sendRole(role)
                .clickUpdateSettingsButton()
                .clickWorkspaceLink();
        return new WorkspacePageService();
    }



}
