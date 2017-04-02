package ui.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.steps.HomeSteps;

public abstract class BaseUITestCase {

  WebDriver driver;
  WebDriverWait wait;

  HomeSteps homeSteps;

  @Before
  public void setUp() {
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 15);
    homeSteps = new HomeSteps(driver, wait);
    driver.get(System.getProperty("base.url"));
  }

  @After
  public void tearDown() {
    driver.quit();
  }


}
