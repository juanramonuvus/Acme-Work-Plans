/*
 * EmployerApplicationLIstTest.java
 *
 * Copyright (C) 2012-2021 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.testing.anonymous.shout;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

import acme.testing.AcmePlannerTest;

public class AnonymousShoutCreateTest extends AcmePlannerTest {

	
	/* 
	 * This test navigates into a shout create form, as an anonymous  and create a new shout.
	 * There shouldn't be any error, all data matches with restrictions.
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)	
	public void createPositive(final int recordIndex, final String author, final String text, final String info) {		
		super.clickOnMenu("Anonymous", "Create a shout");		
		
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("text", text);
		super.fillInputBoxIn("info", info);
		
		super.clickOnSubmitButton("Shout!");
		
		super.clickOnMenu("Anonymous", "Shouts List");
				
		super.checkColumnHasValue(recordIndex, 1, author);
		super.checkColumnHasValue(recordIndex, 2, text);
		super.checkColumnHasValue(recordIndex, 3, info);
				
	}
	
	/* 
	 * This test navigates into a shout create form, as an anonymous  and try to create a blank shout.
	 * There should be errors:
	 * 	-Author: Length must be between 5 and 25. Must not be blank.
	 * 	-Text: Length must be between 1 and 100. Must not be blank.
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/create-blank.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)	
	public void createNegativeBlank(final int recordIndex, final String author, final String text, final String info) {		
		super.clickOnMenu("Anonymous", "Create a shout");		
		
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("text", text);
		super.fillInputBoxIn("info", info);
		
		super.clickOnSubmitButton("Shout!");				
		
		super.checkErrorsExist("author");
		
		String xpath;
		By locator;
		xpath = String.format("//div[@class='form-group'][textarea[@id='%s'] and div[@class='text-danger']]", "text");
		locator = By.xpath(xpath);
		assert super.exists(locator) : String.format("Length must be between 1 and 100. Must not be blank.");
				
	}
	/* 
	 * This test navigates into a shout create form, as an anonymous  and try to create a shout with errors.
	 * There should be errors:
	 * 	-Author: Length must be between 5 and 25. Must not be blank.
	 * 	-Text: Length must be between 1 and 100. Must not be blank.
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(30)	
	public void createNegative(final int recordIndex, final String author, final String text, final String info) {		
		super.clickOnMenu("Anonymous", "Create a shout");		
		
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("text", text);
		super.fillInputBoxIn("info", info);
		
		super.clickOnSubmitButton("Shout!");				
		
		super.checkErrorsExist("author");
		
		String xpath;
		By locator;
		xpath = String.format("//div[@class='form-group'][textarea[@id='%s'] and div[@class='text-danger']]", "text");
		locator = By.xpath(xpath);
		assert super.exists(locator) : String.format("Length must be between 1 and 100.");
		super.checkErrorsExist("info");
				
	}

}
