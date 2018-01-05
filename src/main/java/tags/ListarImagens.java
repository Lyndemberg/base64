package tags;

import daos.FotoDao;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author lyndemberg
 */
public class ListarImagens extends SimpleTagSupport{
    
    @Override
    public void doTag(){
        FotoDao dao = new FotoDao();
        getJspContext().setAttribute("fotos", dao.list());
    }
    
}
