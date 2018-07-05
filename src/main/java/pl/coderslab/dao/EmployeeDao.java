package pl.coderslab.dao;

import com.mysql.cj.xdevapi.SqlDataResult;
import pl.coderslab.model.Employee;
import pl.coderslab.services.DBService;

import javax.swing.text.html.HTMLDocument;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeDao {

    private String databaseName = "car_service";

    public void addEmployee(Employee employee){

        //dopisze do bazy

        String query = "Insert into employee Values (?,?,?,?,?,?,?,?,?)";

        List<String> queryParams = new ArrayList<>();
        queryParams.add( String.valueOf(employee.getId()) );
        queryParams.add(employee.getName());
        queryParams.add(employee.getSurname());
        queryParams.add(employee.getAddress());
        queryParams.add(employee.getPhone()+"");
        queryParams.add(employee.getNote());
        queryParams.add(employee.getHourly()+"");
        queryParams.add(employee.getEmail());
        queryParams.add(employee.getBirthDate());

        DBService.executeUpdate(this.databaseName, query, queryParams);
    }

    public void editEmployee(Employee employee){

        String query = "UPDATE employee SET name=?,surname=?,address=?,phone=?,note=?,hourly=?,email=?,birth_date=? WHERE id=?";

        List<String> queryParams = new ArrayList<>();

        queryParams.add(employee.getName());
        queryParams.add(employee.getSurname());
        queryParams.add(employee.getAddress());
        queryParams.add(employee.getPhone()+"");
        queryParams.add(employee.getNote());
        queryParams.add(employee.getHourly()+"");
        queryParams.add(employee.getEmail());
        queryParams.add(employee.getBirthDate());
        queryParams.add( String.valueOf(employee.getId()) );

        DBService.executeUpdate(this.databaseName, query, queryParams);
    }

    public int getId(){

        try(Connection conn = DBService.connect(this.databaseName)){
            PreparedStatement prep = conn.prepareStatement("SELECT * FROM employee;");
            ResultSet rs = prep.executeQuery();
            return DBService.numberOfRows(rs);

        }catch (SQLException e){
            System.out.println("Error Connection to database getID() from Employee");
        }

        return 0;
    }

    public List<Employee> loadAll(){

            List<Employee> employeeList = new ArrayList<>();

            String query = "SELECT * FROM employee";

            try(ResultSet rs = DBService.executeQuery(DBService.connect(this.databaseName), query)){

                while (rs.next()) {

                    employeeList.add(new Employee(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getString("address"),
                            rs.getInt("phone"),
                            rs.getString("note"),
                            rs.getDouble("hourly"),
                            rs.getString("email"),
                            rs.getString("birth_date"))
                   );

                }
            }catch (SQLException e){
                System.out.println("Error in loadAll in EmployeeDao");
            }

            System.out.println("");

        return employeeList;
    }

    public Employee getEmployeeById(int id){
        String query = "SELECT * FROM employee WHERE id="+id;
        Employee employee;
        try(ResultSet rs = DBService.executeQuery(DBService.connect(this.databaseName), query)){

            while (rs.next()) {

                employee = (new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("address"),
                        rs.getInt("phone"),
                        rs.getString("note"),
                        rs.getDouble("hourly"),
                        rs.getString("email"),
                        rs.getString("birth_date"))
                );
                return employee;
            }
        }catch (SQLException e){
            System.out.println("Error in loadAll in EmployeeDao");
        }
        return employee = null;
    }

    public void delete(int id){

        String query = "DELETE FROM employee WHERE id="+id;

        try {
            DBService.executeUpdate(this.databaseName, query);
        }catch (Exception e){
            System.out.println("No element in tab (Employee->delete)");
        }

    }


}
