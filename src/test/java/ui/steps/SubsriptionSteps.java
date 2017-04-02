package ui.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.pages.SubscriptionPage;

public class SubsriptionSteps {

  private SubscriptionPage page;
  private String purchasePrice;

  public SubsriptionSteps(WebDriver driver, WebDriverWait wait) {
    page = new SubscriptionPage(driver, wait);
  }

  public SubsriptionSteps navigateToRecipeBoxes() {
    page.clickOptionsMenu();
    page.clickRecipeBoxesOption();
    return this;
  }

  public SubsriptionSteps selectClassicPlan() {
    page.clickClassicMenuDetails();
    purchasePrice = page.getItemPrice();
    return this;
  }

  public SubsriptionSteps addPlanToCart() {
    page.clickContinueButton();
    return this;
  }

  public void verifySelectedPlanIsCorrect() {
    assertThat(page.getCartPlan(), containsString("Classic"));
    assertThat(page.getCartNumberOfMeals(), equalTo("3"));
    assertThat(page.getCartNumberOfPeople(), equalTo("2"));
    assertThat(page.getCartPrice(), equalTo(purchasePrice));

  }
}
