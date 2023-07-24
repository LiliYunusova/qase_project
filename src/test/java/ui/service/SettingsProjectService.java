package ui.service;

import ui.pages.SettingOneSingleProjectPage;

public class SettingsProjectService {

    public ProjectsPageService deleteProjectPage(String name) {
        SettingOneSingleProjectPage settingOneSingleProjectPage = new SettingOneSingleProjectPage();
        settingOneSingleProjectPage.clickDeleteProjectButton()
                .clickConfirmDeleteButton();
        return new ProjectsPageService();
    }
}
