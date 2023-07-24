package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class CreateMilestonePage extends BasePage {

    @FindBy(xpath = "//input[@id='title']")
    private WebElement nameMilestone;
    @FindBy(xpath = "//div[@class = 'toastui-editor-defaultUI']//p")
    private WebElement descriptionMilestoneField;
    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement createMilestoneButton;

    @Step("Fill Name Milestone")
    public CreateMilestonePage sendNameMilestone(String nameOfMilestone) {
        log.info("Send Name Milestone");
        waitVisibilityOf(nameMilestone).sendKeys(nameOfMilestone);
        return this;
    }

    @Step("Fill Description Field")
    public CreateMilestonePage sendDescriptionMilestoneField(String descriptionMilestone) {
        log.info("Send Description Milestone");
        waitVisibilityOf(descriptionMilestoneField).sendKeys(descriptionMilestone);
        return this;
    }
    @Step("Click to button Create Milestone")
    public void clickCreateMilestoneButton() {
        log.info("Click to Button Create Milestone");
        waitElementToBeClickable(createMilestoneButton).click();
    }
}
