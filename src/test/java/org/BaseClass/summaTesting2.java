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
		base.get("http://demo.guru99.com/popup.php");
	
		String PWID= base.windowHandle();
		System.out.println(PWID);
		
		base.findElement("partiallinktext", "Here").click();

		Set<String> allWID= base.windowHandles();
		
		
	
		for(String s:allWID) {
			if(!s.equalsIgnoreCase(PWID)) {
				System.out.println(s);
				
				base.switchWindowid(s);
				//driver.switchTo().window(s);
			base.maximize();
			base.findElement("xpath", "/html/body/form/table/tbody/tr[5]/td[2]/input").sendKeys("mani@gmail.com");
			base.findElement("xpath", "/html/body/form/table/tbody/tr[6]/td[2]/input").submit();
				
			/*driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input")).sendKeys("mani@gmail.com");
				
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td[2]/input")).submit();
				
				driver.switchTo().defaultContent();  */
			}
		}
		}}

