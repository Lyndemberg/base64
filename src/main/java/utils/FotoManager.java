package utils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Base64;
import javax.servlet.http.Part;

public class FotoManager {
    
    public static String encodeFoto(Part foto) throws IOException{
        byte[] array = new byte[(int)foto.getSize()];
        new BufferedInputStream(foto.getInputStream()).read(array);
        String base64 = Base64.getEncoder().encodeToString(array);
        return base64;
    }
    
    
}
