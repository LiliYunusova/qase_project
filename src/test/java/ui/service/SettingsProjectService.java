package ui.service;

import ui.pages.SettingOneSingleProjectPage;

public class SettingsProjectService {

    SettingOneSingleProjectPage settingOneSingleProjectPage = new SettingOneSingleProjectPage();
    private String name;

    public ProjectsPageService deleteProjectPage(String name) {
        settingOneSingleProjectPage.clickDeleteProjectButton()
                .clickConfirmDeleteButton();
        return new ProjectsPageService();
    }


}
