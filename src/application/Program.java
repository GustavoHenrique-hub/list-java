package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Scanner scanText = new Scanner(System.in);
		Scanner scanNum = new Scanner(System.in);
		List<Employee> employees = new ArrayList<Employee>();
		
		System.out.print("How many employees will be registered: ");
		int n = scanNum.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Employee #" + (i + 1) + ":");
			System.out.print("Id: ");
			Integer id = scanNum.nextInt();
			
			while (hasId(employees, id)) {
				System.out.print("Id already taken. Try again: ");
				id = scanNum.nextInt();
			}
			
			System.out.print("Name: ");
			String name = scanText.nextLine();
			
			System.out.print("Salary: ");
			Double salary = scanNum.nextDouble();
			
			employees.add(new Employee(id, name, salary));
			
		}
		System.out.print("Enter the employee will have salary increase: ");
		Integer id = scanNum.nextInt();
		
		try {
			Employee emp = employees.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
			if (emp == null) {
				System.out.println("This id does not exist!");
			}else {
				System.out.print("Enter the percentage: ");
				Double percentage = scanNum.nextDouble();
				emp.increaseSalary(percentage);
			}
		}catch(Exception e) {
			System.out.print(e);
		}
		
		for(Employee obj : employees) {
			System.out.println(obj);
		}
		
		
		
		
		scanText.close();
		scanNum.close();
	}
	
	public static boolean hasId(List<Employee> employees, Integer id) {
		Employee emp = employees.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		
		if(emp != null) {
			return true;
		}else {
			return false;
		}
		
	}

}
