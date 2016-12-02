package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.BrowserCommon;

public class BoardsPage extends BrowserCommon {

    //region Webelements
    @FindBy(css = "a.js-new-board")
    WebElement addNewBoard;
    @FindBy(id = "boardNewTitle")
    WebElement newBoardTitle;
    @FindBy(xpath = "//input[@value='Create']")
    WebElement createNewBoardBtn;
    @FindBy(xpath = "//div[@id='header']/div[4]/a/span")
    WebElement plus;
    //endregion

    public BoardsPage() {
    }

    public NewBoardPage createNewBoard() {
        plus.click();
        addNewBoard.click();
        fillInput(newBoardTitle, "testBoard "+ getCurrentDate());
        createNewBoardBtn.click();
        waitForPageLoad();
        return new NewBoardPage();
    }
}
