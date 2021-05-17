package acme.testing.manager.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

import acme.testing.AcmePlannerTest;

public class ManagerTaskCreateTest extends AcmePlannerTest{
	
	// Test cases -------------------------------------------------------------
	
	/* 
	 * This test signs in as a manager, navigates into create a task and create a task.
	 * There shouldn't be any error, all data matches with restrictions.
	 */
	
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void createPositive(final int recordIndex, final String title,
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
		if(isPublic.equals("true")) {
			final By inputLocator = By.id("isPublic$proxy");
			super.locateOne(inputLocator).click();
		}
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
	 * This test signs in as a manager, navigates into create a task and create a task.
	 * There would rise some errors:
	 * 	- Title: Must not be blank. Length must be between 1 and 80.
	 *  - Execution start: May not be null.
	 *  - Execution end: May not be null.
	 *  - Workload: May not be null.
	 *  - Description: Length must be between 1 and 500. Must not be blank.
	 */
	
	@Test
	@Order(20)
	public void createBlankNegative() {		
		
		super.signIn("manager1", "manag3r");
		
		super.clickOnMenu("Manager", "Create Task");
		
		super.clickOnSubmitButton("Create");
		
		super.checkErrorsExist("title");
		super.checkErrorsExist("executionStart");
		super.checkErrorsExist("executionEnd");
		super.checkErrorsExist("workload");
		
		String xpath;
		By locator;
		xpath = String.format("//div[@class='form-group'][textarea[@id='%s'] and div[@class='text-danger']]", "description");
		locator = By.xpath(xpath);
		assert super.exists(locator) : String.format("No errors found in input box '%s'", "description");
		
		super.signOut();
		
	}
	
	/* 
	 * This test signs in as a manager, navigates into create a task and create a task.
	 * There would rise some errors:
	 * 	- Title: Must not be blank. Length must be between 1 and 80.
	 *  - Execution start: Must be in the future. 
	 *  - Execution end: Must be in the future. 
	 *  - Workload: The workload value must be positive. 
	 *  - link: Not a well-formed URL.
	 */
	
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(30)
	public void updateNegative(final int recordIndex, final String title,
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
		
		super.clickOnSubmitButton("Create");
		
		super.checkErrorsExist("executionStart");
		super.checkErrorsExist("executionEnd");
		super.checkErrorsExist("workload");
		super.checkErrorsExist("link");
		
		super.signOut();
		
		
	}

}
