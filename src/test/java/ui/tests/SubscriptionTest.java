package ui.tests;

import org.junit.Before;
import org.junit.Test;
import ui.steps.SubsriptionSteps;

public class SubscriptionTest extends BaseUITestCase{

  private SubsriptionSteps subscriptionSteps;

  @Before
  public void setUp(){
    super.setUp();
    subscriptionSteps = new SubsriptionSteps(driver, wait);
    homeSteps.performSuccessfulLogin();
  }

  @Test
  public void subscribeToPlanTest(){
    subscriptionSteps
        .navigateToRecipeBoxes()
        .selectClassicPlan()
        .addPlanToCart()
        .verifySelectedPlanIsCorrect();
  }
}
