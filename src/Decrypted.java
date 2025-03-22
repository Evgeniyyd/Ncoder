
import java.io.*;
import java.util.Scanner;

public class Decrypted {
    public void decrypted() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите полный адрес фаила для его расшифровке");
        String src = scanner.nextLine();
        System.out.println("Ввудите ключь для его расшифровке");
        int key = Integer.parseInt(scanner.nextLine());
        System.out.println("Ввудите адрес куда вывести результат");
        String dst = scanner.nextLine();
        CaesarCipher caesarCipher = new CaesarCipher();
        try (FileReader fileReader = new FileReader(src);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(dst);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                String decrypt = caesarCipher.decrypt(string, key);
                bufferedWriter.write(decrypt);
            }
        } catch (IOException ig) {

        }
    }
}
