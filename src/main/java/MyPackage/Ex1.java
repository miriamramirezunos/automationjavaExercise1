package MyPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

@Test
public class Ex1 {
	public WebDriver driver;
	
  public void ExercisesAJava1() throws Exception  {
	  String text = "Lo más Pro\n" + "para cada pro.", 
			  title = "iPhone XR - Apple (MX)"; 
	  // Go to apple.com.mx
	  System.out.println("Opening google chrome browser");
	  driver.get("https://www.apple.com/mx/");
	  // Go to Mac
	  driver.findElement(By.cssSelector("nav#ac-globalnav>div>ul:nth-of-type(2)>li:nth-of-type(2)>a")).click();
	  // Assert text
	  Assert.assertEquals(driver.findElement(By.cssSelector("main#main>section>div>div>div>h2")).getText(), text); 
	  // Click on the search bar
	  driver.findElement(By.cssSelector("#ac-gn-link-search")).click();
	  // Search for iPhone XR
	  driver.findElement(By.cssSelector("#ac-gn-searchform-input")).sendKeys("iPhone XR"); 
	  driver.findElement(By.cssSelector("#ac-gn-searchform-submit")).click();
	  // Validate Page Title. It should be: "iPhone XR - Apple (MX)
	  Assert.assertEquals(driver.getTitle(),title);
	  driver.findElement(By.cssSelector("#explore-tab>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div:nth-of-type(2)>h2")).click();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  // Validate options are available and enabled
	  Assert.assertEquals(driver.findElement(By.cssSelector("#ac-localnav>div>div:nth-of-type(2)>div:nth-of-type(2)>div>ul>li>span")).isDisplayed(), true);
	  Assert.assertEquals(driver.findElement(By.cssSelector("#ac-localnav>div>div:nth-of-type(2)>div:nth-of-type(2)>div>ul>li>span")).isEnabled(), true);
	  Assert.assertEquals(driver.findElement(By.cssSelector("#ac-localnav>div>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(2)>div>a")).isDisplayed(), true);
	  Assert.assertEquals(driver.findElement(By.cssSelector("#ac-localnav>div>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(2)>div>a")).isEnabled(), true);
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("launching chrome browser");
	  System.setProperty("webdriver.chrome.driver", "C:\\Drivers2\\chromedriver.exe");
	  driver = new ChromeDriver();
  }

  @AfterTest
  public void afterTest() {
	  System.out.print("\nBrowser close");
	  driver.quit();
  }

}
