package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.BrowserCommon;
import util.ConfigParser;

public class MainPage extends BrowserCommon {

    //region Webelements
    WebElement user;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "login")
    WebElement loginBtn;
    @FindBy(linkText = "Log In")
    WebElement loginLnk;
    //endregion

    private String server = ConfigParser.getDomain();

    public MainPage() {
    }

    public void openTrello() {
        driver.get(server);
        waitForPageLoad();
        maximizeBrowser();
    }

    public BoardsPage login() {
        loginLnk.click();
        pause(200);
        fillInput(user, "khanzadayz@gmail.com");
        fillInput(password, "qazwsx123");
        loginBtn.click();
        waitForPageLoad();
        return new BoardsPage();
    }
}
