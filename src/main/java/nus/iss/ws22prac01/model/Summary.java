package nus.iss.ws22prac01.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Summary {
    
    private String dbsPaywave;
    private String cash;
    // private String dbsOnline;
    // private String hsbcAdvance;

    public static Summary fromSQL(SqlRowSet rs) {

        Summary summary = new Summary();
        summary.setDbsPaywave(rs.getString("paywave_total"));
        summary.setCash(rs.getString("cash_total"));
    
        return summary;
    }

    public JsonObject toJsonObject() {
        JsonObject jObject = Json.createObjectBuilder()
        .add("cash_total", this.getCash())
        .add("paywave_total", this.getDbsPaywave())
        .build();

        return jObject; 
    }

    public String getDbsPaywave() {
        return dbsPaywave;
    }
    public void setDbsPaywave(String dbsPaywave) {
        this.dbsPaywave = dbsPaywave;
    }
    public String getCash() {
        return cash;
    }
    public void setCash(String cash) {
        this.cash = cash;
    }
    
    
}
