import java.io.*;
import java.util.ArrayList;


public class BruteForce {
    public void bruteForce() {
        String src = ConsoleHelper.readString();
        ConsoleHelper.writeMessage("Видите адрес файла куда записать результат");
        String dst = ConsoleHelper.readString();
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
                if (isValidate(encrypt)) {
                    bufferedWriter.write(encrypt);
                }
            }
        } catch (IOException i) {
        }
    }

    private boolean isValidate(String text) {
        return false;
    }
}

