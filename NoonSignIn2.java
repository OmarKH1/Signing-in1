package testingNoon;

import static org.junit.Assert.*;

import java.time.Duration;
import org.openqa.selenium.interactions.Actions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NoonSignIn2 {
	WebDriver driver;
	String baseURL;
	private JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {
		this.driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		baseURL = "https://www.noon.com/egypt-en/?utm_source=C1000088L&utm_medium=cpc&utm_campaign=C1000151355N_eg_en_web_searchxxexactandphrasexxbrandpurexx08082022_noon_web_c1000088l_acquisition_sembranded_&gclid=CjwKCAjw29ymBhAKEiwAHJbJ8l84LQDKEIz2AWkDUvJVy5NR-U-CATPqlBWvNwhJLPXLa_zEOpInWhoCoVEQAvD_BwE";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
		
	}
	@Test
	public void test() throws Exception {
	      String username = "Omarkhafagy69@gmail.com";
	      String password = "Tonitonichopper_1";
	      String shoes = "adidas";
	      signIn(username, password);
	      searchForProduct(shoes);     
	      selectSize();
	      addToCart();
	      checkout();
	  }
	  public void signIn(String username, String password) {
	       
	      driver.findElement(By.xpath("//span[@class='userText']")).click();
	      
	      driver.findElement(By.id("emailInput")).sendKeys(username);
	      driver.findElement(By.id("passwordInput")).sendKeys(password);
	      driver.findElement(By.id("login-submit")).click();
	  }
	  public void searchForProduct(String shoes) throws InterruptedException {
	      
	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	      //Waiting until the search bar being available to be clicked on and then entering the word "adidas"
	      WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.id("searchBar")));
	      Thread.sleep(5000);
	      search.sendKeys(shoes);
	      //waiting until the list appears and be available to be clicked on and choose "adidas shoes for men"
	      WebElement searchbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath
	              ("//*[@id=\"__next\"]/div/header/div[1]/div[2]/div[2]/div/div[2]/div/div/div/div/div/div[1]/div")));
	      searchbox.click();
	      Thread.sleep(4000);
	  }
	  public void selectSize() throws InterruptedException {
	      //After the page is loaded, it scrolls down to the desired product  
	      js.executeScript("window.scrollBy(0,1500);");
	      driver.findElement(By.xpath("//div[@title='Adidas Grand Court TD Lifestyle Court Casual Shoes ']"))
	              .click();
	      Thread.sleep(3000);
	      //After clicking on the product the page scrolls down where the size button is shown
	      js.executeScript("window.scrollBy(0,750);");
	      WebElement sizelist = driver.findElement(By.xpath(
	              "//div[@class='sc-35035e54-1 djqwPY section']  //div[@id='selectBoxFromComponent']//div[@class=' css-10bh5jj-control']"));
	      sizelist.click();
	      Thread.sleep(1000);
	      //Scrolling down to the end of the size list to choose the size 
	      Actions actions = new Actions(driver);
	      actions.moveToElement(sizelist);
	      actions.sendKeys(Keys.END).perform();
	      driver.findElement(By.xpath("//div[@id = 'react-select-selectBoxFromComponent-option-10']")).click();
		  Thread.sleep(3000);
	  }
	  
	  public void addToCart() throws InterruptedException {
		  js.executeScript("window.scrollBy(0,750);");
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//div[@class = 'loaderCtr inactiveLoading']")).click();
			Thread.sleep(2000);
	  }
	  public void checkout() throws InterruptedException {
		  driver.findElement(By.id("checkout-btn")).click();
	  }
	  @After
		public void tearDown() throws Exception {
			Thread.sleep(8000);
			driver.quit();
			
			
		}
}
