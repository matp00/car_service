package pl.coderslab.model;

public class Order {
    private int id=0;
    private int status_id;
    private int customer_id;
    private int vehicle_id;
    private String problem_description;
    private String acceptance;
    private String maintenance_start;
    private int employee_id;
    private String getMaintenance_description;
    private double total_price;
    private double parts_cost;
    private int hours_amount;

    public Order() {
    }

    public Order(int status_id, int customer_id, int vehicle_id, String problem_description, String acceptance,
                 String maintenance_start, int employee_id, String getMaintenance_description, double total_price,
                 double parts_cost, int hours_amount) {
        this.status_id = status_id;
        this.customer_id = customer_id;
        this.vehicle_id = vehicle_id;
        this.problem_description = problem_description;
        this.acceptance = acceptance;
        this.maintenance_start = maintenance_start;
        this.employee_id = employee_id;
        this.getMaintenance_description = getMaintenance_description;
        this.total_price = total_price;
        this.parts_cost = parts_cost;
        this.hours_amount = hours_amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getProblem_description() {
        return problem_description;
    }

    public void setProblem_description(String problem_description) {
        this.problem_description = problem_description;
    }

    public String getAcceptance() {
        return acceptance;
    }

    public void setAcceptance(String acceptance) {
        this.acceptance = acceptance;
    }

    public String getMaintenance_start() {
        return maintenance_start;
    }

    public void setMaintenance_start(String maintenance_start) {
        this.maintenance_start = maintenance_start;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getGetMaintenance_description() {
        return getMaintenance_description;
    }

    public void setGetMaintenance_description(String getMaintenance_description) {
        this.getMaintenance_description = getMaintenance_description;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public double getParts_cost() {
        return parts_cost;
    }

    public void setParts_cost(double parts_cost) {
        this.parts_cost = parts_cost;
    }

    public int getHours_amount() {
        return hours_amount;
    }

    public void setHours_amount(int hours_amount) {
        this.hours_amount = hours_amount;
    }
}
