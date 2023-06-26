package org.tms.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.service.LoginPageService;
import org.tms.service.ProjectsPageService;

public class LoginPageTest extends BaseTest{

    private LoginPageService loginPageService;

    @BeforeClass
    public void setUp(){
        loginPageService = new LoginPageService();
    }

    @Test
    public void loginTest(){
        User user = new User(System.getProperty("email"),System.getProperty("password"));
        ProjectsPageService projectsPageService = loginPageService.loginQasePage(user);
        String actualTextOfProjectPage = projectsPageService.actualTextNameOfHeaderOfProjectPage();
        String expectedTextOfProjectPage = "Projects";
        Assert.assertEquals(actualTextOfProjectPage,expectedTextOfProjectPage, "The actual text of the page " +
                "does not match expected!");
    }


}
