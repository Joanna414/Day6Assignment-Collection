package com.montran.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.montran.pojo.Employee;
import com.montran.util.EmployeeCollectionUtil;

public class EmployeeMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EmployeeCollectionUtil util = new EmployeeCollectionUtil();
		List<Employee> employeeList = new ArrayList<Employee>();
		Employee employee;
		Employee[] aaraay;
		int employeeId;
		String name;
		double salary;
		int choice;
		boolean result;
		int numberOfEmployee;
		double newSalary;
		String contchoice;

		do {
			employeeList = util.getAllEmployees();

			for (Employee emptemp : employeeList) {
				if (emptemp != null) {
					System.out.println(emptemp.getEmployeeId() + "\t" + emptemp.getName() + "\t" + emptemp.getSalary());
				} else {
					System.out.println("No Employee Found");
				}
			}
			System.out.println("Menu");
			System.out.println("1. Add Single Employee	");
			System.out.println("2. Add Multiple Employee");
			System.out.println("3. Update Existing Employee Salary");
			System.out.println("4. Delete Existing Employee");
			System.out.println("5. Print Single Employee Details");
			System.out.println("6. Exit");

			System.out.println("Enter your choice");
			choice = scanner.nextInt();

			switch (choice) {
			case 1: {

				System.out.println("Enter employeeId");
				employeeId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter Name");
				name = scanner.nextLine();

				System.out.println("Enter Salary");
				salary = scanner.nextDouble();

				employee = new Employee(employeeId, name, salary);
				result = util.addNewEmployee(employee);

				if (result)
					System.out.println("Employee is added successfully !!");
				else
					System.out.println("Fail to add employee");
				break;
			}
			case 2: {
				System.out.println("How many employees do you want to add ?");
				numberOfEmployee = scanner.nextInt();
				aaraay = new Employee[numberOfEmployee];
				for (int i = 0; i < numberOfEmployee; i++) {
					System.out.println("Enter employeeId");
					employeeId = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter Name");
					name = scanner.nextLine();
					System.out.println("Enter Salary");
					salary = scanner.nextDouble();
					employee = new Employee(employeeId, name, salary);
					aaraay[i] = employee;
				}
				result = util.addAllEmployees(aaraay);
				if (result)
					System.out.println("Employee is added successfully !!");
				else
					System.out.println("Fail to add employee");
				break;
			}
			case 3: {
				System.out.println("Enter EmployeeId");
				employeeId = scanner.nextInt();
				employee = util.getEmployeeByEmployeeId(employeeId);
				if (employee != null) {
					System.out.println(employee);
					System.out.println("Enter new Salary");
					newSalary = scanner.nextDouble();

					result = util.updateEmployeeSalary(employeeId, newSalary);
					if (result)
						System.out.println("Employee salary is updated successfully !!");
					else
						System.out.println("Failed to update Salary ");
				} else
					System.out.println("No Employee Found !!");
				break;
			}

			case 4: {
				System.out.println("Enter EmployeeId");
				employeeId = scanner.nextInt();
				result= util.deleteEmployee(employeeId);
				System.out.println(result);
					if (result)
						System.out.println("Employee entry is deleted successfully !!");
					else
						System.out.println("Failed to delete employee ");
			 
				break;
			}
			case 5: {
				System.out.println("Enter EmployeeId");
				employeeId = scanner.nextInt();
				employee = util.getEmployeeByEmployeeId(employeeId);
				if (employee != null) {
					System.out.println(employee);
				} else {
					System.out.println("Employee not found");
				}
				break;
			}
			case 6: {
				System.out.println("Thank you");
				System.exit(0);
				break;
			}
			default:
				System.out.println("Invalid choice");
				break;
			}
			System.out.println("Do you want to continue yes- no ??");
			contchoice = scanner.next();
		}while(contchoice.equals("yes"));System.out.println("Thank you");
}}
