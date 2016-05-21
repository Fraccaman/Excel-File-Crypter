import java.math.BigInteger;
import java.security.SecureRandom;

public class PRNG {

    /**
     * Generate a secure random number.
     *
     * @return the generater secure random number
     */
    public static String generate() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(128,random).toString();
    }


}


