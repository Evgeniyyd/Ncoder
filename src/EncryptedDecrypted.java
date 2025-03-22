import javax.imageio.IIOException;
import java.io.*;
import java.util.Scanner;

public class EncryptedDecrypted {
    public void encryptedDecrypted(boolean flag) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите полный адрес для " + (flag ? "раз" : "за") + "шифровки файла");
        String src = scanner.nextLine();
        System.out.println("Введите ключь");
        int key = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите полный адрес куда записать результат");
        String dst = scanner.nextLine();
        CaesarCipher caesarCipher = new CaesarCipher();
        try (FileReader fileReader = new FileReader(src);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(dst);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                String result = flag ? caesarCipher.encrypt(string, key) : caesarCipher.decrypt(string, key);
                bufferedWriter.write(result);
            }
        } catch (IOException ignore) {
        }
    }
}

