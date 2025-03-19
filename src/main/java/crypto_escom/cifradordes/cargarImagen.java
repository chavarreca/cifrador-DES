package crypto_escom.cifradordes;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class cargarImagen {
 
    public static byte[] obtenImagen(String rutaImagen) throws IOException{
        File imgPath = new File(rutaImagen);
        BufferedImage bufferedImage = ImageIO.read(imgPath);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage,"bmp",baos);
        baos.flush();
        baos.close();
        return baos.toByteArray();
    }
    
    public static void guardarImagen(String rutaImagen, byte[] bytesImagen)throws IOException{
        InputStream dentro = new ByteArrayInputStream(bytesImagen);
        BufferedImage conversor = ImageIO.read(dentro);
        ImageIO.write(conversor,"bmp",new File(rutaImagen));
    }
}
