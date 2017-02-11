package hu.ott_one.mosbydemo.model;

/**
 * Created by richardbodai on 2/10/17.
 */
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
