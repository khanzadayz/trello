package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.support.PageFactory;
import pagefactory.*;
import util.BrowserCommon;

public class MainPageSteps {
    private static MainPage mainPage = null;
    private static BoardsPage boardsPage = null;
    private static NewBoardPage newBoardPage = null;

    private static MainPage getMainPage() {
        if (mainPage == null)
            mainPage = PageFactory.initElements(BrowserCommon.getCurrentDriver(), MainPage.class);
        return mainPage;
    }

    private static BoardsPage getBoardsPage() {
        if (boardsPage == null)
            boardsPage = PageFactory.initElements(BrowserCommon.getCurrentDriver(), BoardsPage.class);
        return boardsPage;
    }

    private static NewBoardPage getNewBoardPage() {
        if (newBoardPage == null)
            newBoardPage = PageFactory.initElements(BrowserCommon.getCurrentDriver(), NewBoardPage.class);
        return newBoardPage;
    }

    @Given("^Trello is opened$")
    public void Trello_is_opened() {
        getMainPage().openTrello();
    }

    @And("^User is logged in$")
    public void userIsLoggedIn() throws Throwable {
        getMainPage().login();
    }

    @Given("^create a new Board$")
    public void createANewBoard() throws Throwable {
        getBoardsPage().createNewBoard();
    }

    @And("^add Priority (\\d+) tasks to the board$")
    public void addPriorityTasksToTheBoard(int arg0) throws Throwable {
        getNewBoardPage().addNewList(arg0);
    }

    @And("^card (.*) is added$")
    public void addCard(String desc) throws Throwable {
        getNewBoardPage().addCard(desc);
    }

    @And("^card link is clicked$")
    public void cardLinkIsClicked() throws Throwable {
        getNewBoardPage().clickCardLink();
    }

    @And("^move Maintenance to (.*)$")
    public void moveMaintenanceToPriorityTasks(String priority) throws Throwable {
        getNewBoardPage().moveMaintenanceToTasks(priority);
    }

    @And("^Comments are added to the cards")
    public void commentsAreAddedToTheCards() throws Throwable {
        getNewBoardPage().addCardComments();
    }

    @And("^move Testing to (.*)$")
    public void moveTestingToPriorityTasks(String priority) throws Throwable {
        getNewBoardPage().moveTestingToTasks(priority);
    }

    @And("^move Design to (.*)$")
    public void moveDesignToPriorityTasks(String priority) throws Throwable {
        getNewBoardPage().moveDesignToPriorityTasks(priority);
    }

    @And("^move Development and Implementation to (.*)$")
    public void moveDevelopmentAndImplementationToPriorityTasks(String priority) throws Throwable {
        getNewBoardPage().moveDevelopmentAndImplementationToPriorityTasks(priority);
    }
}