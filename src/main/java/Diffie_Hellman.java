import java.math.BigInteger;
import java.security.*;
import javax.crypto.KeyAgreement;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import java.util.Scanner;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.spec.DHPublicKeySpec;

public class Diffie_Hellman {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre (Alice/Bob): ");
        String userName = scanner.nextLine();

        System.out.print("Ingrese el valor de p: ");
        BigInteger p = scanner.nextBigInteger();

        System.out.print("Ingrese el valor de g: ");
        BigInteger g = scanner.nextBigInteger();

        // Generar las claves pública y privada
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DH");
        DHParameterSpec dhParamSpec = new DHParameterSpec(p, g);
        SecureRandom random = new SecureRandom();
        keyPairGenerator.initialize(dhParamSpec, random);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // Obtener la clave pública y privada
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        
                System.out.println("Clave pública de " + userName + ": " + ((DHPrivateKey) privateKey).getX());
        // Mostrar la clave pública generada
        System.out.println("Clave pública de " + userName + ": " + ((DHPublicKey) publicKey).getY());

        System.out.print("Ingrese la clave pública del otro usuario: ");
        BigInteger otherPublicKeyValue = scanner.nextBigInteger();

        // Parámetros públicos compartidos
        DHParameterSpec dhParamSpecShared = new DHParameterSpec(p, g);
        
        // Clave pública del otro usuario
        KeyFactory keyFactory = KeyFactory.getInstance("DH");
        DHPublicKey otherPublicKey = (DHPublicKey) keyFactory.generatePublic(new DHPublicKeySpec(otherPublicKeyValue, p, g));

        // Calcular la clave compartida "k" utilizando el acuerdo de claves
        KeyAgreement keyAgreement = KeyAgreement.getInstance("DH");
        keyAgreement.init(privateKey);
        keyAgreement.doPhase(otherPublicKey, true);
        byte[] secretKeyBytes = keyAgreement.generateSecret();

        // Convertir el valor de la clave compartida a BigInteger
        BigInteger secretKey = new BigInteger(1, secretKeyBytes);

        System.out.println("Clave compartida de " + userName + ": " + secretKey);
    }
}
