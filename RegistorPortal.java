package SeleniumProjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class RegistorPortal {
@Test

	public void Register() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().window().maximize();
		driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
		driver.findElement(By.id("input-firstname")).sendKeys("Manju");
		driver.findElement(By.id("input-lastname")).sendKeys("Perumal");
		driver.findElement(By.id("input-email")).sendKeys("info12345@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("8642589520");
		driver.findElement(By.id("input-password")).sendKeys("Info");
		driver.findElement(By.id("input-confirm")).sendKeys("Info");
		driver.findElement(By.xpath("//label[@for='input-newsletter-yes']")).click();
		driver.findElement(By.xpath("//label[@for='input-agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}
	
}
