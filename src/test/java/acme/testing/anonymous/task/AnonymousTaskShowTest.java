package acme.testing.anonymous.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AnonymousTaskShowTest extends AcmePlannerTest{
	
	// Test cases -------------------------------------------------------------
	
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/task/show-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void showPositive(final int index, final String title,
		final String executionStart, final String executionEnd,
		final String workload, final String description, final String link) {		
		
		super.navigate("anonymous/task/show", "id=18");
		
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("executionStart", executionStart);
		super.checkInputBoxHasValue("executionEnd", executionEnd);
		super.checkInputBoxHasValue("workload", workload);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("link", link);

		
	}
	
	@Test
	@Order(20)
	public void showNegative() {		
		super.navigate("anonymous/task/show", "id=20");
		super.checkErrorsExist();

		
	}

}
