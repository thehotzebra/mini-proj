package nus.iss.ws22prac01.ProjRepo;

public class Queries {
    
    public static final String SQL_GET_USER_ID = "SELECT USER_ID FROM users where user_email = ?";
    public static final String SQL_INSERT_NEW_USER = """
        insert into users (first_name, last_name, user_email) values
        (?,?,?)
        """;
    public static final String SQL_INSERT_NEW_ENTRY = """
        insert into new_entry (payment, entry_date, location, item_name, item_category, item_quantity, item_price, item_owner, user_id) values
        (?,?,?,?,?,?,?,?,?)
        """;
    public static final String SQL_GET_CASH_SUM = """
        SELECT SUM(item_price*item_quantity) as cash_total FROM new_entry where user_id = ? AND DATE(entry_date)
        BETWEEN ? AND ? AND item_owner = ? AND payment = 'cash' ;
            """;
    public static final String SQL_GET_PAYWAVE_SUM = """
                SELECT SUM(item_price*item_quantity) as paywave_total FROM new_entry where user_id = ? AND DATE(entry_date)
                BETWEEN ? AND ? AND payment = 'dbs-paywave' ;
                    """;
}
