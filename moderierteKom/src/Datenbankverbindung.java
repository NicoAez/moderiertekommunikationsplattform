import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datenbankverbindung
{
    List<Benutzer> liste = new ArrayList<Benutzer>();
    Connection connection;
    Statement stmt;

    public Datenbankverbindung()
    {

    }
    static Connection verbindungAufbauen()
    {
        Connection conn = null;
        String url = "jdbc:mysql://193.176.87.146:42069/";
        String dbName = "q11_p3";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "q11_p3";
        String password = "q11_p3X";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url+dbName,userName,password);
            System.out.println("Connected to the database");
            return conn;
        }
        catch(Exception e)
        {
            System.out.println("Au backe!");
            e.printStackTrace();
        }
        return null;
    }
    public int anmelden(String n, String p)
    {
        connection = verbindungAufbauen();
        liste.clear();
        try
        {
            stmt = connection.createStatement();
            String sql = "SELECT ID, Name, Passwort FROM Benutzer WHERE Name LIKE UPPER('"+n+"')";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next())
            {
                liste.add(new Benutzer(rs.getString("Name"), rs.getString("Passwort"), rs.getInt("ID")));
            }

            rs.close();
            stmt.close();
            connection.close();

            for(int i = 0; i<liste.size(); i++)
            {
                if(liste.get(i).anmelden(n,p))
                {
                    return liste.get(i).getId();
                }

            }
            return -1;
        }
        catch(SQLException se)
        {
            return -1;
        }
        catch(NullPointerException npe)
        {
            return -1;
        }
    }
    public String getName(int e)
    {
        for(int i = 0; i<liste.size(); i++)
        {
            if(liste.get(i).getId()==e)
            {
                return liste.get(i).getName();
            }
        }
        return "[Fehler]";
    }
}

// :(
