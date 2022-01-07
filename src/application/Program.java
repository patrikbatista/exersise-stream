package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.entites.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		String email;
		String name;
		Double salary;
		Double salaryVerify;

		List<Employee> list = new ArrayList<>();

		for (int i = 0; i < 5; i++) {

			System.out.print("Name: ");
			name = sc.next();

			System.out.print("Email: ");
			email = sc.next();

			System.out.print("Salary: ");
			salary = sc.nextDouble();

			list.add(new Employee(name, email, salary));

		}
		
		System.out.print("Enter salary: ");
		salaryVerify = sc.nextDouble();
		
		List<String> emailList = list.stream()
							.filter(x -> x.getSalary() > salaryVerify)
							.map(x -> x.getEmail())
							.sorted()
							.collect(Collectors.toList());
		
		System.out.println("Email of people whose salary is more than " + String.format("%.2f", salaryVerify) + ":");
		emailList.forEach(System.out::println);
		
		double sum = list.stream()
						.filter(x -> x.getName().charAt(0) == 'M')
						.map(x -> x.getSalary())
						.reduce(0.0, (x,y) -> x + y);
		
		System.out.println("Sum of salary from people whose name starts with 'M': " + String.format("%.2f", sum));
		

		sc.close();

	}
}
