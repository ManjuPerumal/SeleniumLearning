package SeleniumProjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LambdatestLoginPortal extends BrowserLaunch{

	@Test
	
	public void loginPortal() {
		
		navigateToUrl("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
		
		WebElement account=driver.findElement(By.xpath("(//span[contains(text(), 'My account')])[2]"));
		Actions actionObj = new Actions(driver);
		actionObj.moveToElement(account);
		
		WebElement login=driver.findElement(By.xpath("//span[contains(text(), 'Login')]"));
		actionObj.moveToElement(login).click().build().perform();
		
		driver.findElement(By.id("input-email")).sendKeys("info569@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Info");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		WebElement myAccount=driver.findElement(By.xpath("(//span[contains(text(), 'My account')])[2]"));
		actionObj.moveToElement(myAccount).perform();
		
		WebElement voucher = driver.findElement(By.xpath("//span[contains(text(), 'My voucher')]"));
		actionObj.moveToElement(voucher).click().build().perform();
		
		//String text=driver.findElement(By.xpath("//label[contains(text(), 'Gift Certificate Theme')]")).getText();
		
		List <WebElement> radio=driver.findElements(By.xpath("//input[@type='radio']"));
		//System.out.println(radio);
		
		
		if(radio.size()==3) {
			System.out.println("Test Case Passed");
		}
		
		else {
			System.out.println("Test Case Failed");
		}
		
		List <WebElement> textValue=driver.findElements(By.xpath("//div[@class='form-check']"));
		//for(WebElement text : textValue) {
			//System.out.println(text.getText());
		//}
		
		String []value= {"Birthday", "Christmas", "General"};
		
		for(int i=0; i<textValue.size();i++) {
			if(textValue.get(i).getText().equals(value[i])) {
				System.out.println("Testcase passed");
			}
			
			else {
				System.out.println("Testcase failed");
			}
		}
		
	}
}
