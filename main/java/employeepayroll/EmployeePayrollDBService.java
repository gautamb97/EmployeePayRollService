package employeepayroll;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollDBService {

    private Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
        String userName = "root";
        String password = "gautam971997";
        Connection con;
        System.out.println("Connecting to database:"+jdbcURL);
        con = DriverManager.getConnection(jdbcURL, userName, password);
        System.out.println("Connection is successful!!!!");
        return con;
    }

    public List<EmployeePayrollData> readData(){
        String sql = "SELECT * FROM employee_payroll; ";
        List<EmployeePayrollData> emplployeePayrollList = new ArrayList<>();
        try (Connection connection = this.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                LocalDate startDate = resultSet.getDate("start").toLocalDate();
                emplployeePayrollList.add(new EmployeePayrollData(id, name, salary, startDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emplployeePayrollList;
    }

}
