import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Full path to file: ");
        String path = scanner.next();
        System.out.print("1 for Encrypt or 2 for Decrypt: ");
        String function = scanner.next();
        String password;
        if(function.trim().equals("1")) {
            System.out.print("Password or 'auto' to generate a pseudo random password: ");
            password = scanner.next();
            if(function.trim().equals("1") && password.trim().toLowerCase().equals("auto")){
                password = PRNG.generate().substring(0,15);
            }
            System.out.println("The password is ( if you lose it, the file is lost ):" + password);
        } else if(function.trim().equals("2")) {
            System.out.print("Password: ");
            password = scanner.next();
        } else {
            System.out.println("Can't continue without password!");
            System.exit(0);
            return;
        }
        ArrayList<Integer> indexes = new ArrayList<>();
        System.out.print("Enter column index or 'stop' to continue ): ");
        String index = scanner.next();
        while(!index.toLowerCase().equals("stop")){
            indexes.add(Integer.parseInt(index));
            System.out.print("Enter column index or 'stop' to continue ): ");
            index = scanner.next();
        }
        if(!indexes.isEmpty() && function.trim().equals("1")) {
            CryptCells.encrypt(path.trim(), SHA.getSHA(password), indexes, 0);
        }
        if(!indexes.isEmpty() && function.trim().equals("2")) {
            DecryptCells.decrypt(path.trim(), SHA.getSHA(password), indexes, 0);
        }
    }
}
