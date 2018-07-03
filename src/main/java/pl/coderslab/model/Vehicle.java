package pl.coderslab.model;

public class Vehicle {
    private int id=0;
    private String brand;
    private String model;
    private int production_year;
    private String registration_number;
    private String next_service;

    public Vehicle() {
    }

    public Vehicle(String brand, String model, int production_year, String registration_number, String next_service) {
        setBrand(brand);
        setModel(model);
        setProduction_year(production_year);
        setRegistration_number(registration_number);
        setNext_service(next_service);
    }

    public int getId() {
        return id;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProduction_year() {
        return production_year;
    }

    public void setProduction_year(int production_year) {
        this.production_year = production_year;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public String getNext_service() {
        return next_service;
    }

    public void setNext_service(String next_service) {
        this.next_service = next_service;
    }
}
