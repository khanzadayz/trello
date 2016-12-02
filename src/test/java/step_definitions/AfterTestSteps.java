package step_definitions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import util.BrowserCommon;
import util.CucumberCommon;

public class AfterTestSteps extends BrowserCommon{

    CucumberCommon cucumberCommon = new CucumberCommon();

    public AfterTestSteps() {
    }

    @After
    public void logoutAfterTest(Scenario scenario) {
        getCurrentDriver().manage().deleteAllCookies();
        cucumberCommon.getScreenshotUponFailure(scenario);
    }
}
