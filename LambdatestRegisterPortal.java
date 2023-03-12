package SeleniumProjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LambdatestRegisterPortal extends BrowserLaunch {

	@Test
	
	public void Register() {
		navigateToUrl("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
		
		WebElement account=driver.findElement(By.xpath("(//span[contains(text(), 'My account')])[2]"));
		Actions actionObj=new Actions(driver);
		actionObj.moveToElement(account);
		
		WebElement register=driver.findElement(By.xpath("//span[contains (text(), 'Register')]"));
		actionObj.moveToElement(register).click().build().perform();
		
		
		driver.findElement(By.id("input-firstname")).sendKeys("Manju");
		driver.findElement(By.id("input-lastname")).sendKeys("Perumal");
		driver.findElement(By.id("input-email")).sendKeys("info569@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("8642589520");
		driver.findElement(By.id("input-password")).sendKeys("Info");
		driver.findElement(By.id("input-confirm")).sendKeys("Info");
		driver.findElement(By.xpath("//label[@for='input-newsletter-yes']")).click();
		driver.findElement(By.xpath("//label[@for='input-agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}
	
}
