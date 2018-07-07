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

public class VehicleDao {
    public static void editVehicle( Map<String,String> params, int id) {
        Set<String> keys=params.keySet();
        for(String param:keys) {
            String query = "UPDATE vehicle SET "+param+"=? WHERE id=" + id;
            DBService.executeUpdate("car_service",query,params.get(param));
        }
    }

    public static void addVehicle(List<String> params) {
        StringBuilder sb= new StringBuilder();
        sb.append("INSERT INTO vehicle VALUES(NULL");
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

    public static void deleteVehicle(int id) {
        String query="DELETE FROM vehicle WHERE id="+id;
        DBService.executeUpdate("car_service", query);
    }

    public static List<Vehicle> loadAll()  {
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        String query = "SELECT * FROM vehicle";
        try(ResultSet resultSet = DBService.executeQuery(DBService.connect("car_service"),query)) {
            while (resultSet.next()) {
                Vehicle loadedVehicle = new Vehicle();
                loadedVehicle.setId(resultSet.getInt("id"));
                loadedVehicle.setBrand(resultSet.getString("brand"));
                loadedVehicle.setModel(resultSet.getString("model"));
                loadedVehicle.setProduction_year(resultSet.getInt("production_year"));
                loadedVehicle.setRegistration_number(resultSet.getString("registration_number"));
                loadedVehicle.setNext_service(resultSet.getString("next_service"));
                loadedVehicle.setCustomer_id(resultSet.getInt("customer_id"));
                vehicles.add(loadedVehicle);
            }
        }catch (SQLException e){
            System.out.println(e);
            System.out.println("Error in loadAll in VehicleDao");
        }
        return vehicles;
    }

    public static Vehicle loadById(int id) throws SQLException {
        Vehicle loadedVehicle = new Vehicle();
        String query = "SELECT * FROM vehicle WHERE id="+id;
        try(ResultSet resultSet = DBService.executeQuery(DBService.connect("car_service"),query)) {
            while (resultSet.next()) {
                loadedVehicle.setId(resultSet.getInt("id"));
                loadedVehicle.setBrand(resultSet.getString("brand"));
                loadedVehicle.setModel(resultSet.getString("model"));
                loadedVehicle.setProduction_year(resultSet.getInt("production_year"));
                loadedVehicle.setRegistration_number(resultSet.getString("registration_number"));
                loadedVehicle.setNext_service(resultSet.getString("next_service"));
                loadedVehicle.setCustomer_id(resultSet.getInt("customer_id"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return loadedVehicle;
    }

    public static void addCustomer (int vehicleId, int customerId){
        String query="UPDATE vehicle SET customer_id="+customerId+"WHERE id="+vehicleId;
        DBService.executeUpdate("car_service",query);
        }

     public static Order loadRepairHistory(int id) throws SQLException {
         String query="SELECT * FROM order WHERE vehicle_id="+id;
         Order loadedOrder = new Order();
         ResultSet resultSet = DBService.executeSelectQuery("car_service",query);
         while (resultSet.next()) {
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
         }
         return loadedOrder;
     }
}
