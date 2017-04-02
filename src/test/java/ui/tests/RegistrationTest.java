package ui.tests;

import org.junit.Ignore;
import org.junit.Test;

public class RegistrationTest extends BaseUITestCase {

  @Ignore
  @Test
  public void successfulRegistrationTest(){
    homeSteps
        .registerNewUser()
        .verifyCorrectUserIsLoggedIn();
  }

}
