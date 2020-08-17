import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test1 {

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
		    driver.findElement(By.cssSelector(".gh-tb.ui-autocomplete-input")).sendKeys("bike");
		    driver.findElement(By.id("gh-btn")).click();
		    try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    String elementClicked = driver.findElement(By.xpath("//*[@id='srp-river-results']/ul/li[1]/div/div[2]/a")).getText();
		    driver.findElement(By.xpath("//*[@id='srp-river-results']/ul/li[1]/div/div[2]/a")).click();
		    System.out.println(elementClicked);
		    driver.findElement(By.id("atcRedesignId_btn")).click();
		    try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    driver.findElement(By.xpath("//div[@class='app-atc-layer__actionRow']/a[2]")).click();
            String cartcountString= "1 item";
            Assert.assertEquals(elementClicked, driver.findElement(By.xpath("//div[@class='listsummary-content-itemdetails']/h3/span/a[1]")).getText(), "Item not found in cart");
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class='top-section']/h1")).getText().contains(cartcountString), "Item not added to cart");
            driver.quit();
	}

}
