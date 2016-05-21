import org.junit.Test;

public class AESTest {

    @Test
    public void CryptAndDecrypt() {

        final String IV = "eJb}Lg_w97!Zs2Zj";
        String key = PRNG.generate();


        try {
            String cipher = AES.encrypt("Jones", SHA.getSHA(key).getBytes());
            String decrypted = AES.decrypt(cipher, SHA.getSHA(key).getBytes());
            assert("Jones".equals(decrypted));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
