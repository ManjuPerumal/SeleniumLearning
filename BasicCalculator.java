package SeleniumProjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicCalculator {
	@Test
	public void addFunctionality() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().window().maximize();
		driver.get("https://testsheepnz.github.io/BasicCalculator.html");
		driver.findElement(By.id("number1Field")).sendKeys("5.48");
		driver.findElement(By.id("number2Field")).sendKeys("2.35");
		driver.findElement(By.id("calculateButton")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("integerSelect")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("clearButton")).click();
		driver.close();	
	}
}
