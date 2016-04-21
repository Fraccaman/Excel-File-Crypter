import java.util.ArrayList;
import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) throws Exception {
        final String path = "/Users/FraccaMan/GitHub/excel-java/src/test/SampleDataTest.xls";
        String key = "1932u5564";
        ArrayList<Integer> indexes = new ArrayList<>(asList(2,5));
        CryptCells.encrypt(path,key,indexes,0);
        DecryptCells.decrypt(path,key,indexes,0);
    }
}
