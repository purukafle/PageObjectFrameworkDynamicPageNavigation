package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.libraries.Base;

public class CheckBoxTest extends Base {
	@Test(enabled = true)
	public void checkBoxTest() {
		String url1 = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_checkbox";
		driver.get(url1);

		// switch to iframe
		driver = driver.switchTo().frame("iframeResult");

		//WebElement carElem = driver.findElement(By.id("vehicle2"));
		//carElem.click();
		myLibGS.customWait(3);
		//second box
		myLibGS.handleCheckBox(By.id("vehicle1"), true);
		myLibGS.takeScreenshot("checkbox2");
		myLibGS.handleCheckBox(By.id("vehicle2"), true);
		myLibGS.takeScreenshot("checkbox1");
		myLibGS.handleCheckBox(By.id("vehicle3"), true);
		myLibGS.takeScreenshot("checkbox3");
		
		//verifying if check box is disabled/ grayed-out
		
		WebElement checkbox=driver.findElement(By.id("vehicle2"));
		boolean checkBoxState= checkbox.isEnabled();
		if(checkBoxState==true) {
			System.out.println("check box is enable");
			
		}
		else {
			System.out.println("check box is disable");
		}

		// switch back to original browser
		driver = driver.switchTo().defaultContent();
	}


}
