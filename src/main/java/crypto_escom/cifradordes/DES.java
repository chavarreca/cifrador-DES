package crypto_escom.cifradordes;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class DES {
    private final static String alg = "DES";
    private final String modoDeOperacion;
    private final String cIE;
    private final String cID;
    
    public DES(String modoDeOperacion){
        this.modoDeOperacion = modoDeOperacion;
        this.cIE = alg + "/" + modoDeOperacion + "/PKCS5Padding";
        this.cID = alg + "/" + modoDeOperacion + "/NoPadding";
    }
    
    public void cifrar(String llave, String iv, byte[] imagen, String nombreDelArchivo)throws Exception{
        Integer cabecera_s = 54;
        byte[] byteFinal = new byte[(int) imagen.length];
        byte[] byteCifrado = new byte[(int) imagen.length - cabecera_s];
        
        for(int ina = 0, gura = 0; ina < imagen.length;ina++){
            if(ina < cabecera_s)
                byteFinal[ina] = imagen[ina];
            else
                byteCifrado[gura++] = imagen[ina];
        }
        
        Cipher cipher = Cipher.getInstance(cIE);
        SecretKeySpec skeySpec = new SecretKeySpec(llave.getBytes(),alg);
        IvParameterSpec ivParaSpec = !modoDeOperacion.equals("ECB") ? new IvParameterSpec(iv.getBytes()) : null;
        
        if(ivParaSpec != null)
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParaSpec);
        else
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        
        byte[] cifrado = cipher.doFinal(byteCifrado);
        
        StringBuilder constructor = new StringBuilder();
        constructor.append(nombreDelArchivo).append("_c").append(modoDeOperacion).append(".bmp");
        
        for(int ina = cabecera_s, gura = 0; ina < imagen.length; ina++,gura++)
            byteFinal[ina] = cifrado[gura];
        
        cargarImagen.guardarImagen(constructor.toString(), byteFinal);
        System.out.println("Cifrado Exitoso ^w^ en Modo " + this.modoDeOperacion);
    }
    
    public void decifrar(String llave, String iv, byte[] imagen, String nombreDelArchivo)throws Exception{
        Integer cabecera_s = 54;
        byte[] byteFinal = new byte[(int) imagen.length];
        byte[] byteCifrado = new byte[(int) imagen.length - cabecera_s];
        
        for(int ina = 0, gura = 0; ina < imagen.length;ina++){
            if(ina < cabecera_s)
                byteFinal[ina] = imagen[ina];
            else
                byteCifrado[gura++] = imagen[ina];
        }
        
        Cipher cipher = Cipher.getInstance(cID);
        SecretKeySpec skeySpec = new SecretKeySpec(llave.getBytes(),alg);
        IvParameterSpec ivParaSpec = !modoDeOperacion.equals("ECB") ? new IvParameterSpec(iv.getBytes()) : null;
        
        if(ivParaSpec != null)
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParaSpec);
        else
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        
        byte[] decifrado = cipher.doFinal(byteCifrado);
        
        StringBuilder constructor = new StringBuilder();
        constructor.append(nombreDelArchivo).append("_d").append(modoDeOperacion).append(".bmp");
        
        for(int ina = cabecera_s, gura = 0; ina < imagen.length; ina++,gura++)
            byteFinal[ina] = decifrado[gura];
        
        cargarImagen.guardarImagen(constructor.toString(), byteFinal);
        System.out.println("Decifrado Exitoso ^w^ en Modo " + this.modoDeOperacion); 
    }
}
