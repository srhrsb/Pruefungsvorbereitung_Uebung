package model;

public class Visitor {

    private String id;
    private String name;
    private String firstName;

    public Visitor(String id, String name, String firstName) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
