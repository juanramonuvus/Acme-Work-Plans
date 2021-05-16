package acme.testing.anonymous.task;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import acme.testing.AcmePlannerTest;

public class AnonymousTaskListTest extends AcmePlannerTest{
	
	// Test cases -------------------------------------------------------------
	
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/task/list-all.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void listPositive(final int index, final String title,
		final String executionStart, final String executionEnd,
		final String workload, final String description, final String link) {		
		
		super.clickOnMenu("Anonymous", "Tasks");
		
		super.checkColumnHasValue(index, 0, title);
		super.checkColumnHasValue(index, 1, executionStart);
		super.checkColumnHasValue(index, 2, executionEnd);
		super.checkColumnHasValue(index, 3, workload);
		super.checkColumnHasValue(index, 4, description);
		super.checkColumnHasValue(index, 5, link);
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/task/list-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void listNegative(final int index, final String title,
		final String executionStart, final String executionEnd,
		final String workload, final String description, final String link) {
		
		super.clickOnMenu("Anonymous", "Tasks");
					
			final List<WebElement> allInputElements = this.driver.findElements(By.tagName("tr")); 
			for(final WebElement inputElement : allInputElements) 
	        	{
				assert !inputElement.getText().contains(title) &&
					!inputElement.getText().contains(executionStart) &&
					!inputElement.getText().contains(executionEnd) &&
					!inputElement.getText().contains(workload) &&
					!inputElement.getText().contains(description) &&
					!inputElement.getText().contains(link);
	   }
	}
}
