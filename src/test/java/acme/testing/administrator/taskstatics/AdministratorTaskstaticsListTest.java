package acme.testing.administrator.taskstatics;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AdministratorTaskstaticsListTest extends AcmePlannerTest{
	
	/* 
	 * This test signs in as administrator, navigates into the dashboard and checks statistic values.
	*/
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/taskstatics/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void listPositive(final String publictasks,final String privatetasks,final String finishedtasks,
		final String nonfinishedtasks,final String averageworkload,final String minimumworkload,
		final String maximumworkload,final String workloaddeviation,final String averageexecutionperiod,
		final String minimumexecutionperiod,final String maximumexecutionperiod,final String executionperioddeviation) {		
		
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Dashboard");
		
		super.checkColumnHasValue(0, 0, publictasks);
		super.checkColumnHasValue(0, 1, privatetasks);
		super.checkColumnHasValue(0, 2, finishedtasks);
		super.checkColumnHasValue(0, 3, nonfinishedtasks);
		super.checkColumnHasValue(0, 4, averageworkload);
		super.checkColumnHasValue(0, 5, minimumworkload);
		super.checkColumnHasValue(0, 6, maximumworkload);
		super.checkColumnHasValue(0, 7, workloaddeviation);
		super.checkColumnHasValue(0, 8, averageexecutionperiod);
		super.checkColumnHasValue(0, 9, minimumexecutionperiod);
		super.checkColumnHasValue(0, 10, maximumexecutionperiod);
		super.checkColumnHasValue(0, 11, executionperioddeviation);
	}
	
	
	/* 
	 * This test tries to navigate into the dashboard and checks statistic values.
	 * An error must rise because the user is not authorized (anonymous)
	*/
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/taskstatics/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void listNegative() {		
		
		super.navigate("/administrator/dashboard/list","");
		super.checkErrorsExist();
	}
	
	
	

}

