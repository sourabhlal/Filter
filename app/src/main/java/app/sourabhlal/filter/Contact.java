package app.sourabhlal.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sourabhlal on 2/20/2016.
 */
public class Contact {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String name;
    private String number;
    private String email;
    private String address;
    private String website;
    private List<String> labels = new ArrayList<String>();
    //private String image;

    public Contact(String newName){
        this.name = newName;
    }

    public void addLabel(String label){
        this.labels.add(label);
    }

    public List<String> getLabels() {
        return labels;
    }

    public String getWebsite() {

        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
