
import java.io.*;
import java.util.Scanner;


public class Encrypted {
    public void encrypted() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ведите полный адрес к файлу для  его зашифровке");
        String src = scanner.nextLine();
        System.out.println("Ведите ключь шифрования");
        int key = Integer.parseInt(scanner.nextLine());
        System.out.println("Ведите адрес куда ввести результат");
        String dst = scanner.nextLine();
        CaesarCipher caesarCipher = new CaesarCipher();
        try (FileReader fileReader = new FileReader(src);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(dst);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                String encrypt = caesarCipher.encrypt(string, key);
                bufferedWriter.write(encrypt);
            }
        } catch (IOException e) {
        }
    }
}
