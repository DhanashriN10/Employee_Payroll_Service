package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService1 {
	
	public enum IOService {CONSOLE_IO, FILE_IO}

    private List<EmployeePayrollData> employeePayrollList;

    public  EmployeePayrollService1() {

    }

    public EmployeePayrollService1(List<EmployeePayrollData> emplyeePayrollList) {
        this.employeePayrollList = emplyeePayrollList;
    }

    public static void main(String[] args) {
        System.out.println("**********welcome to Employee Payroll Service**********");
    
        Scanner scanner = new Scanner(System.in);
        ArrayList<EmployeePayrollData> employeePayrollArrayList = new ArrayList<>();
        EmployeePayrollService1 employeePayrollService = new EmployeePayrollService1(employeePayrollArrayList);
        employeePayrollService.readEmplyoeePayrollData(scanner);
        employeePayrollService.writeEmplyoeePayrollData(IOService.CONSOLE_IO);
    }

    private void readEmplyoeePayrollData(Scanner data) {
        System.out.println("Enter your Name:");
        String name = data.nextLine();
        System.out.println("Enter your ID:");
        int id = data.nextInt();
        System.out.println("Enter your salary");
        double salary = data.nextDouble();
        employeePayrollList.add(new EmployeePayrollData(id, name, salary));
    }

    public void writeEmplyoeePayrollData(IOService ioService) {
        if (ioService.equals(IOService.CONSOLE_IO)) {
            System.out.println("\n Writing Employee payroll roster to console" + employeePayrollList);
        } else if (ioService.equals(IOService.FILE_IO)) {
            new EmployeeFileIOService().writeData(employeePayrollList);

        }
    }
    public long readEmployeePayrollData(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO)) {
            this.employeePayrollList = new EmployeeFileIOService().readData();
            //new EmployeePayrollFileIOService().countEntries();
            return employeePayrollList.size();
        }

        return 0;
    }
    public void printData(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO)) {
            new EmployeeFileIOService().printdata();
        }
    }

  

}
