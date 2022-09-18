package com.bridgelabz;
import java.time.LocalDate;

public class EmployeePayrollData {
	public Integer id;
	public String name;
	public Double salary;
	public LocalDate startDate;
	public EmployeePayrollData(Integer id,String name,Double salary) {
		this.id=id;
		this.name=name;
		this.salary=salary;
	}
	public EmployeePayrollData(Integer id,String name,Double salary,LocalDate startDate) {
		this(id,name,salary);
		this.startDate=startDate;
	}
	@Override
	public String toString() {
		return "id="+id+", Name='"+name+'\''+", Salary="+salary;
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj==null || getClass()!=obj.getClass()) {
			return false;
		}
		EmployeePayrollData that=(EmployeePayrollData) obj;
		return id==that.id && Double.compare(that.salary,salary)==0 && name.equals(that.name);
	}

}
