package nus.iss.ws22prac01.ProjRepo;

import static nus.iss.ws22prac01.ProjRepo.Queries.*;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import nus.iss.ws22prac01.model.Items;
import nus.iss.ws22prac01.model.Summary;
import nus.iss.ws22prac01.model.View1;
import nus.iss.ws22prac01.model.Entry;

@Repository
public class ProjRepo {
    
    @Autowired
    private JdbcTemplate template;

    public List<View1> getAllItems(String start_date, String end_date, String user_email, Integer limit, Integer offset) {

        List<View1> items = new LinkedList<>();
        Integer userId = this.getUserId(user_email);
        String sqlGetAll = "SELECT * FROM new_entry where user_id = ? AND DATE(entry_date) BETWEEN ? AND ? LIMIT ?,?";
        System.out.println("userid>>>>> " + userId);
        SqlRowSet rs = template.queryForRowSet(sqlGetAll, userId, start_date, end_date, offset, limit);

        while(rs.next()) {
            items.add(View1.fromSQL(rs));
        }
        return items;
    
    }

    public String getSum(String start_date, String end_date, String user_email) {
        
        String paywave_total = "";
        Integer userId = this.getUserId(user_email);
        SqlRowSet rs1 = template.queryForRowSet(SQL_GET_PAYWAVE_SUM, userId, start_date, end_date);
        if (rs1.next()) {
            paywave_total = rs1.getString("paywave_total");
        }

        return paywave_total;

    }

    
    public Integer getUserId(Entry entry) {
        
        SqlRowSet user_id = template.queryForRowSet(SQL_GET_USER_ID, entry.getUser_email());

        if (user_id.next()) {
            Integer userId = user_id.getInt("user_id");
            return userId;
        } else {
            return null;
        }

    }

    public Integer getUserId(String user_email) {
        
        SqlRowSet user_id = template.queryForRowSet(SQL_GET_USER_ID, user_email);

        if (user_id.next()) {
            Integer userId = user_id.getInt("user_id");
            return userId;
        } else {
            return null;
        }

    }

    public void insertEntry(Entry entry) {
    
    Integer userId = this.getUserId(entry);
    for (Items item : entry.getItems()) {
        template.update(SQL_INSERT_NEW_ENTRY, entry.getPayment(),
                                                entry.getEntry_date(), 
                                                entry.getLocation(),
                                                item.getItem_name(),
                                                item.getItem_category(),
                                                item.getItem_quantity(),
                                                item.getItem_price(),
                                                item.getItem_owner(),
                                                userId);
    }
    }

    public void saveEntry(Entry entry) {

        System.out.println("entry>>>> " + entry);

        Integer userId = this.getUserId(entry);

        if (userId == null) {

            template.update(SQL_INSERT_NEW_USER,
            entry.getFamily_name(), 
            entry.getGiven_name(),
            entry.getUser_email()
            );

            this.insertEntry(entry);   
        } else {
            this.insertEntry(entry);       
    }
    }

    public void deleteItem(String user_email, Long idx) {


        Integer userId = this.getUserId(user_email);
        System.out.println("userid>>>" + userId);
        String sqlDelete = "DELETE FROM new_entry where user_id = ? AND entry_id = ?";
        System.out.println("deleted entry_id:" + idx );
        template.update(sqlDelete, userId, idx);

    
    }
}