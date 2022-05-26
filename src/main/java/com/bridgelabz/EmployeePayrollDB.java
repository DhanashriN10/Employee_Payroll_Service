package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollDB {

	  private PreparedStatement employeePayrollDataStatement;
	    private static EmployeePayrollDB employeePayrollDBService;
	    private EmployeePayrollDB(){
	    }
	    
	 // UC 2
	    private List<EmployeePayrollData> getEmployeePayrollDataUsingDB(String sql) {
	        List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
	        try {
	            Connection connection = this.getConnection();
	            PreparedStatement statement = connection.prepareStatement(sql);
	            ResultSet resultSet = statement.executeQuery();
	            employeePayrollList = this.getEmployeePayrollData(resultSet);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return employeePayrollList;
	    }
	private Connection getConnection() throws SQLException {
			// TODO Auto-generated method stub
		String jdbcURL = "jdbc:mysql://localhost:3306/payroll_services?characterEncoding=utf8";
        String userName = "root";
        String passWord = "root";
        Connection connection;
        System.out.println("Connecting to database"+jdbcURL);
        connection = DriverManager.getConnection(jdbcURL,userName,passWord);
        System.out.println("Connection is successful!!"+connection);
        return connection;
    
		}

		// UC 2
	    private List<EmployeePayrollData> getEmployeePayrollData(ResultSet resultSet) {
	        List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
	        try{
	            while (resultSet.next()){
	                int id = resultSet.getInt("id");
	                String name = resultSet.getString("name");
	                double salary = resultSet.getDouble("salary");
	                LocalDate startDate = resultSet.getDate("start").toLocalDate();
	                //employeePayrollList.add(new EmployeePayrollData(id, name, salary, startDate));
	                employeePayrollList.add(new EmployeePayrollData(id, name,salary, startDate));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return employeePayrollList;
	    }

	    private void prepareStatementForEmployeeData() {
	        try {
	            Connection connection = this.getConnection();
	            String sql = "SELECT * FROM employee_payroll WHERE name = ?";
	            employeePayrollDataStatement = connection.prepareStatement(sql);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }


}
