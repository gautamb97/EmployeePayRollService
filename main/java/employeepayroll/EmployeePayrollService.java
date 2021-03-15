package employeepayroll;

import java.util.*;

public class EmployeePayrollService {
    public enum IOService {CONSOLE_IO, FILE_IO, DB_IO, REST_IO}
    private List<EmployeePayroll> employeePayrollList;

    public EmployeePayrollService(){

    }

    public EmployeePayrollService(List<EmployeePayroll>employeePayrollList){
        this.employeePayrollList = employeePayrollList;
    }
    private void writeEmployeePayrollData(){
        System.out.println("\nWriting Employee Payroll Roaster to Console\n" + employeePayrollList);
    }

    private void readEmployeePayrollData(Scanner consoleInputReader){
        System.out.println("Enter Employee ID: ");
        int employeeId = consoleInputReader.nextInt();
        System.out.println("Enter Employee Name: ");
        String employeeName = consoleInputReader.next();
        System.out.println("Enter Employee Salary: ");
        double employeeSalary = consoleInputReader.nextDouble();
        employeePayrollList.add(new EmployeePayroll(employeeId, employeeName, employeeSalary));
    }

    public static void main (String[] args){
        ArrayList<EmployeePayroll> employeePayrollList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData();
    }

}
