import org.junit.Test;

public class AESTest {

    @Test
    public void CryptAndDecrypt() {

        final String IV = "eJb}Lg_w97!Zs2Zj";
        String key = "1932u55640dly7ma";

        try {
            String cipher = AES.encrypt("Jones", key.getBytes());
            String decrypted = AES.decrypt(cipher, key.getBytes());
            assert("Jones".equals(decrypted));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
