package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection c;
    Statement s;


    Conn()
    {
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Diet", "root", "placement2026");
            s = c.createStatement();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
