import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.h2.jdbc.JdbcSQLNonTransientException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Manager {

    public void connectionWithUser () throws SQLException, ClassNotFoundException {
        UserInterface user = new UserInterface();
        int act = user.whatDoYouWantDo();
        if( act != 0) {
            DbQueryServes database = establishConnection();
            if (act == 1) {
                openTimetable(database);
            } else if (act == 2) {
                addNewColumn (database, user);
            } else if (act == 3) {
                changeInformation(database, user);
            }
        }
    }
    private DbQueryServes establishConnection() throws SQLException, ClassNotFoundException {
        Connection connection = DriverManager.getConnection("jdbc:h2:~/timetable_db", "frozen_penguin", "");
        System.out.println("[DEBUG] Соединение с СУБД выполнено." + !connection.isClosed());
        DbQueryServes database = new DbQueryServes(connection);
        return database;
    }
    public int chooseID () throws SQLException, ClassNotFoundException {
        DbQueryServes database = establishConnection();
        for (int t = 1; ; t++) {
            try {
                database.insertNewLineToDB(t);
                return t;
            }
            catch (JdbcSQLIntegrityConstraintViolationException exp) {
                continue;
            }
        }
    }
    public void openTimetable(DbQueryServes database) throws SQLException {
        database.selectQuery("select * from timetable");
    }
    public void addNewColumn (DbQueryServes database, UserInterface user) throws SQLException, ClassNotFoundException {
        TaskData types = user.addInformation();
        types.id = chooseID();
        database.updateTask(types);
        database.updateDesc(types);
        database.updateDeadline(types);
    }
    public void changeInformation (DbQueryServes database, UserInterface user) throws SQLException, ClassNotFoundException {
        int currentLineNumber = user.chooseChangingLine();
        try {
            database.selectOneQuery(currentLineNumber);
        }
        catch(JdbcSQLNonTransientException e) {
            System.out.println("Haven't the string");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

            TaskData types = new TaskData(currentLineNumber);
        while (true) {
            int usersChoice = user.chooseChangingInformation();
            switch (usersChoice) {
                case 1:
                    types.task = user.importString();
                    database.updateTask(types);
                    database.selectOneQuery(currentLineNumber);
                    break;
                case 2:
                    types.description = user.importString();
                    database.updateDesc(types);
                    database.selectOneQuery(currentLineNumber);
                    break;
                case 3:
                    types.status = true;
                    database.updateStatus(types);
                    database.selectOneQuery(currentLineNumber);
                    break;
                case 4:
                    types.importance = user.importInt();
                    database.updateImportance(types);
                    database.selectOneQuery(currentLineNumber);
                    break;
                case  5:
                    types.deadline = user.importInt();
                    database.updateDesc(types);
                    database.selectOneQuery(currentLineNumber);
                    break;
                case 6:
                    database.deleteQuery(types);
            }
            if(usersChoice == 0) {
                break;
            }
        }
    }



}
