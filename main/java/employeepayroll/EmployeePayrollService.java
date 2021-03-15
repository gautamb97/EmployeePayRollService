package employeepayroll;

import java.util.*;

public class EmployeePayrollService {
    public EmployeePayrollService() {

    }

    public enum IOService{CONSOLE_IO,FILE_IO,DB_IO,REST_IO}

    public List<EmployeePayrollData> employeePayrollList;

    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList){
        this.employeePayrollList=employeePayrollList;
    }

    public void readEmployeeData(IOService ioService){
        if (ioService.equals(IOService.CONSOLE_IO)) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter Employee Name");
            String empName = scan.next();
            System.out.println("Enter Employee ID");
            int empID = scan.nextInt();
            System.out.println("Enter Employee Salary");
            int empSalary = scan.nextInt();

            EmployeePayrollData adder = new EmployeePayrollData(empID, empName, empSalary);
            employeePayrollList.add(adder);
        }else if (ioService.equals(IOService.FILE_IO)){
            new EmployeePayrollFileIOService().readData();
        }
    }

    public List<EmployeePayrollData> readEmployeePayrollData(IOService ioService) {
        if(ioService.equals(IOService.DB_IO))
            this.employeePayrollList = new EmployeePayrollDBService().readData();
        return this.employeePayrollList;
    }

    public void writeEmployeeData(IOService ioService){
        if (ioService.equals(IOService.CONSOLE_IO))
            System.out.println("OutPut\n"+employeePayrollList);
        else if (ioService.equals(IOService.FILE_IO))
            new EmployeePayrollFileIOService().writeData(employeePayrollList);
    }

    public void printEmployeeData(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            new EmployeePayrollFileIOService().printData();
    }

    public long countEntries(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            return new EmployeePayrollFileIOService().countEntries();
        return 0;
    }

    public static void main(String[] args) {
        ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
        employeePayrollService.readEmployeeData(IOService.FILE_IO);
        employeePayrollService.writeEmployeeData(IOService.FILE_IO);
    }

}
