package daos;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;
import utils.Conexao;

/**
 *
 * @author lyndemberg
 */
public class FotoDao {
    private Connection con;
    public void init(){
        try {
            con = Conexao.getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FotoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean salvar(String foto){
        init();
        try {
            PreparedStatement p = con.prepareStatement("INSERT INTO fotos (foto) VALUES (?)");
            p.setString(1, foto);
            boolean retorno = p.executeUpdate()>0;
            p.close();
            con.close();
            return retorno;
        } catch (SQLException ex) {
            Logger.getLogger(FotoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public List<String> list(){
        init();
        List<String> fotos = new ArrayList<>();
        try {
            PreparedStatement p = con.prepareStatement("SELECT * FROM fotos");
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                fotos.add(rs.getString("foto"));
            }
            rs.close();
            p.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(FotoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fotos;
    }
}
