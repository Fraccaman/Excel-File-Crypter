import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class SHA {

    /**
     * Gets sha.
     *
     * @param input input String to be hashed
     * @return the hashed input
     */

    public static String getSHA(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 16) {
                hashtext = "0" + hashtext;
            }
            return hashtext.substring(0,16);
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
