package employeepayroll;

public class EmployeePayroll {
    public int employeeId;
    public String employeeName;
    public double employeeSalary;

    public EmployeePayroll(Integer employeeId, String employeeName, Double employeeSalary){
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
    }

    public String toString (){
        return "id = "+employeeId+ ", name = "+employeeName+ ", salary = "+employeeSalary;
    }
}
