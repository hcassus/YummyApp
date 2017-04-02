package ui.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.UUID;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.pages.HomePage;
import ui.pages.LoggedAreaPage;

public class HomeSteps {

  private static final String VALID_USER = "hf_testuser@trash-mail.com";
  private static final String VALID_PASSWORD = "123123123";
  private static final String VALID_USER_NAME = "Test U.";
  private HomePage homePage;
  private LoggedAreaPage loggedAreaPage;

  public HomeSteps(WebDriver driver, WebDriverWait wait) {
    homePage = new HomePage(driver, wait);
    loggedAreaPage = new LoggedAreaPage(driver, wait);
  }

  public HomeSteps performSuccessfulLogin() {
    homePage.clickLoginButton();
    homePage.fillEmailField(VALID_USER);
    homePage.fillPasswordField(VALID_PASSWORD);
    homePage.clickLoginButtonOnModal();
    return this;
  }

  public void verifyCorrectUserIsLoggedIn() {
    assertThat(loggedAreaPage.getLoggedUserName(), equalTo(VALID_USER_NAME));
  }


  public HomeSteps registerNewUser() {
    homePage.clickLoginButton();
    homePage.clickRegistrationLink();
    fillUserData();
    homePage.clickRegisterButton();
    return this;
  }

  private void fillUserData() {
    homePage.fillSalutation("Mr.");
    homePage.fillFirstName("Test");
    homePage.fillLastName("User");
    homePage.fillEmailField(generateRandomEmail());
    homePage.fillPasswordField("123123123");
    fillBirthDate();
    homePage.checkNewsletterCheckbox();
  }

  private String generateRandomEmail() {
    return String.format("hf_%s@trash-mail.com", UUID.randomUUID().toString());
  }

  private void fillBirthDate() {
    homePage.fillBirthMonth("04");
    homePage.fillBirthDay("23");
    homePage.fillBirthYear("1988");
  }
}
