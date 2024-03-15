package lk.ijse.dto;

public class AdminDto {

    private  String id;
    private String Email;

    private String password;

    public AdminDto(String id, String email, String password) {
        this.id = id;
        Email = email;
        this.password = password;
    }

    public AdminDto(String email, String password) {
        Email = email;
        this.password = password;
    }


    public AdminDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminDto{" +
                "id='" + id + '\'' +
                ", Email='" + Email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
