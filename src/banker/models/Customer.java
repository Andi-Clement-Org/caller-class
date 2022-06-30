package banker.models;

public class Customer {
    private Integer uuid;
    private String full_name;
    private String email;

    public Customer() {
    }

    public Customer(Integer uuid, String full_name, String email) {
        this.uuid = uuid;
        this.full_name = full_name;
        this.email = email;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "uuid=" + uuid +
                ", full_name='" + full_name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
