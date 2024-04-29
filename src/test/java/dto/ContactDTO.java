package dto;

public class ContactDTO {
    private  String name;
    private  String lastName;
    private  String phone;
    private  String email;
    private  String address;
    private  String description;

    public ContactDTO() {
    }

    public ContactDTO setName(String name) {
        this.name = name;
        return this;
    }

    public ContactDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public ContactDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {

        return name;
    }

    public String getLastName() {

        return lastName;
    }

    public String getPhone() {

        return phone;
    }

    public String getEmail() {

        return email;
    }

    public String getAddress() {

        return address;
    }

    public String getDescription() {

        return description;
    }
}
