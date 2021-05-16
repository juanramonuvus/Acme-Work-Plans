/*
 * SignUpTest.java
 *
 * Copyright (C) 2012-2021 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.testing;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

public class SignUpTest extends AcmePlannerTest {

	/*
	 * In this test, a new anonymous user is created by going to the "Sing up" 
	 * section and entering all the necessary data to register a user.
	 */
	
	@ParameterizedTest
	@CsvFileSource(resources = "/sign-up/positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveSingUp(final String username, final String password, final String name, final String surname, final String email){
		super.signUp(username, password, name, surname, email, null);
		super.signIn(username, password);
		assert super.exists(By.linkText("Account"));
		super.signOut();
	}
	
	/*
	 * In this test, a new anonymous user is created, accessing the "Sing up" section,
	 *  and entering erroneous data, so that the system warns us that there are errors in the data entered.
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/sign-up/negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(11)
	public void negativeSingUp(final String username, final String password, final String name, final String surname, final String email) {
		super.navigateHome();
		super.clickOnMenu("Sign up", null);	
		super.fillInputBoxIn("username", username);
		super.fillInputBoxIn("password", password);
		super.fillInputBoxIn("confirmation", password);
		super.fillInputBoxIn("identity.name", name);
		super.fillInputBoxIn("identity.surname", surname);
		super.fillInputBoxIn("identity.email", email);
		super.fillInputBoxIn("accept", "true");
		super.clickOnSubmitButton("Sign up");
		super.checkErrorsExist();
		super.navigateHome();
	}
}
