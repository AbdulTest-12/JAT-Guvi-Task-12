package task12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class javaconnectivity {

    public static void main(String[] args) throws SQLException {
        String db_url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "root";

      
        Connection connection = DriverManager.getConnection(db_url, username, password);
        
        String create_db = "create database employee_datas";
        
        String use_db = "use employee_datas";
    
        String create_table = "create table employee (" + "empcode int primary key, " + "empname varchar(10), " +    "empage int, " + "empsalary int)";

        String insert = "insert into employee (empcode, empname, empage, empsalary) VALUES " + "(101, 'Jenny', 25, 10000), " + "(102, 'Jacky', 30, 20000), " + "(103, 'Joe', 20, 40000), " + "(104, 'Jhon', 40, 80000)" + ",(105 ,'Shameer' ,25, 90000)";

        String select = "select * from employee";
        
        Statement stmt = connection.createStatement();
        
        stmt.execute(create_db);
        stmt.execute(use_db);
        stmt.execute(create_table);
        stmt.execute(insert);
        
        ResultSet result = stmt.executeQuery(select);

        while (result.next()) {
            System.out.println(result.getInt("empcode") + " || " + result.getString("empname") + " || " +  result.getInt("empage") + " || " + result.getInt("empsalary"));
        }

        connection.close();
    }
}
