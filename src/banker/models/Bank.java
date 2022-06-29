package banker.models;

public class Bank {
    private Integer uuid;
    private String name;

    public Integer getUuid() {
        return uuid;
    }

    public Bank() {
    }

    public Bank(Integer uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
