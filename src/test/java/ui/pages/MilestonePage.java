package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MilestonePage extends BasePage {

    @FindBy(xpath = "//a[@id='createButton']")
    private WebElement createMilestoneButton;

    @FindBy(xpath = "//table//tbody//tr//div//a[@class = 'defect-title']")
    private List<WebElement> listMilestoneName;


    public MilestonePage clickCreateMilestoneButton() {
        waitElementToBeClickable(createMilestoneButton).click();
        return this;
    }

    public boolean existNewMilestone(String milestoneName) {
        for (WebElement element : listMilestoneName) {
            if (element.getText().equals(milestoneName)) {
                return true;
            }
        }
        return false;
    }
}

