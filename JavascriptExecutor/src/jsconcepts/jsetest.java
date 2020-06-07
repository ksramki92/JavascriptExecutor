package jsconcepts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class jsetest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver","D:\\\\Softwares\\\\Selenium\\\\geckodriver-v0.25.0-win64\\\\geckodriver.exe");

		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://www.freecrm.com");//Naveen automationlabs - Youtube
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();	
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		
		WebElement Login=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a//span[contains(text(),'Log In')]"))));
		
		Login.click(); 
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement element=driver.findElement(By.xpath("//div[contains(text(),'Login')]"));
		
		//Make a field blinking using JSE
		flash(element,driver);
		
		
		//Highlighting a field using JSE
		drawBorder(element,driver);
		
		//Generating alert using JSE
		generateAlert(driver,"There is a bug!");
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src,new File("C:/Users/Ramki/documents/freecrmBug.png"));
		
		driver.switchTo().alert().accept();
		
		//Clicking a webelement using JSE
		clickBrowserByJS(element,driver);
		
		//Refreshing the page using JSE
		refreshBrowserByJS(driver);
		
		//Getting title of the page using JSE
		System.out.println(getTitleByJS(driver));
		
				
		System.out.println(element.getAttribute("innerHTML"));
		System.out.println(element.getAttribute("textContent"));
		System.out.println(getInnerTextByJS(driver));
		
		//scroll to end of the page
		scrollDownByJS(driver); 
			
		//scroll until element is visible on UI
		WebElement uiVisibleElement=driver.findElement(By.xpath("//h5[contains(text(),'Sell')]"));
		scrollIntoViewJS(uiVisibleElement,driver);
		
	}
	
	public static void flash(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		
		String bgcolor=element.getCssValue("background-color");
		
		System.out.println(bgcolor);
		
		for (int i=0;i<100;i++)
		{
			changeColor("rgb(200,0,60)",element,driver);
			changeColor(bgcolor,element,driver);
		}
		
	}
	
	public static void changeColor(String bgcolor,WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor='"+bgcolor+"'",element);
	
		try
		{
			Thread.sleep(20);
		}
		catch(InterruptedException e)
		{
			
		}
	}
	
	
	public static void drawBorder(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		
	}
	
	public static void generateAlert(WebDriver driver, String message)
	{
		
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("alert('"+message+"')");
	}
	
	public static void clickBrowserByJS(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		
		js.executeScript("arguments[0].click()", element);
		
	}
	
	public static void refreshBrowserByJS(WebDriver driver)
	{
		
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		
		js.executeScript("history.go(0)");
	}
	
	public static String getTitleByJS(WebDriver driver) 
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		
		String title=js.executeScript("return document.title;").toString();
		
		return title;
	}
	
	public static String getInnerTextByJS(WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		
		return js.executeScript("return document.documentElement.innerText").toString();
	}
	
	public static void scrollDownByJS(WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	
	public static void scrollIntoViewJS(WebElement element,WebDriver driver)
	{
		
		JavascriptExecutor js=((JavascriptExecutor)driver);
		
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		
		
	}
}
