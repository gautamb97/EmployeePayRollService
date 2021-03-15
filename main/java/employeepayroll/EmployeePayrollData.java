package employeepayroll;

import java.time.LocalDate;

public class EmployeePayrollData {
    String employeeName;
    int employeeID;
    double employeeSalary;
    public LocalDate startDate;

    public EmployeePayrollData(int employeeID,String employeeName,double employeeSalary) {
        this.employeeName = employeeName;
        this.employeeID = employeeID;
        this.employeeSalary = employeeSalary;
    }

    public EmployeePayrollData(int id, String name, double salary, LocalDate startDate) {
        this(id, name, salary);
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Employee Id: '" + employeeID + '\'' + ", Employee Name: " + employeeName + ", Employee Salary: " + employeeSalary;
    }
}
