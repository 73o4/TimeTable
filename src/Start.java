import org.h2.jdbc.JdbcSQLNonTransientException;

import java.sql.SQLException;

public class Start {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Manager manager = new Manager();
        while(true) {
            manager.connectionWithUser();
            }
    }

}
