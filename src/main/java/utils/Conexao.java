package utils;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lyndemberg
 */
public class Conexao {
    
    public static java.sql.Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/base64";
        String usuario = "postgres";
        String senha = "pgadmin";
        return DriverManager.getConnection(url, usuario, senha);
    }
   
}
