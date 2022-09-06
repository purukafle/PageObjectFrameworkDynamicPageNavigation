package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.libraries.Base;

public class HomePage extends Base {
	private WebDriver driver;

	public HomePage(WebDriver _driver) {
		driver = _driver;

//	public HomePage(WebDriver driver) {
//		super();
//		this.driver = driver;
//	}

	}

	// important note: every method in this class should return class name object
	// (example: HomePage)
	// except the page navigation methods
	// goto this site
	public HomePage gotoGreatCourseWebsite() {
		String websiteURL = "https://www.thegreatcourses.com/";
		driver.get(websiteURL);
		return this;
	}

	public ScienceCategoryPage selectBrowseCoursesScience() {
		By mainMenuBy=By.cssSelector("button.Header-Menu.Header-Menu_type_menu");
		By subMenuBy=By.cssSelector("div.MenuOverlay-ItemGroup.MenuOverlay-ItemGroup_isCategories.col-18 > ul > li:nth-child(12) > a");
		myLibGS.setDriver(driver);
		myLibGS.hoverOver(mainMenuBy, subMenuBy);
		//it will navigate into the next page
		ScienceCategoryPage scCatPage=new ScienceCategoryPage(driver);
		return scCatPage;
		//return new ScienceCategoryPage();
		
		
	}
	public Object selectBrowseCourse(String courseCategoryName) {
		Object finalCourseCategoryPageObject=null;
		//locate and hover the main menu
		WebElement mainMenu =driver.findElement(By.cssSelector("button.Header-Menu.Header-Menu_type_menu"));
		Actions actions=new Actions(driver);
		actions.moveToElement(mainMenu).build().perform();
		myLibGS.customWait(0.3);
		WebElement subMenuSection= driver.findElement(By.cssSelector("div.MenuOverlay-ItemGroup.MenuOverlay-ItemGroup_isCategories.col-18 > ul"));
		
		List<WebElement>courseElems= subMenuSection.findElements(By.tagName("li"));
		for(WebElement elem:courseElems) {
			String courseText= elem.getText();
			System.out.println("course category name: "+courseText);
			if(courseCategoryName.contains(courseText)) {
				elem.click();
				break;
				
			}
			
		}
		if(courseCategoryName.contains("Science")) {
			finalCourseCategoryPageObject=new ScienceCategoryPage(driver);
			return finalCourseCategoryPageObject;
		}
		else if(courseCategoryName.contains("Litrature & Language")) {
			//finalCourseCategoryPageObject= new LiteratureAndLangPage(driver);
			//return finalCourseCategoryPageObject;
			
		}
		//else if () cover all the course categories listed under Mainment
		return finalCourseCategoryPageObject;
	}

}
