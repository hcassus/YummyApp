package ui.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggedAreaPage extends BasePage {

  public static final String USER_NAME_CSS_SELECTOR = ".ellipsify.account-customer-name";
  @FindBy(css = USER_NAME_CSS_SELECTOR)
  private WebElement loggedUserName;

  public LoggedAreaPage(WebDriver driver,
      WebDriverWait wait) {
    super(driver, wait);
  }

  public String getLoggedUserName() {
    wait.until(visibilityOf(loggedUserName));
    return loggedUserName.getText();
  }
}
