import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Mac;
import java.util.Base64;

public class SenhaEncryptor {

    private static final String CHAVE_SECRETA = "#modalGR#GPTW#top#maiorEmpresaTecnologia#baixadaSantista";

    public static String criptografarSenhaAES(String senha) throws Exception {
        Key chave = gerarChave(CHAVE_SECRETA);
        Cipher cifra = Cipher.getInstance("AES");
        cifra.init(Cipher.ENCRYPT_MODE, chave);
        byte[] textoCifrado = cifra.doFinal(senha.getBytes());
        return Base64.getEncoder().encodeToString(textoCifrado);
    }

    public static String criptografarSenhaRSA(String senha) throws Exception {
        KeyPairGenerator geradorChave = KeyPairGenerator.getInstance("RSA");
        geradorChave.initialize(2048); 
        KeyPair parChaves = geradorChave.generateKeyPair();
        Cipher cifra = Cipher.getInstance("RSA");
        cifra.init(Cipher.ENCRYPT_MODE, parChaves.getPublic());
        byte[] textoCifrado = cifra.doFinal(senha.getBytes());
        return Base64.getEncoder().encodeToString(textoCifrado);
    }

    public static String criptografarSenhaHMAC(String senha) throws Exception {
        Mac hmac = Mac.getInstance("HmacSHA256");
        SecretKeySpec chave = new SecretKeySpec(CHAVE_SECRETA.getBytes(), "HmacSHA256");
        hmac.init(chave);
        byte[] textoCifrado = hmac.doFinal(senha.getBytes());
        return Base64.getEncoder().encodeToString(textoCifrado);
    }

    private static SecretKeySpec gerarChave(String chaveSecreta) throws Exception {
        byte[] chaveBytes = chaveSecreta.getBytes("UTF-8");
        KeySpec spec = new PBEKeySpec(chaveSecreta.toCharArray(), chaveBytes, 65536, 256);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] chaveCriptografada = factory.generateSecret(spec).getEncoded();
        return new SecretKeySpec(chaveCriptografada, "AES");
    }

    public static void main(String[] args) {
        try {
            String senhaA = "Ola equipe da ModalGR,";
            String senhaB = "espero que voces gostem dos meus programas, que eu prossiga no processo seletivo";
            String senhaC = "e que eu tenha a oportunidade de trabalhar com voces";

            String senhaCriptografadaAES = criptografarSenhaAES(senhaA);
            String senhaCriptografadaRSA = criptografarSenhaRSA(senhaB);
            String senhaCriptografadaHMAC = criptografarSenhaHMAC(senhaC);

            System.out.println("Senha A: " + senhaA);
            System.out.println("Senha B: " + senhaB);
            System.out.println("Senha C: " + senhaC);
            System.out.println("                  ");
            System.out.println("Senha A criptografada (AES): " + senhaCriptografadaAES);
            System.out.println("Senha B criptografada (RSA): " + senhaCriptografadaRSA);
            System.out.println("Senha C criptografada (HMAC): " + senhaCriptografadaHMAC);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
