package com.gratcources.tests;

import org.testng.annotations.Test;

import com.libraries.Base;
import com.pages.HomePage;
import com.pages.ScienceCategoryPage;
//this class is testScript class, can contain more than one test
public class BuyACourseTests extends Base {
	@Test
	public void buyNightSkyCourseTest() {
		
		HomePage homePage=new HomePage(driver);
		ScienceCategoryPage scPage;
		
		homePage.gotoGreatCourseWebsite();
		scPage =homePage.selectBrowseCoursesScience();
		//homePage.selectBrowseCourse("Science");
		//homePage.selectBrowseCourse("Literature & Language");
		
		scPage.searchCourse("our night sky");
		
		
		
	}
	

}
