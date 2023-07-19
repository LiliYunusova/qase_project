package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateMilestonePage extends BasePage {

    @FindBy(xpath = "//input[@id='title']")
    private WebElement nameMilestone;
    @FindBy(xpath = "//div[@class = 'toastui-editor-defaultUI']//p")
    private WebElement descriptionMilestoneField;
    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement createMilestoneButton;

    @Step("Fill Name Milestone")
    public CreateMilestonePage sendNameMilestone(String nameOfMilestone) {
        waitVisibilityOf(nameMilestone).sendKeys(nameOfMilestone);
        return this;
    }

    @Step("Fill Description Field")
    public CreateMilestonePage sendDescriptionMilestoneField(String descriptionMilestone) {
        waitVisibilityOf(descriptionMilestoneField).sendKeys(descriptionMilestone);
        return this;
    }
    @Step("Click to button Create Milestone")
    public void clickCreateMilestoneButton() {
        waitElementToBeClickable(createMilestoneButton).click();
    }
}
