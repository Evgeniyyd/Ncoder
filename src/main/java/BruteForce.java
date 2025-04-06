import java.io.*;
import java.util.ArrayList;


public class BruteForce {
    private static final int MAX_LENGTH_WORD = 28;

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
        String[] words = text.split(" ");
        for (String word : words) {
            if (word.length() > MAX_LENGTH_WORD) {
                return false;
            }
        }
        boolean isValidate = false;
        if (text.contains(". ") || text.contains(", ") || text.contains("! ") || text.contains("? ")){
            isValidate = true;
        }
        while (isValidate) {
            ConsoleHelper.writeMessage("понятен ли вам это текст Yes  / No");
            String answer = ConsoleHelper.readString();
            if (answer.equalsIgnoreCase("Yes")) {
                return true;
            } else if (answer.equalsIgnoreCase("No")) {
                isValidate = false;
            } else {
                ConsoleHelper.writeMessage("Введите Yes или No");

            }
        }
        return false;
    }
}

