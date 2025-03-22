import javax.imageio.IIOException;
import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class BruteForce {
    public void bruteForce() {
        Scanner scanner = new Scanner(System.in);
        String src = scanner.nextLine();
        System.out.println("Видите адрес файла куда записать результат");
        String dst = scanner.nextLine();
        CaesarCipher cipher = new CaesarCipher();
        try (FileReader fileReader = new FileReader(src);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(dst);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            ArrayList<String> list = new ArrayList<>();
            while (bufferedReader.ready()) {
                list.add(bufferedReader.readLine());

            }
            for (int i = 0; i < cipher.getAlphabetLength(); i++) {
                String encrypt = cipher.decrypt(String.join("", list), i);
                if (isValidate(encrypt)){
                    bufferedWriter.write(encrypt);
                }
            }
        } catch (IOException i) {
        }
    }
    private boolean isValidate(String text){
        return false;
    }
}

//класс java.io.files прочитать заного
// считать содержимое файла и положить каждую строчку в arrayList