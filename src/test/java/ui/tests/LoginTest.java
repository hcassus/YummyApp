package ui.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.steps.HomeSteps;

public class LoginTest extends BaseUITestCase{

  @Test
  public void loginSuccessfulyTest(){
    homeSteps
        .performSuccessfulLogin()
        .verifyCorrectUserIsLoggedIn();
  }

}
