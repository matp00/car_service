package pl.coderslab.dao;

import pl.coderslab.model.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pl.coderslab.model.Vehicle;
import pl.coderslab.services.DBService;

public class CustomerDao {
    public static void addCustomer( List<String> params) {
        StringBuilder sb= new StringBuilder();
        sb.append("INSERT INTO customer VALUES(NULL");
        for(int i=0;i<params.size();i++) {
            if(params.get(i).equals("NULL")) {
                sb.append(",null");
                params.remove(i);
            }
            else sb.append(",?");
        }
        sb.append(")");
        String query=sb.toString();
        DBService.executeUpdate("car_service",query,params);

    }

    public static void editCustomer(Map<String,String> params, int id) {
        Set<String> keys=params.keySet();
        for(String param:keys) {
            String query = "UPDATE customer SET "+param+"=? WHERE id=" + id;
            DBService.executeUpdate("car_service",query,params.get(param));
        }
    }

    public static void deleteCustomer(int id) {
    String query="DELETE FROM customer WHERE id="+id;
    DBService.executeUpdate("car_service", query);
    }

    public static List<Customer> loadAll()  {
        List<Customer> customers = new ArrayList<Customer>();
        String query = "SELECT * FROM customer";
        try(ResultSet resultSet = DBService.executeQuery(DBService.connect("car_service"),query)) {
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
        }catch (SQLException e){
            System.out.println(e);
            System.out.println("Error in loadAllCustomer");
        }
        return customers;
    }

    public static Customer loadById(int id)  {
        Customer loadedCustomer = new Customer();
        String query = "SELECT * FROM customer WHERE id="+id;
        try(ResultSet resultSet = DBService.executeQuery(DBService.connect("car_service"),query)) {
            while (resultSet.next()) {
                loadedCustomer.setId(resultSet.getInt("id"));
                loadedCustomer.setName(resultSet.getString("name"));
                loadedCustomer.setSurname(resultSet.getString("surname"));
                loadedCustomer.setAddress(resultSet.getString("address"));
                loadedCustomer.setPhone(resultSet.getString("phone"));
                loadedCustomer.setEmail(resultSet.getString("email"));
                loadedCustomer.setBirth_date(resultSet.getString("birth_date"));
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return loadedCustomer;
    }

    public static List<Customer> loadBySurname(String surname) throws SQLException {
        List<Customer> customers = new ArrayList<Customer>();
        String query = "SELECT * FROM customer WHERE surname="+surname;
        ResultSet resultSet = DBService.executeSelectQuery("car_service",query);
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

    public static List<Vehicle> loadCustomersVehicle (int id) throws SQLException {
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        String query = "SELECT id,brand,model,production_year,registration_number," +
                "next_service FROM vehicle  WHERE customer_id="+id;
        ResultSet resultSet = DBService.executeSelectQuery("car_service",query);
        while (resultSet.next()) {
            Vehicle loadedVehicle = new Vehicle();
            loadedVehicle.setId(resultSet.getInt("id"));
            loadedVehicle.setBrand(resultSet.getString("brand"));
            loadedVehicle.setModel(resultSet.getString("model"));
            loadedVehicle.setProduction_year(resultSet.getInt("production_year"));
            loadedVehicle.setRegistration_number(resultSet.getString("registration_number"));
            loadedVehicle.setNext_service(resultSet.getString("next_service"));
            //loadedVehicle.setCustomer_id(resultSet.getInt("customer_id"));
            vehicles.add(loadedVehicle);
        }
        return vehicles;
    }



}
