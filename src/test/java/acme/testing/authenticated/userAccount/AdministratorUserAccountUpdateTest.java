package acme.testing.authenticated.userAccount;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AdministratorUserAccountUpdateTest extends AcmePlannerTest{

	//Test cases ----------------------------------------------------------------
	
	/*
	 * In this test we check the "Update an administrator" functionality, 
	 * to do this we log in as administrator and go to the "General data" section 
	 * and enter new values, we log out and log in to check that it has been updated successfully.
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/userAccount/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void updatePositive(final String password, final String confirmation, final String name, final String surname, final String email) {
		
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Account", "General data");
		
		super.fillInputBoxIn("password", password);
		super.fillInputBoxIn("confirmation", confirmation);
		super.fillInputBoxIn("identity.name", name);
		super.fillInputBoxIn("identity.surname", surname);
		super.fillInputBoxIn("identity.email", email);		
		
		super.clickOnSubmitButton("Update");
		
		super.signOut();
		super.signIn("administrator", password);
		super.checkLinkExists("Account");
		
		super.clickOnMenu("Account", "General data");
		
		super.checkInputBoxHasValue("identity.name", name);
		super.checkInputBoxHasValue("identity.surname", surname);
		super.checkInputBoxHasValue("identity.email", email);
		
		super.clickOnMenu("Administrator", "Populate DB (initial)");
		super.clickOnMenu("Administrator", "Populate DB (samples)");
		
		super.signOut();
		
	}
	
	/*
	 * In this test we checked that in the following cases the page will not let you update the account either because:
	 *	- The password is too short
	 *	- The passwords do not match
	 *	- It is not a valid email
	 *	- The fields name, surname and email are empty
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/userAccount/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void updateNegative(final String password, final String confirmation, final String name, final String surname, final String email) {
		
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Account", "General data");
		
		super.fillInputBoxIn("password", password);
		super.fillInputBoxIn("confirmation", confirmation);
		super.fillInputBoxIn("identity.name", name);
		super.fillInputBoxIn("identity.surname", surname);
		super.fillInputBoxIn("identity.email", email);		
		
		super.clickOnSubmitButton("Update");
		super.checkErrorsExist();
		super.signOut();
		
	}
	
}
