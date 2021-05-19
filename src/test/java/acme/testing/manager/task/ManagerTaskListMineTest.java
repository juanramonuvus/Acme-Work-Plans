package acme.testing.manager.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class ManagerTaskListMineTest extends AcmePlannerTest{
	
	// Test cases -------------------------------------------------------------
	
	/*
	 * In this test, we test the list of personal tasks.
	 * To do so, we register as a manager and enter the personal tasks list.
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/list-mine.csv", encoding = "utf-8", numLinesToSkip=1)
	@Order(10)
	public void listMinePositive(final Integer index ,final String title, final String executionStart, final String executionEnd, final String workload, final String description, final String link, final String publica) {
		
		super.signIn("manager1", "manag3r");
		
		super.clickOnMenu("Manager", "Personal Tasks");
		
		super.checkColumnHasValue(index,0, title);
		super.checkColumnHasValue(index,1, executionStart);
		super.checkColumnHasValue(index,2, executionEnd);
		super.checkColumnHasValue(index,3, workload);
		super.checkColumnHasValue(index,4, description);
		super.checkColumnHasValue(index,5, link);
		
	}
	/*
	 * In this test, it prove that an anonymous is not authorised to list manager´s tasks.
	 * To do so, we navigate without sign in to the manager tasks view.
	 */
	
	@Test
	@Order(20)
	public void listMineNegative() {
		
		super.navigate("manager/task/list-mine", "");
		
		super.checkErrorsExist();
		
	}
	
}
