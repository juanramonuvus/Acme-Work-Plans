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

package acme.testing.anonymous.userAccount;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

import acme.testing.AcmePlannerTest;

public class SignUpTest extends AcmePlannerTest {

	/*
	 * In this test, a new anonymous user is created by going to the "Sing up" 
	 * section and entering all the necessary data to register a user.
	 */
	
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/userAccount/positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveSingUp(final String username, final String password, final String name, final String surname, final String email){
		super.signUp(username, password, name, surname, email, null);
		super.signIn(username, password);
		assert super.exists(By.linkText("Account"));
		super.signOut();
	}
	
	/*
	 * In this test, a new anonymous user is created, accessing the "Sing up" section,
	 *  and entering erroneous data:
	 *  - User name too short or too long
	 *	- Password too short or too long
	 *	- Blank form field
	 *	- Passwords do not match
	 *	- Incorrect email
	 *	- Form submitted blank
	 *	- Do not check the box to accept the license
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/userAccount/negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeSingUp(final Integer recordIndex, final String username, final String password, final String confirmation,
		final String name, final String surname, 
		final String email, final String accept) {
		super.clickOnMenu("Sign up", null);	
		super.fillInputBoxIn("username", username);
		super.fillInputBoxIn("password", password);
		super.fillInputBoxIn("confirmation", confirmation);
		super.fillInputBoxIn("identity.name", name);
		super.fillInputBoxIn("identity.surname", surname);
		super.fillInputBoxIn("identity.email", email);
		if(accept.equals("true")) {
			super.fillInputBoxIn("accept", "true");
		}
		super.clickOnSubmitButton("Sign up");
		
		switch (recordIndex) {
		case 0:
			super.checkErrorsExist("username");
			break;
		case 1:
			super.checkErrorsExist("password");
			break;
		case 2:
			super.checkErrorsExist("identity.name");
			break;
		case 3:
			super.checkErrorsExist("confirmation");
			break;
		case 4:
			super.checkErrorsExist("identity.email");
			break;
		case 5:
			super.checkErrorsExist("username");
			super.checkErrorsExist("password");
			super.checkErrorsExist("identity.name");
			super.checkErrorsExist("identity.surname");
			super.checkErrorsExist("identity.email");
			break;
		case 6:
			super.checkErrorsExist();
		}
		
		super.navigateHome();
	}
}
