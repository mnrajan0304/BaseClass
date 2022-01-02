package org.BaseClass;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class summaTesting2 {

	public static void main(String[] args) {
		
		Baseclass base= new Baseclass();
		base.browserLaunch("chrome");
		base.get("http://www.facebook.com");
		base.brokenLinks();
		base.quit();
	
		}
}

