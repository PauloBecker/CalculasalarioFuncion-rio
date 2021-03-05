package application;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner tc = new Scanner(System.in);
		
		ArrayList<Employee> list = new ArrayList<>();
		
		System.out.print("Enter the number of employees: ");
		int n = tc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			
			System.out.println("Employee #" + i + " data:");
			System.out.print("Outsourced (y/n)? ");
			int out = tc.next().charAt(0);
			System.out.print("Name: ");
			tc.nextLine();
			String name = tc.nextLine();
			System.out.println("Hours: ");
			Integer hours = tc.nextInt();
			System.out.println("Value per hour: ");
			Double valuePerHour = tc.nextDouble();
			
			if(out == 'y') {
				
				System.out.print("additional charge: ");
				double additionalCharge = tc.nextDouble();
				list.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
			}else {
				list.add(new Employee(name, hours, valuePerHour));
				
			}
			
			System.out.println();
			System.out.println("PAYMENTS: ");
			for(Employee emp: list) {
				
				System.out.println(emp.getName() + " $ " + String.format("%.2f", emp.payment()));
			}
		}
	
		tc.close();
		
	}

}
