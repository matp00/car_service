package pl.coderslab.model;

public class Customer extends Person {
    private int id=0;
    private String address;
    private String phone;
    private String email;
    private String date_of_birth;

    public Customer() {
    }

    public Customer(String name, String surname, String address, String phone, String email, String date_of_birth) {
        super(name, surname);
        setAddress(address);
        setPhone(phone);
        setEmail(email);
        setDate_of_birth(date_of_birth);
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
}
