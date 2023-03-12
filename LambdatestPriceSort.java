package SeleniumProjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class LambdatestPriceSort extends BrowserLaunch {

	@Test
	
	public void productsFromLowToHigh() throws InterruptedException {
		
		navigateToUrl("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
		
		WebElement account=driver.findElement(By.xpath("(//span[contains(text(), 'My account')])[2]"));
		Actions actionObj = new Actions(driver);
		actionObj.moveToElement(account);
		
		WebElement login=driver.findElement(By.xpath("//span[contains(text(), 'Login')]"));
		actionObj.moveToElement(login).click().build().perform();
		
		driver.findElement(By.id("input-email")).sendKeys("info569@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Info");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		WebElement megaMenu=driver.findElement(By.xpath("//span[contains (text(), 'Mega Menu')]"));
		actionObj.moveToElement(megaMenu).perform();
		
		WebElement apple=driver.findElement(By.xpath("(//a[contains(text(),'Apple')])[1]"));
		actionObj.moveToElement(apple).click().build().perform();
		
		WebElement showFilter = driver.findElement(By.id("input-limit-212433"));
		Select selShowObj = new Select(showFilter);
		selShowObj.selectByVisibleText("100");
		
		Thread.sleep(8000);
		
		//List <WebElement> products = driver.findElements(By.xpath("//div[@class='product-layout product-grid no-desc col-xl-4 col-lg-4 col-md-4 col-sm-6 col-6']"));
		
		//a[@class='text-ellipsis-2']
		List <WebElement> products = driver.findElements(By.xpath("//a[@class='text-ellipsis-2']"));
		List <WebElement> price = driver.findElements(By.xpath("//span[@class='price-new']"));
		
		System.out.println("List of Products");
		System.out.println("Total Number of Products : " +products.size());
		System.out.println("-------------------");
		
		for (int i=0; i<products.size(); i++) {
			System.out.println(products.get(i).getText() +"----" +price.get(i).getText());
		}
		
		
		WebElement sortBy = driver.findElement(By.id("input-sort-212434"));
		Select selSortObj = new Select(sortBy);
		selSortObj.selectByVisibleText("Price (Low > High)");
		
		Thread.sleep(5000);
		
		List <WebElement> products1 = driver.findElements(By.xpath("//a[@class='text-ellipsis-2']"));
		List <WebElement> price1 = driver.findElements(By.xpath("//span[@class='price-new']"));
		
		System.out.println("List of Products from Low to High:-");
		System.out.println("Total Number of Products : " +products1.size());
		System.out.println("-------------------");
		
		for (int i=0; i<products1.size(); i++) {
			System.out.println(products1.get(i).getText() +"----" +price1.get(i).getText());
		}
		
	}
}
