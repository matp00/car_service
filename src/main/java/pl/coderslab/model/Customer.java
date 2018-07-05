package pl.coderslab.model;

public class Customer extends Person {
    protected int id=0;
    private String address;
    private String phone;
    private String email;
    private String birth_date;

    public Customer() {
    }

    public Customer(String name, String surname, String address, String phone, String email, String birth_date) {

        super(name, surname);;
        setAddress(address);
        setPhone(phone);
        setEmail(email);
        setBirth_date(birth_date);
    }


    public void setId(int id) {
        this.id = id;
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

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String date_of_birth) {
        this.birth_date = birth_date;
    }


}