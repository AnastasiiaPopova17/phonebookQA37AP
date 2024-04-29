package dto;

public class UserDTO {

    String email;
    String password;

    public UserDTO() {
    }

    public String getEmail() {
        return email;
    }

    public UserDTO setEmail(String email) { // withEmail(String email)
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}