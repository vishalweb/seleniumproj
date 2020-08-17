import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test2 {
	@Test
	public void testCaseVerifyItemInCart() {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\uppal\\Downloads\\chromedriver_win32\\chromedriver.exe");

		    WebDriver driver = new ChromeDriver();
		    driver.get("http://ebay.com.au/");
		    try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  // Let the user actually see something!
		    Actions actions = new Actions(driver);
		    WebElement hoverLink = driver.findElement(By.cssSelector("#gh-eb-My"));
		    actions.moveToElement(hoverLink).perform();
		    driver.findElement(By.xpath("//*[@id='gh-eb-My-o']/ul/li[1]/a")).click();
		    try {
		    	// This sleep is to allow user to manually enter capcha
				Thread.sleep(150000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    driver.findElement(By.id("signin-continue-btn")).click();
		    try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    Boolean isPresent = driver.findElements(By.id("signin-error-msg")).size() > 0;
		    String errorText="Oops, that's not a match.";
		    Assert.assertTrue(isPresent,"Error element does not exist in dom");
		    Assert.assertTrue(driver.findElement(By.xpath("//*[@id='signin-error-msg']")).getText().contains(errorText), "Error message did not get displayed");
		    
	}

}
