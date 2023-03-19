import java.sql.*;

public class DbQueryServes {
    private Connection connection;

    public DbQueryServes(Connection connection) {
        this.connection = connection;
    }


    public void selectQuery (String query) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while(resultSet.next()) {
            //System.out.println(("Id:" + resultSet.getInt("id")));
            System.out.println(("Task:" + resultSet.getString("task")));
            System.out.println(("Description:" + resultSet.getString("description")));
            System.out.println(("Deadline:" + resultSet.getInt("deadline")));
            System.out.println(("Importance:" + resultSet.getInt("importance")));
            System.out.println(("Status:" + resultSet.getBoolean("Status")));
            System.out.println("\n");
        }
    }

    public void selectOneQuery (int IDNumber) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from timetable");

        for (int t = 0; t < IDNumber; t++) {
            resultSet.next();
        }
            //System.out.println(("Id:" + resultSet.getInt("id")));
            System.out.println(("Task:" + resultSet.getString("task")));
            System.out.println(("Description:" + resultSet.getString("description")));
            System.out.println(("Deadline:" + resultSet.getInt("deadline")));
            System.out.println(("Importance:" + resultSet.getInt("importance")));
            System.out.println(("Status:" + resultSet.getBoolean("Status")));
            System.out.println("\n");
    }

    public void insertNewLineToDB(int number) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert INTO timetable (id) values (?)");
        preparedStatement.setInt(1, number);
        int result = preparedStatement.executeUpdate();
    }

    public void insertDescription (TaskData type) throws SQLException, ClassNotFoundException {
        int insertId = type.getId();
        PreparedStatement preparedStatement = connection.prepareStatement("insert INTO timetable (id, description) values (?, ?)");
        preparedStatement.setInt(1, insertId);
        preparedStatement.setString(2, type.getDescription());
        //Class.forName("org.h2.Driver"); //че это дает?
        int result = preparedStatement.executeUpdate();

    }

    public void insertTask (TaskData type) throws SQLException, ClassNotFoundException {
        int insertId = type.getId();
        PreparedStatement preparedStatement = connection.prepareStatement("insert INTO timetable (task) values (?)");
        //preparedStatement.setInt(1, insertId);
        preparedStatement.setString(1, type.getTask());
        //Class.forName("org.h2.Driver"); //че это дает?
        int result = preparedStatement.executeUpdate();

    }

    public void insertStatus (TaskData type) throws SQLException, ClassNotFoundException {
        int insertId = type.getId();
        PreparedStatement preparedStatement = connection.prepareStatement("insert INTO timetable (id, status) values (?, ?)");
        preparedStatement.setInt(1, insertId);
        preparedStatement.setBoolean(2, type.isStatus());
        //Class.forName("org.h2.Driver"); //че это дает?
        int result = preparedStatement.executeUpdate();

    }

    public void insertDeadline (TaskData type) throws SQLException, ClassNotFoundException {
        int insertId = type.getId();
        PreparedStatement preparedStatement = connection.prepareStatement("insert INTO timetable (id, deadline) values (?, ?)");
        preparedStatement.setInt(1, insertId);
        preparedStatement.setInt(2, type.getDeadline());
        //Class.forName("org.h2.Driver"); //че это дает?
        int result = preparedStatement.executeUpdate();

    }

    public void insertImportance (TaskData type) throws SQLException, ClassNotFoundException {
        int insertId = type.getId();
        PreparedStatement preparedStatement = connection.prepareStatement("insert INTO timetable (id, importance) values (?, ?)");
        preparedStatement.setInt(1, insertId);
        preparedStatement.setInt(2, type.getImportance());
        //Class.forName("org.h2.Driver"); //че это дает?
        int result = preparedStatement.executeUpdate();

    }

// удаление по id
    public void deleteQuery (TaskData type) throws SQLException, ClassNotFoundException {
        int insertId = type.getId();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from timetable where id = ?");
        preparedStatement.setInt(1, insertId);
        int result = preparedStatement.executeUpdate();
    }

    public void updateTask (TaskData element) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE timetable SET task = ? WHERE id = ?");
        preparedStatement.setString(1, element.getTask());
        preparedStatement.setInt(2, element.getId());
        int rows = preparedStatement.executeUpdate();
        System.out.printf("Updated %d rows", rows);
    }

    public void updateDesc (TaskData element) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE timetable SET description = ? WHERE id = ?");
        preparedStatement.setString(1, element.getDescription());
        preparedStatement.setInt(2, element.getId());
        int rows = preparedStatement.executeUpdate();
        System.out.printf("Updated %d rows", rows);
    }

    public void updateDeadline (TaskData element) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE timetable SET deadline = ? WHERE id = ?");
        preparedStatement.setInt(1, element.getDeadline());
        preparedStatement.setInt(2, element.getId());
        int rows = preparedStatement.executeUpdate();
        System.out.printf("Updated %d rows", rows);
    }

    public void updateStatus (TaskData element) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE timetable SET status = ? WHERE id = ?");
        preparedStatement.setBoolean(1, element.getStatus());
        preparedStatement.setInt(2, element.getId());
        int rows = preparedStatement.executeUpdate();
        System.out.printf("Updated %d rows", rows);
    }

    public void updateImportance (TaskData element) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE timetable SET importance = ? WHERE id = ?");
        preparedStatement.setInt(1, element.getImportance());
        preparedStatement.setInt(2, element.getId());
        int rows = preparedStatement.executeUpdate();
        System.out.printf("Updated %d rows", rows);
    }

}
