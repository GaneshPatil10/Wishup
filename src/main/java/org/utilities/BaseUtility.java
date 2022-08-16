package org.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUtility {
	private WebDriver driver;

	public WebDriver startUp (String url, String bName) {
		if(bName.equalsIgnoreCase("CH") || bName.equalsIgnoreCase("chrome")) {
			//CH
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			driver = new ChromeDriver();					

		}else if(bName.equalsIgnoreCase("Edge")) {
			//Edge
			System.setProperty("webdriver.edge.driver","./drivers/msedgedriver.exe");
			driver = new EdgeDriver();						

		} else {
			System.out.println("Invalid browser Name!!");
		}
		driver.manage().window().maximize();
		
		driver.get(url);
		return driver;
	}
	
	//Generic Methods
	
	//urlContains
	public void waitForUrlContains(WebDriver driver, int time, String url) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
		wt.until(ExpectedConditions.urlContains(url));
	}
	
	//VisibilityOfElementLocator
	public void waitForVisibilityOfElementLocated(WebDriver driver, int time, String type, String locator) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));

		switch(type) {
		case "id" : wt.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
		break;
		case "class" : wt.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
		break;
		case "xpath" : wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		break;
		case "cssSelector" : wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
		break;
		case "tagName" : wt.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locator)));
		break;
		}
	}
	//InvisibilityOfElementLocator
	public void waitForInvisibilityOfElementLocated(WebDriver driver, int time, String type, String locator) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
		
		switch(type) {
		case "id" :wt.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
		break;
		
		case "class": wt.until(ExpectedConditions.invisibilityOfElementLocated(By.className(locator)));
		break;
		
		case "xpath":wt.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
		break;
		
		case "cssSelector":wt.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(locator)));
		break;
		
		case "tagName": wt.until(ExpectedConditions.invisibilityOfElementLocated(By.tagName(locator)));
		break;
		}

	}
	//ElementToBeClickable
	public void waitForElementToBeClickable(WebDriver driver, int time, String type, String locator) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
		
		switch (type) {
		case "id": wt.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
		break;
		
		case "class":wt.until(ExpectedConditions.elementToBeClickable(By.className(locator)));
		break;
		
		case "xpath":wt.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		break;
		
		case "cssSelector":wt.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
		break;
		
		case "tagName":wt.until(ExpectedConditions.elementToBeSelected(By.tagName(locator)));
		break;
		}
	}
	//ElementToBeSelected
	public void waitForElementToBeSelected(WebDriver driver, int time, String type, String locator ) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
		
		switch(type) {
		case "id":wt.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
		break;
		
		case "class":wt.until(ExpectedConditions.elementToBeClickable(By.className(locator)));
		break;
		
		case "xpath":wt.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		break;
		
		case "cssSelector":wt.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
		break;
		
		case "tagName":wt.until(ExpectedConditions.elementToBeClickable(By.tagName(locator)));
		break;
		}
	}
	//PresenceOfElementLocated
	public void waitPresenceOfElementLocated(WebDriver driver, int time, String type, String locator) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		switch(type) {
		case "id":wt.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
		break;
		
		case "class":wt.until(ExpectedConditions.presenceOfElementLocated(By.className(locator)));
		break;
		
		case "xpath":wt.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		break;
		
		case "cssSelector":wt.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
		break;
		
		case "tagName":wt.until(ExpectedConditions.presenceOfElementLocated(By.tagName(locator)));
		break;
		}
	}
	//click by using Javascript	
	public void clickByJS(WebDriver driver, WebElement ele) {		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
	}
	public void scrollByJS(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
	}

	
}	

