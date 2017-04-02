package ui.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

  private static final String LOGIN_BUTTON_ID = "login-button";

  @FindBy(id = LOGIN_BUTTON_ID)
  private WebElement loginButton;

  @FindBy(id = "email-input")
  private WebElement emailField;

  @FindBy(id = "password-input")
  private WebElement passwordField;

  @FindBy(id = "submit-login-button")
  private WebElement modalLoginButton;

  @FindBy(id = "register-user-link")
  private WebElement registrationLink;

  @FindBy(id = "register-button")
  private WebElement registerButton;

  @FindBy(id = "gender-input")
  private WebElement salutationElement;

  @FindBy(id = "first-name-input")
  private WebElement firstNameField;

  @FindBy(id = "last-name-input")
  private WebElement lastNameField;

  @FindBy(id = "email-input")
  private WebElement newsletterCheckbox;

  @FindBy(id = "month-input")
  private WebElement birthMonthField;

  @FindBy(id = "day-input")
  private WebElement birthDayField;

  @FindBy(id = "year-input")
  private WebElement birthYearField;

  public HomePage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public void clickLoginButton() {
    wait.until(presenceOfElementLocated(By.id(LOGIN_BUTTON_ID)));
    loginButton.click();
  }

  public void fillEmailField(String user) {
    wait.until(visibilityOf(emailField));
    emailField.sendKeys(user);
  }

  public void fillPasswordField(String password) {
    passwordField.sendKeys(password);
  }

  public void clickLoginButtonOnModal() {
    modalLoginButton.click();
  }

  public void clickRegistrationLink() {
    wait.until(visibilityOf(registrationLink));
    registrationLink.click();
  }

  public void clickRegisterButton() {
    scrollIntoView(registerButton);
    registerButton.click();
  }

  public void fillSalutation(String salutation) {
    Select salutationSelect = new Select(salutationElement);
    salutationSelect.selectByVisibleText(salutation);
  }

  public void fillFirstName(String firstName) {
    firstNameField.sendKeys(firstName);
  }

  public void fillLastName(String lastName) {
    lastNameField.sendKeys(lastName);
  }

  public void checkNewsletterCheckbox() {
    if (!newsletterCheckbox.isSelected()) {
      newsletterCheckbox.click();
    }
  }

  public void fillBirthMonth(String month) {
    birthMonthField.sendKeys(month);
  }

  public void fillBirthDay(String day) {
    birthDayField.sendKeys(day);
  }

  public void fillBirthYear(String year) {
    birthYearField.sendKeys(year);
  }
}
