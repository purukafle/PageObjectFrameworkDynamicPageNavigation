package com.pages;

import static org.testng.Assert.assertNotNull;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.libraries.Base;

public class ScienceCategoryPage extends Base {
	private WebDriver driver;
	public ScienceCategoryPage(WebDriver _driver) {
		driver=_driver;
		myLibGS.setDriver(driver);//helps to pass same driver in myLibsGS
	this.driver = _driver;
	}
	//constructor
	
	public ScienceCategoryPage() {
		WebElement gridElem= waitForPageLoadToComplete();
		assertNotNull(gridElem);
			
		
	}
	private WebElement waitForPageLoadToComplete() {
		// Selenium ExpliciteWait
		//that mean, selenium explicitely waits a single elements state
		//state could be, elementVisible, ElementClickable, ElementNotVisible
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement searchResultGridElem=wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.cssSelector("div.SearchPage-HeaderTitle > h1 > span")));
		return searchResultGridElem;
		
	}
	public ScienceCategoryPage searchCourse(String inputCourseName) {
		//driver.findElement(By.id("search-field"));
		myLibGS.enterText(By.id("search-field"), inputCourseName);
		myLibGS.enterText(By.id("search-field"), Keys.ENTER);
		
		//WebElement searchElem=driver.findElement(By.id("search-field"));
		//searchElem.sendKeys("inputCourseName");
		//searchElem.sendKeys(Keys.ENTER);
		
		return this;
		
	}
	

}
