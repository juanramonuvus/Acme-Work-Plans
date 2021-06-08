package acme.testing.administrator.dashboard;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AdministratorDashboardShowTest extends AcmePlannerTest{
	
	/* 
	 * This test signs in as administrator, navigates into the dashboard and checks statistic values.
	*/
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/dashboard/show.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void showPositive(final String publictasks,final String privatetasks,final String finishedtasks,
		final String nonfinishedtasks,final String averageworkload,final String minimumworkload,
		final String maximumworkload,final String workloaddeviation,final String averageexecutionperiod,
		final String minimumexecutionperiod,final String maximumexecutionperiod,final String executionperioddeviation) {		
		
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Dashboard");
		
		super.checkInputBoxHasValue("numberOfPublicTasks", publictasks);
		super.checkInputBoxHasValue("numberOfPrivateTasks", privatetasks);
		super.checkInputBoxHasValue("numberOfFinishedTasks", finishedtasks);
		super.checkInputBoxHasValue("numberOfNonFinishedTasks", nonfinishedtasks);
		super.checkInputBoxHasValue("avarageWorkloads", averageworkload);
		super.checkInputBoxHasValue("minimumWorkloads", minimumworkload);
		super.checkInputBoxHasValue("maximumWorkloads", maximumworkload);
		super.checkInputBoxHasValue("deviationWorkload", workloaddeviation);
		super.checkInputBoxHasValue("avarageExecPeriod", averageexecutionperiod);
		super.checkInputBoxHasValue("minimumExecPeriod", minimumexecutionperiod);
		super.checkInputBoxHasValue("maximumExecPeriod", maximumexecutionperiod);
		super.checkInputBoxHasValue("deviationExecPeriod",executionperioddeviation);
	}
	
	
	/* 
	 * This test tries to navigate into the dashboard and checks statistic values.
	 * An error must rise because the user is not authorized (anonymous)
	*/
	@Test
	@Order(20)
	public void showNegative() {		
		
		super.navigate("/administrator/dashboard/show","");
		super.checkPanicExists();
	}
	
	
	

}

