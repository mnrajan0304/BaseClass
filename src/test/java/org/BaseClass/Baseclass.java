package org.BaseClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;

public class Baseclass {
	WebDriver driver;
	
	public void browserLaunch(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mnrajan\\Desktop\\Softwares\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("Firefox")) {
		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\mnrajan\\Desktop\\Softwares\\geckodriver-v0.30.0-win64\\geckodriver.exe");
          driver= new FirefoxDriver();
		}
		else
			System.out.println("Error: Browser not support");
	}
	
	public void get(String url) {
		driver.get(url);
	}
	
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	public String pageSource() {
		String pageSource = driver.getPageSource();
		return pageSource;
	}
	
	public WebElement findElement(String by, String value) {
		
		WebElement element = null;
		if (by.equalsIgnoreCase("name"))
		    element = driver.findElement(By.name(value));
		else if (by.equalsIgnoreCase("id"))
			element = driver.findElement(By.id(value));
		else if (by.equalsIgnoreCase("className"))
			element =driver.findElement(By.className(value));
		else if (by.equalsIgnoreCase("linkText"))
			element =driver.findElement(By.linkText(value));
		else if (by.equalsIgnoreCase("partialLinkText"))
			element =driver.findElement(By.partialLinkText(value));
		else if (by.equalsIgnoreCase("cssSelector"))
			element =driver.findElement(By.cssSelector(value));
		else if (by.equalsIgnoreCase("xpath"))
			element =driver.findElement(By.xpath(value));
		else if (by.equalsIgnoreCase("tagName"))
			element =driver.findElement(By.tagName(value));
		else System.out.println("Error!: please enter proper by method");
	
		return element;
	}
	
	public Options manage() {
		org.openqa.selenium.WebDriver.Options options = driver.manage();
		return options;
	}
	public Window window() {
		Window window = driver.manage().window();
		return window;
	}
	public void maximize() {
		driver.manage().window().maximize();
	}
	public void clearAllCookies() {
		driver.manage().deleteAllCookies();
	}
	
	public void close() {
		driver.close();
	}
	
	public void quit() {
		driver.quit();
	}
	
	public void sendKeys(WebElement element, String value) {
				element.sendKeys(value);
	}

	public void clear(WebElement element) {
		element.clear();
	}
	
	public String getText(WebElement element) {
		String Text = element.getText();
		return Text;
	}
	public String getAttribute(WebElement element, String attribute_name ) {
		String attribute = element.getAttribute(attribute_name);
		return attribute;
	}
	public String getTagName(WebElement element) {
		String tag = element.getTagName();
		return tag;
	}
	public String getCssValue(WebElement element, String value_name) {
		String cssvalue = element.getCssValue(value_name);
		return cssvalue;
	}
	public Point getLocation(WebElement element) {
		Point point = element.getLocation();
		return point;
	}
	public Dimension getSize(WebElement element) {
		Dimension dimension = element.getSize();
		return dimension;
	}
	public boolean isDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}
	public boolean isSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}
	public boolean isEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}
	public void submit(WebElement element) {
		element.submit();
	}
	
	public void select(WebElement element, String type, String value) {
		Select s= new Select(element);
		if(type.equalsIgnoreCase("index"))
		s.selectByIndex(Integer.parseInt(value)); //String to integer
		else if (type.equalsIgnoreCase("value"))
		s.selectByValue(value);
		else if (type.equalsIgnoreCase("text"))
		s.selectByVisibleText(value);
	}
	
	public void deselect(WebElement element, String type, String value) {
		Select s= new Select(element);
		if (s.isMultiple()==true) {
		if(type.equalsIgnoreCase("index"))
			s.deselectByIndex(Integer.parseInt(value));
		else if (type.equalsIgnoreCase("value"))
			s.deselectByValue(value);
		else if (type.equalsIgnoreCase("text"))
		s.deselectByVisibleText(value);
		}
		else System.out.println("Deslect option can't perform here");
	}
	
	public void deselectAll(WebElement element) {
		Select s= new Select(element);
		s.deselectAll();
	}
			
	public List<WebElement> getAllSelectedOptions(WebElement element) {
		Select s= new Select(element);
		 return s.getAllSelectedOptions();
	}
		
	public WebElement getFirstSelectedOption(WebElement element) {
		Select s= new Select(element);
		return s.getFirstSelectedOption();
	}
	public List<WebElement> getOptions(WebElement element) {
		Select s= new Select(element);
		return s.getOptions();
	}
	
	public String getAllSelectedOptionsText(WebElement element) {
		Select s= new Select(element);
		List<WebElement> li = s.getAllSelectedOptions();
		String text= null;
		for(WebElement e: li) {
			 text = e.getText();
			 System.out.println(text);
		}		
		return text;
	}
	public String getOptionsText(WebElement element) {
		Select s= new Select(element);
		List<WebElement> li = s.getOptions();
		String text= null;
		for(WebElement e: li) {
			 text = e.getText();
			 System.out.println(text);
		}		
		return text;
	}
	
	public void screenshot(String name) {
		TakesScreenshot tk =  (TakesScreenshot) driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File des = new File(".//screenshot//"+name+".png");
		try {
			FileUtils.copyFile(source, des);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void waitThread(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public void waitImplicit(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public WebDriverWait waitExplicit(int time) {
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait;
	}
	
	public void waitFluent(int withTimeout, int pollingEvery) {
	
		@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
		Wait wait = new FluentWait(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(30))
                .ignoring(Exception.class);
	}
	
	public void switchtoFrame(String using) {
		if (using.equalsIgnoreCase("id")||using.equalsIgnoreCase("name"))
		driver.switchTo().frame(using);
		else if (using.equalsIgnoreCase("index")) 
			driver.switchTo().frame(Integer.parseInt(using));
	}
	
	public void switchtoFrameelement(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public String windowHandle() {
		return driver.getWindowHandle();
	}
	
	public Set<String> windowHandles() {
		return driver.getWindowHandles();
	}
	
	public void switchWindowid(String id) {
		  driver.switchTo().window(id);
	}
	
	public void fileUpload(WebElement element, String path) {
		element.sendKeys(path);
	}
	
	public void autheticationPopup(String username, String password, String urlwithouthttsps) {
		driver.get("https://"+username+":"+password+"@"+urlwithouthttsps);
	}
	
	public void jsExecutor() {
		
	}
	public void webtable() {
		
	}
	public void brokenLinks() {
		
	}
	
	public Navigation navigate() {
		Navigation navigate = driver.navigate();
		return navigate;
	}
	public Actions actions() {
		Actions action = new Actions(driver);
		return action;
	}
	public Alert alert() {
		Alert alert = driver.switchTo().alert();
		return alert;
	}
}

