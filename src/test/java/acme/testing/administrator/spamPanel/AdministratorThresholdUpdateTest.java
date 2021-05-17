package acme.testing.administrator.spamPanel;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AdministratorThresholdUpdateTest extends AcmePlannerTest {

	// Test cases -----------------------------------------------------------------
	
	/*
	 * In this test we log in as administrator and update the threshold, verifying that it has indeed been updated.
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/spamPanel/threshold.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void updatePositive(final int recordIndex, final String threshold) {
		final String newThreshold = "30.0";
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Administrator", "Spam settings");
		super.clickOnListingRecord(recordIndex);
		
		super.checkInputBoxHasValue("threshold", threshold);
		
		super.fillInputBoxIn("threshold", newThreshold);
		super.clickOnSubmitButton("Update");
		
		super.clickOnListingRecord(recordIndex);
		super.checkInputBoxHasValue("threshold", newThreshold);
	
		super.signOut();
		
		//For security reasons we restore the database again.
			this.signIn("administrator", "administrator");
			super.clickOnMenu("Administrator", "Populate DB (initial)");
			super.clickOnMenu("Administrator", "Populate DB (samples)");
			super.checkAlertExists(true);		
			this.signOut();
		
	}
	
	/*
	 * In this test we log in as administrator and update the threshold, but we enter a value above 100. 
	 * This way we check that we cannot enter a value above 100. 
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/spamPanel/threshold.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void updateNegative(final int recordIndex, final String threshold) {
		final String newThreshold = "105.0";
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Administrator", "Spam settings");
		super.clickOnListingRecord(recordIndex);
		
		super.checkInputBoxHasValue("threshold", threshold);
		
		super.fillInputBoxIn("threshold", newThreshold);
		super.clickOnSubmitButton("Update");
		super.checkErrorsExist();
		
		super.signOut();
		
	}
}
