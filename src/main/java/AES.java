import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {

    /**
     * Encrypt string.
     *
     * @param plainText the plain text
     * @param enc_key   the encryption key
     * @return the encrypted text
     * @throws Exception the exception
     */

    public static String encrypt(String plainText, byte[] enc_key) throws Exception {
        final String IV = "eJb}Lg_w97!Zs2Zj";
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec key = new SecretKeySpec(enc_key, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes()));
        return Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes()));
    }

    /**
     * Decrypt string.
     *
     * @param cipherString the encrypted text
     * @param enk_key the encryption key
     * @return the plain text
     * @throws Exception the exception
     */

    public static String decrypt(String cipherString, byte[] enk_key) throws Exception{
        final String IV = "eJb}Lg_w97!Zs2Zj";
        byte[] cipherText = Base64.getDecoder().decode(cipherString);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec key = new SecretKeySpec(enk_key, "AES");
        cipher.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes()));
        return new String(cipher.doFinal(cipherText));
    }
}
