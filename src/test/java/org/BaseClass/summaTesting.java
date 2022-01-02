package org.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class summaTesting {

	public static void main(String[] args) {
		
		Baseclass base= new Baseclass();
		
		int rowCount = base.getRowCount(".\\src\\main\\resources\\GeneralData.xlsx", "inputs");
		int cellCount = base.getCellCount(0);
	
		Object[][] data = new Object[rowCount-1][cellCount];
		for(int i= 1; i<rowCount; i++) {
			for(int j=0; j<cellCount; j++) {
				String value = base.getCellValue(i, j);
				data[i-1][j] = value;
				System.out.println(value);
			}
		} 
	}
}
