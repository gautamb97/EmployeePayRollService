package employeepayroll;

public class EmployeePayrollData {
    String employeeName;
    int employeeID;
    double employeeSalary;

    public EmployeePayrollData(int employeeID,String employeeName,double employeeSalary) {
        this.employeeName = employeeName;
        this.employeeID = employeeID;
        this.employeeSalary = employeeSalary;
    }

    @Override
    public String toString() {
        return "Employee Id: '" + employeeID + '\'' + ", Employee Name: " + employeeName + ", Employee Salary: " + employeeSalary;
    }
}
