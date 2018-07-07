package pl.coderslab.dao;

import pl.coderslab.model.Order;
import pl.coderslab.model.Vehicle;
import pl.coderslab.services.DBService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrderDao {
    public static void addOrder( List<String> params) {
        StringBuilder sb= new StringBuilder();
        sb.append("INSERT INTO `order` VALUES(NULL");
        for(int i=0;i<params.size();i++) {
            if(params.get(i).equals("NULL")) {
                sb.append(",null");
                params.remove(i);
            }
            else sb.append(",?");
        }
        sb.append(")");
        String query=sb.toString();
        System.out.println(query);
        DBService.executeUpdate("car_service",query,params);
    }

    public static void editOrder(Map<String,String> params, int id) {
        Set<String> keys=params.keySet();
        for(String param:keys) {
            String query = "UPDATE `order` SET "+param+"=? WHERE id=" + id;
            DBService.executeUpdate("car_service",query,params.get(param));
        }
    }

    public static void deleteOrder(int id) {
        String query="DELETE FROM `order` WHERE id="+id;
        DBService.executeUpdate("car_service", query);
    }

    public static List<Order> loadAll()  {
        List<Order> orders = new ArrayList<Order>();
        String query = "SELECT * FROM `order`";
        try(ResultSet resultSet = DBService.executeQuery(DBService.connect("car_service"),query)) {
            while (resultSet.next()) {
                Order loadedOrder = new Order();
                loadedOrder.setId(resultSet.getInt("id"));
                loadedOrder.setStatus_id(resultSet.getInt("status_id"));
                loadedOrder.setVehicle_id(resultSet.getInt("vehicle_id"));
                loadedOrder.setProblem_description(resultSet.getString("problem_description"));
                loadedOrder.setAcceptance(resultSet.getString("acceptance"));
                loadedOrder.setPlanned_maintenance(resultSet.getString("planned_maintenance"));
                loadedOrder.setMaintenance_start(resultSet.getString("maintenance_start"));
                loadedOrder.setEmployee_id(resultSet.getInt("employee_id"));
                loadedOrder.setMaintenance_description(resultSet.getString("maintenance_description"));
                loadedOrder.setTotal_price(resultSet.getDouble("total_price"));
                loadedOrder.setParts_cost(resultSet.getDouble("parts_cost"));
                loadedOrder.setHours_amount(resultSet.getInt("hours_amount"));
                orders.add(loadedOrder);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return orders;
    }

    public static Order loadById(int id)  {
        Order loadedOrder = new Order();
        String query = "SELECT * FROM `order` WHERE id="+id;
        try(ResultSet resultSet = DBService.executeQuery(DBService.connect("car_service"),query)) {
            while (resultSet.next()) {
                loadedOrder.setId(resultSet.getInt("id"));
                loadedOrder.setStatus_id(resultSet.getInt("status_id"));
                loadedOrder.setVehicle_id(resultSet.getInt("vehicle_id"));
                loadedOrder.setProblem_description(resultSet.getString("problem_description"));
                loadedOrder.setAcceptance(resultSet.getString("acceptance"));
                loadedOrder.setPlanned_maintenance(resultSet.getString("planned_maintenance"));
                loadedOrder.setMaintenance_start(resultSet.getString("maintenance_start"));
                loadedOrder.setEmployee_id(resultSet.getInt("employee_id"));
                loadedOrder.setMaintenance_description(resultSet.getString("maintenance_description"));
                loadedOrder.setTotal_price(resultSet.getDouble("total_price"));
                loadedOrder.setParts_cost(resultSet.getDouble("parts_cost"));
                loadedOrder.setHours_amount(resultSet.getInt("hours_amount"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return loadedOrder;
    }
    public static List<Order> loadAll(String query) throws SQLException {
        List<Order> vehicles = new ArrayList<Order>();

        ResultSet resultSet = DBService.executeQuery(DBService.connect("car_service"),query);
        while (resultSet.next()) {
            Order loadedOrder = new Order();
            loadedOrder.setId(resultSet.getInt("id"));
            loadedOrder.setStatus_id(resultSet.getInt("status_id"));
            loadedOrder.setVehicle_id(resultSet.getInt("vehicle_id"));
            loadedOrder.setProblem_description(resultSet.getString("problem_description"));
            loadedOrder.setAcceptance(resultSet.getString("acceptance"));
            loadedOrder.setMaintenance_start(resultSet.getString("maintenance_start"));
            loadedOrder.setEmployee_id(resultSet.getInt("employee_id"));
            loadedOrder.setMaintenance_description(resultSet.getString("maintenance_description"));
            loadedOrder.setTotal_price(resultSet.getDouble("total_price"));
            loadedOrder.setParts_cost(resultSet.getDouble("parts_cost"));
            loadedOrder.setHours_amount(resultSet.getInt("hours_amount"));
            vehicles.add(loadedOrder);
        }
        return vehicles;
    }
}
