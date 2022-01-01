package org.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class summaTesting {

	public static void main(String[] args) {
		
		Baseclass base= new Baseclass();
		base.browserLaunch("chrome");
		base.autheticationPopup("admin","admin","the-internet.herokuapp.com/basic_auth");
	}
}
