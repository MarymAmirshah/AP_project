package Controller;
import java.sql.*;

public class MySQL {
    String URL = "jdbc:mysql://localhost/malymkala";
    String UserName = "root";
    String pass = "123";
    Connection Con;

    static MySQL mySQL = null;
    public static MySQL getMySQL()
    {
        if (mySQL == null)
        {
            mySQL = new MySQL();
        }
        return mySQL;
    }
   public ResultSet ExecuteQuery(String SQLCom) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Con = DriverManager.getConnection(URL , UserName,pass);
            Statement s = Con.prepareStatement(SQLCom);
            ResultSet rs = s.executeQuery(SQLCom);
            return rs;
        } catch (Exception ex) {
            return null;
        }
    }


    public Boolean Execute(String SQLCom) throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Con = DriverManager.getConnection(URL, UserName,pass);
            Statement s = Con.prepareStatement(SQLCom);;
            s.execute(SQLCom);
            Con.close();

            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

}
