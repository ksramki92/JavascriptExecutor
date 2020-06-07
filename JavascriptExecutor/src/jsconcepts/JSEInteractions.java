package jsconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JSEInteractions {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\Selenium\\geckodriver-v0.25.0-win64\\geckodriver.exe");
		
		driver=new FirefoxDriver();
		
		driver.get("https://www.google.com");
		
		WebElement elementOfInput = driver.findElement(By.xpath("//input[@class='gLFyf gsfi' and @title='Search']"));
		WebElement elementOfSearch=driver.findElement(By.xpath("//input[@class='gNO89b' and @type='submit']"));
		enterByJSE(elementOfInput);
		clickByJSE(elementOfSearch);
	}

	public static void enterByJSE(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='check'", element);
	}
	
	public static void clickByJSE(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click()", element);
	}
}

//$('ul.menus.menu-secondary.sf-js-enabled.sub-menu li').hover()"

