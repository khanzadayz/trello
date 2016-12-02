package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import util.BrowserCommon;

import java.util.HashMap;
import java.util.Map;

public class NewBoardPage extends BrowserCommon {

    //region Webelements
    private static final String CARD1COMMENT = "Without the perfect plan, calculating the strengths and weaknesses of the project, " +
            "development of software is meaningless. Planning kicks off a project flawlessly and affects its progress positively.";
    private static final String CARD2COMMENT = "This step is about analyzing the performance of the software at various stages and making " +
            "notes on additional requirements. Analysis is very important to proceed further to the next step.";
    private static final String CARD3COMMENT = "Once the analysis is complete, the step of designing takes over, which is basically building " +
            "the architecture of the project. This step helps remove possible flaws by setting a standard and attempting to stick to it.";
    private static final String CARD4COMMENT = "The actual task of developing the software starts here with data recording going on in the " +
            "background. Once the software is developed, the stage of implementation comes in where the product goes through a pilot study " +
            "to see if it’s functioning properly.";
    private static final String CARD5COMMENT = "The testing stage assesses the software for errors and documents bugs if there are any.";
    private static final String CARD6COMMENT = "Once the software passes through all the stages without any issues, it is " +
            "to undergo a maintenance process wherein it will be maintained and upgraded from time to time to adapt to " +
            "changes. Almost every software development Indian company follows all the six steps, leading to the reputation " +
            "that the country enjoys in the software market today.";
    @FindBy(name = "name")
    WebElement listName;
    @FindBy(xpath = "//input[@value='Save']")
    WebElement saveListBtn;
    @FindBy(linkText = "Add a card…")
    WebElement addCardLink;
    @FindBy(css = "textarea.list-card-composer-textarea.js-card-title")
    WebElement cardDescription;
    @FindBy(xpath = "//input[@value='Add']")
    WebElement addCardBtn;
    @FindBy(xpath = "//a[contains(@href, 'planning')]")
    WebElement card1;
    @FindBy(xpath = "//a[contains(@href, 'analysis')]")
    WebElement card2;
    @FindBy(xpath = "//a[contains(@href, 'design')]")
    WebElement card3;
    @FindBy(xpath = "//a[contains(@href, 'implementation')]")
    WebElement card4;
    @FindBy(xpath = "//a[contains(@href, 'testing')]")
    WebElement card5;
    @FindBy(xpath = "//a[@class='list-card-title js-card-name' and contains(@href,'maintenance')]")
    WebElement card6;
    @FindBy(xpath = "//a[@class='button-link js-move-card']")
    WebElement moveBtn;
    //@FindBy(xpath = "(//a[contains(@href, '#')])[53]")
    @FindBy(xpath = "//a[contains(@class, 'icon-lg icon-close dialog-close-button js-close-window')]")
    WebElement cardCloseBtn;
    @FindBy(xpath = "//input[@value='Move']")
    WebElement cardMoveBtn;
    @FindBy(css = "select.js-select-list")
    WebElement listSelect;
    @FindBy(css = "textarea.comment-box-input.js-new-comment-input")
    WebElement cardCommentTextarea;
    @FindBy(xpath = "//input[@value='Send']")
    WebElement btnCommentSave;
    //endregion

    public NewBoardPage() {
    }

    public void addNewList(int arg0) {
        fillInput(listName, "Priority " + arg0 + " tasks");
        saveListBtn.click();
        pause(400);
    }

    public void clickCardLink() {
        addCardLink.click();
        pause(200);
    }

    public void addCard(String desc) {
        fillInput(cardDescription, desc);
        addCardBtn.click();
        pause(100);
    }

    public void addCardComments() {
        Map<WebElement, String> elmap = new HashMap<WebElement, String>() {{
            put(card1, CARD1COMMENT);
            put(card2, CARD2COMMENT);
            put(card3, CARD3COMMENT);
            put(card4, CARD4COMMENT);
            put(card5, CARD5COMMENT);
            put(card6, CARD6COMMENT);
        }};
        for (Map.Entry<WebElement, String> entry : elmap.entrySet()) {
            pause(100);
            entry.getKey().click();
            pause(200);
            fillInput(cardCommentTextarea, entry.getValue());
            btnCommentSave.click();
            cardCloseBtn.click();
            pause(80);
        }
    }

    public void moveMaintenanceToTasks(String priority) {
        pause(200);
        card6.click();
        pause(100);
        moveCard(priority);
    }

    public void moveTestingToTasks(String priority) {
        pause(200);
        card5.click();
        pause(100);
        moveCard(priority);
    }

    private void moveCard(String priority) {
        moveBtn.click();
        pause(50);
        Select prioritySelectList = new Select(listSelect);
        prioritySelectList.selectByVisibleText(priority);
        cardMoveBtn.click();
        pause(100);
        cardCloseBtn.click();
        pause(200);
    }

    public void moveDesignToPriorityTasks(String priority) {
        pause(200);
        card3.click();
        pause(100);
        moveCard(priority);
    }

    public void moveDevelopmentAndImplementationToPriorityTasks(String priority) {
        pause(200);
        card4.click();
        pause(100);
        moveCard(priority);
    }
}
