package com.bridgelabz;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollFileIOService {
	public static final String PAYROLL_FILE_NAME="payrollFile.txt";
	public void writeData(List<EmployeePayrollData> employeePayrollList) {
		StringBuffer empBuffer=new StringBuffer();
		employeePayrollList.forEach(employee->{
			String employeeDataString=employee.toString().concat("\n");
			empBuffer.append(employeeDataString);
		});
		try {
			Files.write(Paths.get(PAYROLL_FILE_NAME),empBuffer.toString().getBytes());
			} catch(IOException e) {
				e.printStackTrace();
		}
	}
	public List<String> readData() {
		List<String> employeePayrollList=new ArrayList<>();
		try {
			Files.lines(new File(PAYROLL_FILE_NAME).toPath())
			.map(line->line.trim())
			.forEach(line->employeePayrollList.add(line));
		} catch(IOException e) {
			e.printStackTrace();
		}
		return employeePayrollList;
	}
	public void printdata() {
		try {
			Files.lines(new File(PAYROLL_FILE_NAME).toPath())
			.forEach(System.out::println);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public long countEntries() {
		long entry=0;
		try {
			entry=Files.lines(new File(PAYROLL_FILE_NAME).toPath())
				  .count();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return entry;
	}

}
