import java.util.ArrayList;
import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) throws Exception {
        final String path = "/Users/FraccaMan/GitHub/excel-java/src/main/resources/testxls.xls";
        String PSnumber = PRNG.generate();
        ArrayList<Integer> indexes = new ArrayList<>(asList(2,5));
        CryptCells.encrypt(path,SHA.getSHA(PSnumber),indexes,0);
        DecryptCells.decrypt(path,SHA.getSHA(PSnumber),indexes,0);
    }
}
