package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Log4j2
public class MilestonePage extends BasePage {

    @FindBy(xpath = "//a[@id='createButton']")
    private WebElement createMilestoneButton;

    @FindBy(xpath = "//table//tbody//tr//div//a[@class = 'defect-title']")
    private List<WebElement> listMilestoneName;

    @Step("Click Create Milestone Button")
    public MilestonePage clickCreateMilestoneButton() {
        log.info("Click Create Milestone Button");
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
