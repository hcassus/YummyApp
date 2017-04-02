package ui.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  protected WebDriver driver;
  protected WebDriverWait wait;

  public BasePage(WebDriver driver, WebDriverWait wait){
    PageFactory.initElements(driver, this);
    this.driver = driver;
    this.wait = wait;
  }


  protected void scrollIntoView(WebElement element) {
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("arguments[0].scrollIntoView(true);", element);
  }
}
