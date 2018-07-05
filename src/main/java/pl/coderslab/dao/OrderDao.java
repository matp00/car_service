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
    public static void addOrder( Order order) {
        String query="INSERT INTO order VALUES(NULL,'"+order.getStatus_id()+"','"+order.getCustomer_id()+"','"+order.getVehicle_id()+
                "','"+order.getProblem_description()+"','"+order.getAcceptance()+"','"+order.getMaintenance_start()+
                "','"+order.getEmployee_id()+"','"+order.getGetMaintenance_description()+"','"+order.getTotal_price()+
                "','"+order.getParts_cost()+"','"+order.getHours_amount()+"')";
        int id=DBService.executeUpdateReturnId("car_service",query);
        order.setId(id);
    }

    public static void editVehicle(Map<String,String> params, int id) {
        Set<String> keys=params.keySet();
        for(String param:keys) {
            String query = "UPDATE order SET "+param+"='"+params.get(param)+"' WHERE id=" + id;
            DBService.executeUpdate("car_service",query);
        }
    }

    public static void deleteCustomer(Order order) {
        String query="DELETE FROM vehicle WHERE id="+order.getId();
        DBService.executeUpdate("car_service", query);
    }

    public static List<Order> loadAll() throws SQLException {
        List<Order> vehicles = new ArrayList<Order>();
        String query = "SELECT * FROM order";
        ResultSet resultSet = DBService.executeSelectQuery("car_service",query);
        while (resultSet.next()) {
            Order loadedOrder = new Order();
            loadedOrder.setId(resultSet.getInt("id"));
            loadedOrder.setStatus_id(resultSet.getInt("status_id"));
            loadedOrder.setCustomer_id(resultSet.getInt("customer_id"));
            loadedOrder.setVehicle_id(resultSet.getInt("vehicle_id"));
            loadedOrder.setProblem_description(resultSet.getString("problem_description"));
            loadedOrder.setAcceptance(resultSet.getString("acceptance"));
            loadedOrder.setMaintenance_start(resultSet.getString("maintenance_start"));
            loadedOrder.setEmployee_id(resultSet.getInt("employee_id"));
            loadedOrder.setGetMaintenance_description(resultSet.getString("maintenance_description"));
            loadedOrder.setTotal_price(resultSet.getDouble("total_price"));
            loadedOrder.setParts_cost(resultSet.getDouble("parts_cost"));
            loadedOrder.setHours_amount(resultSet.getInt("hours_amount"));
            vehicles.add(loadedOrder);
        }
        return vehicles;
    }

    public static Order loadById(int id) throws SQLException {
        Order loadedOrder = new Order();
        String query = "SELECT * FROM order WHERE id="+id;
        ResultSet resultSet = DBService.executeSelectQuery("car_service",query);
        while (resultSet.next()) {
            loadedOrder.setId(resultSet.getInt("id"));
            loadedOrder.setStatus_id(resultSet.getInt("status_id"));
            loadedOrder.setCustomer_id(resultSet.getInt("customer_id"));
            loadedOrder.setVehicle_id(resultSet.getInt("vehicle_id"));
            loadedOrder.setProblem_description(resultSet.getString("problem_description"));
            loadedOrder.setAcceptance(resultSet.getString("acceptance"));
            loadedOrder.setMaintenance_start(resultSet.getString("maintenance_start"));
            loadedOrder.setEmployee_id(resultSet.getInt("employee_id"));
            loadedOrder.setGetMaintenance_description(resultSet.getString("maintenance_description"));
            loadedOrder.setTotal_price(resultSet.getDouble("total_price"));
            loadedOrder.setParts_cost(resultSet.getDouble("parts_cost"));
            loadedOrder.setHours_amount(resultSet.getInt("hours_amount"));
        }
        return loadedOrder;
    }
}
