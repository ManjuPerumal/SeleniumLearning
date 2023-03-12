package SeleniumProjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LambdatestAddToCart extends BrowserLaunch {

	@Test
	public void addToCart() throws InterruptedException {
		//navigateToUrl("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
		
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
		
		Thread.sleep(2000);
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='text-ellipsis-2']")));
		
		driver.findElement(By.xpath("(//div[@class='product-layout product-grid no-desc col-xl-4 col-lg-4 col-md-4 col-sm-6 col-6'])[2]")).click();

		driver.findElement(By.xpath("(//button[text()='Add to Cart'])[2]")).click();
		
		//WebElement firstProduct = driver.findElement(By.xpath("(//div[@class='product-layout product-grid no-desc col-xl-4 col-lg-4 col-md-4 col-sm-6 col-6'])[2]"));
		//actionObj.moveToElement(firstProduct).perform();
		
		//WebElement addToCart = driver.findElement(By.xpath("(//i[@class='fas fa-shopping-cart'])[2]"));
		//actionObj.moveToElement(addToCart).click().build().perform();
		
		//WebElement viewCart = driver.findElement(By.xpath("//a[@class='btn btn-primary btn-block']"));
		//actionObj.moveToElement(viewCart).click().build().perform();
		
		//driver.findElement(By.id("notification-box-top")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@class='btn btn-primary btn-block']")).click();
		
		driver.findElement(By.xpath("//table[@class='table table-bordered']//tbody/tr/td[4]/div/input")).clear();
		
		String quantity="4";
		double intQuantity=Double.parseDouble(quantity);
		driver.findElement(By.xpath("//table[@class='table table-bordered']//tbody/tr/td[4]/div/input")).sendKeys(quantity, Keys.TAB);
		driver.findElement(By.xpath("//table[@class='table table-bordered']//tbody/tr/td[4]/div[1]/div/button")).click();
		String unitPrice=driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]//tbody/tr/td[5]")).getText();
		String unitPriceSubString=unitPrice.substring(1,unitPrice.length());
		System.out.println(unitPriceSubString);
		double intUnitPrice = Double.parseDouble(unitPriceSubString);
			
		String totalPrice=driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]//tbody/tr/td[6]")).getText();
		//int intTotalPrice=Integer.parseInt(totalPrice);
		
		double intTotalAmount=intQuantity*intUnitPrice;
		String totalAmount=String.format("%.2f", intTotalAmount);
		System.out.println("Total Amount: "+totalAmount);
		
		String s1=totalPrice.substring(1,totalPrice.length());
		System.out.println(s1);
		
		if(totalAmount.equals(s1)) {
			System.out.println("Test Case Passed");
		}
		
		else {
			System.out.println("Test Case Failed");
		}
		
		driver.findElement(By.xpath("//a[contains (text(),'Checkout')]")).click();
		driver.findElement(By.id("input-telephone")).clear();
		
		driver.findElement(By.id("input-telephone")).sendKeys("+91 8610388412");
		
		driver.findElement(By.id("input-payment-firstname")).sendKeys("Manju");
		driver.findElement(By.id("input-payment-lastname")).sendKeys("Perumal");
		driver.findElement(By.id("input-payment-company")).sendKeys("xxx");
		driver.findElement(By.id("input-payment-address-1")).sendKeys("No. 69, Nehru street");
		driver.findElement(By.id("input-payment-address-2")).sendKeys("Kathirkamam, Pondy");
		driver.findElement(By.id("input-payment-city")).sendKeys("Pondicherry");
		driver.findElement(By.id("input-payment-postcode")).sendKeys("605009");
		
		
		WebElement country=driver.findElement(By.id("input-payment-country"));
		Select selCountryObj=new Select (country);
		selCountryObj.selectByVisibleText("India");
		
		WebElement state=driver.findElement(By.id("input-payment-zone"));
		Select selStateObj=new Select(state);
		selStateObj.selectByVisibleText("Puducherry");
		
		WebElement checkbox=driver.findElement(By.id("input-shipping-address-same"));
		if(!checkbox.isSelected()) {
			checkbox.click();
		}
		
		driver.findElement(By.id("input-comment")).sendKeys("Thanks for the Product");
		driver.findElement(By.xpath("//label[@for='input-agree']")).click();
		
	}
	
}
