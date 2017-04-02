package ui.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubscriptionPage extends BasePage {

  @FindBy(xpath = "//a[img[contains(@src, 'three-dot-icon')]]")
  private WebElement optionMenu;

  @FindBy(linkText = "Our Recipe Boxes")
  private WebElement recipeBoxesOption;

  @FindBy(xpath = "//a[contains(@id,'classic') and contains(@id, 'product-detail-button')]")
  private WebElement classicMenuDetails;

  @FindBy(id = "add-to-cart-button")
  private WebElement continueButton;

  @FindBy(css = ".mls.summary-item-name")
  private WebElement itemDescription;

  @FindBy(xpath = "//span[@ng-bind='product.specsLabel']")
  private WebElement quantityInfo;

  @FindBy(xpath = "//*[@class = 'sushi-detail-price']")
  private WebElement cartProductPrice;

  @FindBy(xpath = "//span[@ng-bind='grandTotal']")
  private WebElement purchasePrice;

  public SubscriptionPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public void clickOptionsMenu() {
    wait.until(visibilityOf(optionMenu));
    optionMenu.click();
  }

  public void clickRecipeBoxesOption() {
    recipeBoxesOption.click();
  }

  public void clickClassicMenuDetails() {
    wait.until(elementToBeClickable(classicMenuDetails));
    scrollIntoView(classicMenuDetails);
    classicMenuDetails.click();
  }

  public void clickContinueButton() {
    wait.until(elementToBeClickable(continueButton));
    scrollIntoView(continueButton);
    continueButton.click();
  }

  public String getCartPlan() {
    wait.until(visibilityOf(itemDescription));
    return itemDescription.getText();
  }

  public String getCartNumberOfMeals() {
    return extractNumberOfMeals(quantityInfo.getText());
  }

  public String getCartNumberOfPeople() {
    return extractNumberOfPeople(quantityInfo.getText());
  }

  public String getCartPrice() {
    return cartProductPrice.getText();
  }

  private String extractNumberOfPeople(String quantityInfo) {
    return quantityInfo.split(" ")[3];
  }

  private String extractNumberOfMeals(String quantityInfo) {
    return quantityInfo.split(" ")[0];
  }

  public String getItemPrice() {
    wait.until(visibilityOf(purchasePrice));
    return purchasePrice.getText();
  }
}
