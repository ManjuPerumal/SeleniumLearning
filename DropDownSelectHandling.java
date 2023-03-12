package SeleniumProjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownSelectHandling {

	@Test
	
	public void selectName() {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");
	
		WebElement SelectName=driver.findElement(By.id("userSelect"));
		Select selNameObj = new Select (SelectName);
		selNameObj.selectByVisibleText("Ron Weasly");
		
		driver.findElement(By.xpath("//button [@type='submit']")).click();
		
		String errorMessage = driver.findElement(By.xpath("//span[@class='fontBig ng-binding']")).getText();
		System.out.println(errorMessage);
		if(errorMessage.equalsIgnoreCase("Ron Weasly")) {
			System.out.println("Test Case Passed");
		}
		else {
			System.out.println("Test Case Failed");
		}
	}
	
	@Test
	
	public void depositAmount() {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");
		WebElement selectName=driver.findElement(By.id("userSelect"));
		Select selNameObj=new Select (selectName);
		selNameObj.selectByVisibleText("Harry Potter");
		
		driver.findElement(By.xpath("//button [@type='submit']")).click();
		
		driver.findElement(By.xpath("//button [@ng-class='btnClass2']")).click();
		String balAmount1=driver.findElement(By.xpath("//div[@class='ng-scope']/div/div[2]/strong[2]")).getText();
		System.out.println("Current Balance:"+balAmount1);
		int balance=Integer.parseInt(balAmount1);
		String depAmount="10000";
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys(depAmount);
	//	String depAmount1=driver.findElement(By.xpath("//input[@type='number']")).getText();
		System.out.println("Deposit Amount:" +depAmount);	
		//int depAmount2=Integer.parseInt(depAmount1);
		//int amount1=balAmount2+depAmount2;
		//String amount2=Integer.toString(amount1);
		driver.findElement(By.xpath("//button [@type='submit']")).click();
		
		String errorMessage=driver.findElement(By.xpath("//span [@ng-show='message']")).getText();
		System.out.println(errorMessage);
		
		if(errorMessage.equalsIgnoreCase("Deposit Successful")) {
			System.out.println("Test Case Passed");
		}
		
		else {
			System.out.println("Test Case Failed");
		}
		
		String balAmount2=driver.findElement(By.xpath("//div[@class='ng-scope']/div/div[2]/strong[2]")).getText();
		System.out.println("Final Balance:"+balAmount2);
		int balance1=Integer.parseInt(balAmount2);
		
		int balAmount=balance1 - balance;
		//System.out.println(balAmount);		
		String depAmount1=Integer.toString(balAmount);
		
		if(depAmount1.equals(depAmount)) {
			System.out.println("Test Case Passed");
		}
		else {
			System.out.println("Test Case Failed");
		}
		
		
	}
	
	@Test
	
	public void withdrawlAmount() {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");
		
		WebElement selectName=driver.findElement(By.id("userSelect"));
		Select selNameObj=new Select (selectName);
		selNameObj.selectByVisibleText("Hermoine Granger");
		
		driver.findElement(By.xpath("//button [@type='submit']")).click();
		driver.findElement(By.xpath("//button[@ng-class='btnClass3']")).click();
		
		String balance=driver.findElement(By.xpath("//div[@ng-hide='noAccount']/strong[2]")).getText();
		System.out.println("Initial Balance : " +balance);
		int initbalance=Integer.parseInt(balance);
		
		String withdrawnAmount="100";
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys(withdrawnAmount);
		System.out.println("Withdrawl Amount : "+withdrawnAmount);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String balance1=driver.findElement(By.xpath("//div[@ng-hide='noAccount']/strong[2]")).getText();
		System.out.println("Final Balance : " +balance1);
		int finalbalance=Integer.parseInt(balance1);
		
		String withdrawnAmount1= Integer.toString(finalbalance-initbalance);
		
		if(withdrawnAmount1.equals(withdrawnAmount)) {
			System.out.println("Test Case passed");
		}
		else {
			System.out.println("Test Case passed");
		}
		
		String welcomeMessage=driver.findElement(By.xpath("//span[@class='fontBig ng-binding']")).getText();
		if(welcomeMessage.equals("Hermoine Granger")) {
			System.out.println("Test case passed");
		}
		else {
			System.out.println("Test case failed");
		}
		
		
		
		
		
	}
	
}
