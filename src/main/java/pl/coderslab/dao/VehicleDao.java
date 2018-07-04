package pl.coderslab.dao;

import pl.coderslab.model.Vehicle;
import pl.coderslab.services.DBService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VehicleDao {
    public static void addVehicle( Vehicle vehicle) {
        String query="INSERT INTO vehicle VALUES(NULL,'"+vehicle.getBrand()+"','"+vehicle.getModel()+"','"+vehicle.getProduction_year()+
                "','"+vehicle.getRegistration_number()+"','"+vehicle.getNext_service()+"',"+vehicle.getCustomer_id()+"')";
        int id=DBService.executeUpdateReturnId("car_service",query);
        vehicle.setId(id);
    }

    public static void editVehicle(Map<String,String> params, int id) {
        Set<String> keys=params.keySet();
        for(String param:keys) {
            String query = "UPDATE vehicle SET "+param+"='"+params.get(param)+"' WHERE id=" + id;
            DBService.executeUpdate("car_service",query);
        }
    }

    public static void deleteCustomer(Vehicle vehicle) {
        String query="DELETE FROM vehicle WHERE id="+vehicle.getId();
        DBService.executeUpdate("car_service", query);
    }

    public static List<Vehicle> loadAll() throws SQLException {
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        String query = "SELECT * FROM vehicle";
        ResultSet resultSet = DBService.executeSelectQuery("car_service",query);
        while (resultSet.next()) {
            Vehicle loadedVehicle = new Vehicle();
            loadedVehicle.setId(resultSet.getInt("id"));
            loadedVehicle.setBrand(resultSet.getString("brand"));
            loadedVehicle.setModel(resultSet.getString("model"));
            loadedVehicle.setProduction_year(resultSet.getString("production_year"));
            loadedVehicle.setRegistration_number(resultSet.getString("registration_number"));
            loadedVehicle.setNext_service(resultSet.getString("next_service"));
            loadedVehicle.setCustomer_id(resultSet.getInt("customer_id"));
            vehicles.add(loadedVehicle);
        }
        return vehicles;
    }

    public static Vehicle loadById(int id) throws SQLException {
        Vehicle loadedVehicle = new Vehicle();
        String query = "SELECT * FROM vehicle WHERE id="+id;
        ResultSet resultSet = DBService.executeSelectQuery("car_service",query);
        while (resultSet.next()) {
            loadedVehicle.setId(resultSet.getInt("id"));
            loadedVehicle.setBrand(resultSet.getString("brand"));
            loadedVehicle.setModel(resultSet.getString("model"));
            loadedVehicle.setProduction_year(resultSet.getString("production_year"));
            loadedVehicle.setRegistration_number(resultSet.getString("registration_number"));
            loadedVehicle.setNext_service(resultSet.getString("next_service"));
            loadedVehicle.setCustomer_id(resultSet.getInt("customer_id"));
        }
        return loadedVehicle;
    }
}
