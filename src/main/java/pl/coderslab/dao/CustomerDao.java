package pl.coderslab.dao;

import pl.coderslab.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pl.coderslab.services.DBService;

public class CustomerDao {
    public static void addCustomer( Customer customer) {
        String query="INSERT INTO customer VALUES(NULL,'"+customer.getName()+"','"+customer.getSurname()+"','"+customer.getAddress()+
        "','"+customer.getPhone()+"','"+customer.getEmail()+"','"+customer.getBirth_date()+"')";
        int id=DBService.executeUpdateReturnId("car_service",query);
        customer.setId(id);
    }

    public static void editCustomer(Map<String,String> params, int id) {
        Set<String> keys=params.keySet();
        for(String param:keys) {
            String query = "UPDATE customer SET "+param+"='"+params.get(param)+"' WHERE id=" + id;
            DBService.executeUpdate("car_service",query);
        }
    }

    public static void deleteCustomer(Customer customer) {
    String query="DELETE FROM customer WHERE id="+customer.getId();
    DBService.executeUpdate("car_service", query);
    }

    public static List<Customer> loadAll(Connection conn) throws SQLException {
        List<Customer> customers = new ArrayList<Customer>();
        String sql = "SELECT * FROM customer";
        PreparedStatement preparedStatement;
        preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Customer loadedCustomer = new Customer();
            loadedCustomer.setId(resultSet.getInt("id"));
            loadedCustomer.setName(resultSet.getString("name"));
            loadedCustomer.setSurname(resultSet.getString("surname"));
            loadedCustomer.setAddress(resultSet.getString("address"));
            loadedCustomer.setPhone(resultSet.getString("phone"));
            loadedCustomer.setEmail(resultSet.getString("email"));
            loadedCustomer.setBirth_date(resultSet.getString("birth_date"));

            customers.add(loadedCustomer);
        }
        return customers;
    }



}
