package SeleniumProjects;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class WindowsHandling extends BrowserLaunch {

	@Test
	
	public void workingOnWindows() throws InterruptedException {
		navigateToUrl("https://www.naukri.com/");	
		
		Thread.sleep(20000);
		String baseWindow = driver.getWindowHandle();
		System.out.println(baseWindow);	
		System.out.println("~~~~~~~");	
		
		//driver.findElement(By.id("bottom-left-section.inventory-1")).click();		
		driver.findElement(By.xpath("//span[@title='Remote']")).click();
		Set<String> windowNameList = driver.getWindowHandles();
		for (String winName : windowNameList) {
			Thread.sleep(2000);
			if(!winName.equalsIgnoreCase(baseWindow)) {
				System.out.println(winName);
				driver.switchTo().window(winName);			
			}
		}
		String value = driver.findElement(By.xpath("//div[@class='sortAndH1Cont']/div[1]/span")).getText();
		System.out.println(value);
		String []split=value.split("of");
		System.out.println(split[0]);
		System.out.println(split[1]);
		String value1=split[1].trim();
		
		String text=driver.findElement(By.xpath("//label[@for='chk-Permanent Remote / WFH-wfhType-']/p/span[2]")).getText();
		System.out.println(text);
		
		String text1=text.replaceAll("[^0-9]", "");
		if(value1.equals(text1)) {
			System.out.println("Test Case passed");
		}
		else {
			System.out.println("Test Case failed");
		}
	}
}
