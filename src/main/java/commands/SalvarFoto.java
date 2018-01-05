package commands;

import daos.FotoDao;
import interfaces.Command;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import utils.FotoManager;

/**
 *
 * @author lyndemberg
 */
public class SalvarFoto implements Command{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Part part = req.getPart("foto");
        FotoDao dao = new FotoDao();
        if(dao.salvar(FotoManager.encodeFoto(part))){
            res.sendRedirect("exibir.jsp");
        }else{
            res.sendRedirect("index.html");
        }
    }
    
}
