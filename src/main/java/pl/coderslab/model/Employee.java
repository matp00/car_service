package pl.coderslab.model;

public class Employee extends Person {
    private int id=0;
    private String note;
    private double hourly;

    public Employee() { }

    public Employee(String name, String surname, String address, String phone, String email, String date_of_birth, String note, double hourly) {
        super(name, surname, address, phone, email, date_of_birth);
        setNote(note);
        setHourly(hourly);
    }

    public int getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getHourly() {
        return hourly;
    }

    public void setHourly(double hourly) {
        this.hourly = hourly;
    }
    }
}
