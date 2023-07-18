package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateMilestonePage extends BasePage{

    @FindBy(xpath = "//input[@id='title']")
    private WebElement nameMilestone;
    @FindBy(xpath = "//div[@class = 'toastui-editor-defaultUI']//p")
    private WebElement descriptionMilestoneField;
    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement createMilestoneButton;

    public CreateMilestonePage sendNameMilestone(String nameOfMilestone){
        waitVisibilityOf(nameMilestone).sendKeys(nameOfMilestone);
        return this;
    }

    public CreateMilestonePage sendDescriptionMilestoneField(String descriptionMilestone){
        waitVisibilityOf(descriptionMilestoneField).sendKeys(descriptionMilestone);
        return this;
    }

    public void clickCreateMilestoneButton(){
        waitElementToBeClickable(createMilestoneButton).click();
    }
}
