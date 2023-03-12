package SeleniumProjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOverProject extends BrowserLaunch {

	@Test
	
	public void printCorseDetails() throws InterruptedException {
		navigateToUrl("https://oceanacademy.co.in/");
		Thread.sleep(3000);	
		driver.findElement(By.xpath("//div[@id='root']/div[1]/div")).click();
		
		WebElement courses = driver.findElement(By.id("courses"));
		Actions actionObj = new Actions(driver);
		actionObj.moveToElement(courses).perform();
		
		WebElement offlineCourses = driver.findElement(By.xpath("//a[text()='Offline Courses']"));
		actionObj.moveToElement(offlineCourses).click().build().perform();
		
		String firstCourseName = driver.findElement(By.xpath("(//p[@class='title'])[1]")).getText();
		System.out.println(firstCourseName);
		
		System.out.println("~~~~~~~~~~");
		List<WebElement> courseNameList = driver.findElements(By.xpath("//p[@class='title']"));
		for (WebElement indiCourse : courseNameList) {
			System.out.println(indiCourse.getText());
		}
	
}
	
	@Test
	public void mouseOverActions() throws InterruptedException {
		
		navigateToUrl("https://oceanacademy.co.in/");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='root']/div[1]/div")).click();
		
		WebElement course=driver.findElement(By.id("courses"));
		Actions actionobj=new Actions(driver);
		actionobj.moveToElement(course).perform();
		
		WebElement offlineCourses=driver.findElement(By.xpath("//a[text()='Offline Courses']"));
		actionobj.moveToElement(offlineCourses).click().build().perform();
		
		String firstTitle=driver.findElement(By.xpath("(//p[@class='title'])[1]")).getText();
		System.out.println("First Course Name : "+firstTitle);
		
		//WebElement listOfCourses=driver.findElements(By.xpath("(//p[@class='title'])")).getText();
		
		List <WebElement> listOfCourses=driver.findElements(By.xpath("//p[@class='title']"));
		
		System.out.println("-----------------------");
		
		for(int i=0; i<listOfCourses.size(); i++) {
			
			String courseTitle=listOfCourses.get(i).getText();
			System.out.println(courseTitle);
			
		}
		
	}
}
