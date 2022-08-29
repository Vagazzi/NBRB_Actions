import java.sql.*;

public class DatabaseHandler extends Config {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString =  "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }
    public void writeData(String date, String scale, String value) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_NAME + "," + Const.USER_SURNAME + "," + Const.USER_PASSWORD + ")" +
                "VALUES(?,?,?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1,date);
        prSt.setString(2,scale);
        prSt.setString(3,value);

        prSt.executeUpdate();


        System.out.println("Writing data was completed successfully");
    }


}
