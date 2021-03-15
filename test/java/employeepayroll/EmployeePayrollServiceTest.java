package employeepayroll;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class EmployeePayrollServiceTest {
    @Test
    void given3EmpWhenWrittenToFilesShouldMatchEmpEntries() {
        EmployeePayrollData[] arrayOfEmp={
                new EmployeePayrollData(1,"Jeff Bezos",10000.0),
                new EmployeePayrollData(2,"Bill Gates",20000.0),
                new EmployeePayrollData(3,"Mark",150000.0),
        };
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmp));
        employeePayrollService.empWriteData(EmployeePayrollService.IOService.FILE_IO);
        employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
        long result = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        Assert.assertEquals(3,result);
    }
}
