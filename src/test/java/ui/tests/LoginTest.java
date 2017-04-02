package ui.tests;

import org.junit.Test;

public class LoginTest extends BaseUITestCase {

  @Test
  public void loginSuccessfulyTest() {
    homeSteps
        .performSuccessfulLogin()
        .verifyCorrectUserIsLoggedIn();
  }

}
