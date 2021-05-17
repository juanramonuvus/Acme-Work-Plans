package acme.testing.manager.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

import acme.testing.AcmePlannerTest;

public class ManagerTaskCreateTest extends AcmePlannerTest{
	
	// Test cases -------------------------------------------------------------
	
	/* 
	 * This test signs in as a manager, navigates into a personal task and updates its attributes.
	 * There shouldn't be any error, all data matches with restrictions.
	 */
	
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void updatePositive(final int recordIndex, final String title,
		final String executionStart, final String executionEnd,
		final String workload, final String description, final String link,final String isPublic) {		
		
		super.signIn("manager1", "manag3r");
		
		super.clickOnMenu("Manager", "Create Task");

		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("executionStart", executionStart);
		super.fillInputBoxIn("executionEnd", executionEnd);
		super.fillInputBoxIn("workload", workload);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("link", link);
		final By inputLocator = By.id("isPublic$proxy");
		super.clickAndGo(inputLocator);
		
		super.clickOnSubmitButton("Create");
		
		super.clickOnMenu("Manager", "Personal Tasks");
		
		super.clickOnListingRecord(0);
		
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("executionStart", executionStart);
		super.checkInputBoxHasValue("executionEnd", executionEnd);
		super.checkInputBoxHasValue("workload", workload);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("link", link);	
		super.checkInputBoxHasValue("isPublic", isPublic);
		
		super.signOut();
		
		
	}
	
	/* 
	 * This test signs in as a manager, navigates into a personal task and updates its attributes.
	 * There would rise some errors:
	 * 	- Title: Text considerated spam.
	 *  - Workload: The workload must be positive.
	 *  - Link: Text considerated spam.
	 */
	
//	@ParameterizedTest
//	@CsvFileSource(resources = "/manager/task/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
//	@Order(20)
//	public void updateNegative(final int recordIndex, final String title,
//		final String executionStart, final String executionEnd,
//		final String workload, final String description, final String link) {		
//		
//		super.signIn("manager1", "manag3r");
//		
//		super.clickOnMenu("Manager", "Personal Tasks");
//		super.clickOnListingRecord(recordIndex);
//
//		super.fillInputBoxIn("title", title);
//		super.fillInputBoxIn("executionStart", executionStart);
//		super.fillInputBoxIn("executionEnd", executionEnd);
//		super.fillInputBoxIn("workload", workload);
//		super.fillInputBoxIn("description", description);
//		super.fillInputBoxIn("link", link);		
//		
//		super.clickOnSubmitButton("Update");
//		
//		super.checkErrorsExist("title");
//		super.checkErrorsExist("workload");
//		super.checkErrorsExist("link");
//		
//		super.signOut();
//		
//		
//	}

}
