package com.company;

import lombok.SneakyThrows;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class BruteForce {
    private static final int MAX_LENGTH_WORD = 28;

    @SneakyThrows
    public void bruteForce()  {
      ConsoleHelper.writeMessage("Ввидете aдрес файла для его разшифровке");
      String src = ConsoleHelper.readString();
        Path dst = ConsoleHelper.buildFileName(src, "_brutforse");
        CaesarCipher cipher = new CaesarCipher();
        try (FileReader fileReader = new FileReader(src);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             BufferedWriter bufferedWriter =Files.newBufferedWriter(dst)) {
            ArrayList<String> list = new ArrayList<>();
            while (bufferedReader.ready()) {
                list.add(bufferedReader.readLine());

            }
            for (int i = 0; i < cipher.getAlphabetLength(); i++) {
                String encrypt = cipher.decrypt(String.join("", list), i);
                if (isValidate(encrypt)) {
                    for (String string : list) {
                        String encrypts = cipher.decrypt(string, i);
                        bufferedWriter.write(encrypts);
                        bufferedWriter.newLine();
                    }
                    ConsoleHelper.writeMessage("Ключь зашивровке нaйден =" + i);
                    break;
                }
            }
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
        if (text.contains(". ") || text.contains(", ") || text.contains("! ") || text.contains("? ")) {
            isValidate = true;
        }
        while (isValidate) {
            ConsoleHelper.writeMessage(text);
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

