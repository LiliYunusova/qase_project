package org.tms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage extends BasePage {

    @FindBy(xpath = "//div/h1")
    private WebElement nameOfHeaderOfProjectPage;

    public String getTextOfNameOfHeaderOfProjectPage() {
        return waitVisibilityOf(nameOfHeaderOfProjectPage).getText();
    }
}
