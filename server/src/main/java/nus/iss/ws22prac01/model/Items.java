package nus.iss.ws22prac01.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Items {

        private String item_name;
        private String item_category;
        private int item_quantity;
        private String item_price;
        private String item_owner;

        public static Items fromSQL(SqlRowSet rs) {

            Items items = new Items();
            items.setItem_name(rs.getString("item_name"));
            items.setItem_category(rs.getString("item_category"));
            items.setItem_quantity(rs.getInt("item_quantity"));
            items.setItem_owner(rs.getString("item_owner"));
            
            return items;
        }

        public JsonObject toJsonObject() {
            JsonObject jObject = Json.createObjectBuilder()
                        .add("item_name", this.getItem_name())
                        .add("item_category", this.getItem_category())
                        .add("item_quantity", this.getItem_quantity())
                        .add("item_owner", this.getItem_owner())
                        .build();
            
            return jObject; 
        }

        public String getItem_name() {
            return item_name;
        }

        public void setItem_name(String item_name) {
            this.item_name = item_name;
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

        @Override
        public String toString() {
            return "Items [item_name=" + item_name + ", item_category=" + item_category + ", item_quantity="
                    + item_quantity + ", item_price=" + item_price + ", item_owner=" + item_owner + "]";
        }

        
}

