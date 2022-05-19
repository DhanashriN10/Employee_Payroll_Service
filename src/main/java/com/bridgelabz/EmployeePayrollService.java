package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService
{
	private List<EmployeePayrollData> employeePayrollList;

	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
		// TODO Auto-generated constructor stub
		this.employeePayrollList=employeePayrollList;
	}



	public static void main(String[] args) 
	{
		System.out.println("**********Welcome To Employee Payroll Service**********");
		
		ArrayList<EmployeePayrollData> employeePayrollList=new ArrayList<EmployeePayrollData>();
		EmployeePayrollService employeePayrollService=new EmployeePayrollService(employeePayrollList);
		Scanner consoleInputReader=new Scanner(System.in);
		employeePayrollService.writeEmployeeData(consoleInputReader);
		employeePayrollService.showData();
	}

	private void showData()
	{
		System.out.println("Employee Data:"+employeePayrollList);
	}


	private void writeEmployeeData(Scanner data) 
	{
		System.out.println("Enter Employee ID:");
		int id=data.nextInt();
		System.out.println("Enter Employee Name");
		String name=data.next();
		System.out.println("Enter Employee Salary");
		double salary=data.nextDouble();

		EmployeePayrollData empData=new EmployeePayrollData(id, name, salary);
		employeePayrollList.add(empData);

	}
}
