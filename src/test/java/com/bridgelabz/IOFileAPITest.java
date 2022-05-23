package com.bridgelabz;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;


import static com.bridgelabz.EmployeePayrollService1.IOService.FILE_IO;


public class IOFileAPITest 
{
	/*private static String HOME=System.getProperty("user.Home");
	private static String PLAY_WITH_NIO="TempPlayGround";
	
	@Test
	public void givenPathWhenCheckedThenConfirm() throws IOException
	{
		//Check File Exists
		Path homePath=Paths.get(HOME);
		Assert.assertTrue(Files.exists(homePath));
		
		//
	}*/
	@Test
	public void given3EmployeeWhenWrittenToFileShouldMatchEmployeeEntries(){
        EmployeePayrollData[] arrayOfEmps = {
                new EmployeePayrollData(1, "dhanashri nerkar", 35000.0),
                new EmployeePayrollData(2, "atharva patil", 50000.0),
                new EmployeePayrollData(3, "nikita patil", 57000.0),

        };
        EmployeePayrollService1 employeePayrollService;
        employeePayrollService = new EmployeePayrollService1(Arrays.asList(arrayOfEmps));
        //UC4:Store Employee Payroll into a file
        employeePayrollService.writeEmplyoeePayrollData(FILE_IO);
        //UC5: to print the Employee payroll file
        employeePayrollService.printData(FILE_IO);
        //UC5:to count number of entries in the file
      
    }
   
}
