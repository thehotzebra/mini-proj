package nus.iss.ws22prac01.model;

import java.sql.Date;
import java.util.List;

public class Entry {
    
    //understand that i should have named it using camel case
    private String payment;
    private Date entry_date;
    private String location;
    private String user_email;
    private String given_name;
    private String family_name;
    private List<Items> items;
   
    public String getPayment() {
        return payment;
    }
    public void setPayment(String payment) {
        this.payment = payment;
    }
    public Date getEntry_date() {
        return entry_date;
    }
    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public List<Items> getItems() {
        return items;
    }
    public void setItems(List<Items> items) {
        this.items = items;
    }

    public String getUser_email() {
        return user_email;
    }
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
    public String getGiven_name() {
        return given_name;
    }
    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }
    public String getFamily_name() {
        return family_name;
    }
    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }
    @Override
    public String toString() {
        return "Entry [payment=" + payment + ", entry_date=" + entry_date + ", location=" + location + ", user_email="
                + user_email + ", given_name=" + given_name + ", family_name=" + family_name + ", items=" + items + "]";
    }

    

}
