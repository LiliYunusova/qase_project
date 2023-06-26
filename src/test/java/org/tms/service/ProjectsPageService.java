package org.tms.service;

import org.tms.pages.ProjectsPage;

public class ProjectsPageService {

    ProjectsPage projectsPage = new ProjectsPage();

    public String actualTextNameOfHeaderOfProjectPage() {
        return projectsPage.getTextOfNameOfHeaderOfProjectPage();
    }
}
