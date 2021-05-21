package acme.testing.administrator.userAccount;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AdministratorListUserAccountTest extends AcmePlannerTest{
	
	/* 
	 * This test signs in as administrator, navigates into the user accounts list and 
	 * check all the rows in the table.
	*/
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/userAccount/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void listPositive(final int index, final String username,
		final String name, final String surname) {		
		
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "User accounts");
		
		super.checkColumnHasValue(index, 0, username);
		super.checkColumnHasValue(index, 1, name);
		super.checkColumnHasValue(index, 2, surname);
	}
	
	/* 
	 *  
	 * check all the rows in the table.
	*/
	@Test
	@Order(20)
	public void listNegative() {
		
		super.navigate("administrator/user-account/list","");
		super.checkErrorsExist();
		
	}
	
	

}
