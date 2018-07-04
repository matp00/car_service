package pl.coderslab.model;

public class Employee extends Person {



    private int id;
    private String address;
    private int phone;
    private String note;
    private double hourly;
    private String email;
    private String birthDate;


    public Employee(int id, String name, String surname, String address, int phone, String note, double hourly, String email, String birthDate) {

        super(name, surname);
        setId(id);
        setAddress(address);
        setPhone(phone);
        setNote(note);
        setHourly(hourly);
        setEmail(email);
        setBirthDate(birthDate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
