package SeleniumProjects;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FrameHandle extends BrowserLaunch {

	@Test(groups="demo")
	
	public void frameHandle() {
		navigateToUrl("https://demoqa.com/frames");
		
		driver.switchTo().frame("frame1");
		
		String val =driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(val);
		
		driver.switchTo().defaultContent();
	
		System.out.println(driver.findElement(By.xpath("//div[@id='framesWrapper']/div[1]")).getText());
	}
}
