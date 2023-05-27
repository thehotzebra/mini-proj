package nus.iss.ws22prac01.model;

import java.sql.Date;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class View1 {
    
    private Date entry_date;
    private int entry_id;
    private String item_name;
    private String payment;
    private String location;
    private String item_category;
    private int item_quantity;
    private String item_price;
    private String item_owner;


    public static View1 fromSQL(SqlRowSet rs) {

        View1 viewItems = new View1();
        viewItems.setEntry_id(rs.getInt("entry_id"));
        viewItems.setPayment(rs.getString("payment"));
        viewItems.setEntry_date(rs.getDate("entry_date"));
        viewItems.setLocation(rs.getString("location"));
        viewItems.setItem_name(rs.getString("item_name"));
        viewItems.setItem_category(rs.getString("item_category"));
        viewItems.setItem_quantity(rs.getInt("item_quantity"));
        viewItems.setItem_price(rs.getString("item_price"));
        viewItems.setItem_owner(rs.getString("item_owner"));

        return viewItems;
    }

    public JsonObject toJsonObject() {
        JsonObject jObject = Json.createObjectBuilder()
        .add("entry_id", this.getEntry_id())
        .add("payment", this.getPayment())
        .add("entry_date", this.getEntry_date().toString())
        .add("location", this.getLocation())
        .add("item_name", this.getItem_name())
        .add("item_category", this.getItem_category())
        .add("item_quantity", this.getItem_quantity())
        .add("item_price", this.getItem_price())
        .add("item_owner", this.getItem_owner())
        .build();

        return jObject; 
    }

    
    public Date getEntry_date() {
        return entry_date;
    }
    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }
    public String getItem_name() {
        return item_name;
    }
    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
    public String getPayment() {
        return payment;
    }
    public void setPayment(String payment) {
        this.payment = payment;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getItem_category() {
        return item_category;
    }
    public void setItem_category(String item_category) {
        this.item_category = item_category;
    }
    public int getItem_quantity() {
        return item_quantity;
    }
    public void setItem_quantity(int item_quantity) {
        this.item_quantity = item_quantity;
    }
    public String getItem_price() {
        return item_price;
    }
    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public String getItem_owner() {
        return item_owner;
    }
    public void setItem_owner(String item_owner) {
        this.item_owner = item_owner;
    }

    public int getEntry_id() {
        return entry_id;
    }

    public void setEntry_id(int entry_id) {
        this.entry_id = entry_id;
    }
    
    
    }
