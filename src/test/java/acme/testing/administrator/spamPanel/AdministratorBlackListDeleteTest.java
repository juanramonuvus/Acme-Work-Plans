package acme.testing.administrator.spamPanel;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AdministratorBlackListDeleteTest extends AcmePlannerTest{

	/*
	 * A test that checks the "Delete a spam word" functionality, 
	 * for this I log in as an administrator and enter a word deleting 
	 * it and checking that it no longer exists in the database.
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/spamPanel/blacklist-delete.csv", encoding = "utf-8", numLinesToSkip=1)
	@Order(10)
	public void deletePositive(final String word) {
		super.signIn("administrator", "administrator");
		
		super.navigate("/administrator/spamconfig/show", "id=44");
		
		super.checkInputBoxHasValue("word", word);
		
		super.clickOnSubmitButton("Delete");
		
		super.navigate("/administrator/spamconfig/show", "id=44");
		
		super.checkErrorsExist();
		super.signOut();
		
	}
	
	/*
	 * This test checks that a anonymous user cannot delete a word that does not exist.
	 */
	@Test
	@Order(20)
	public void deleteNegative() {
		super.navigate("/administrator/spamconfig/show", "id=45");
		super.checkPanicExists();
	}
	
}
