package com.company;

import lombok.SneakyThrows;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class EncryptedDecrypted {
    @SneakyThrows
    public void encryptedDecrypted(boolean flag) {

        ConsoleHelper.writeMessage("Введите полный адрес для " + (flag ? "за" : "раз") + "шифровки файла");
        String src = ConsoleHelper.readString();
        ConsoleHelper.writeMessage("Введите ключь");
        int key = ConsoleHelper.readInt();
        Path dst = ConsoleHelper.buildFileName(src, flag ? "_encrypted" : "_decrypted");
        CaesarCipher caesarCipher = new CaesarCipher();
        try (FileReader fileReader = new FileReader(src);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             BufferedWriter bufferedWriter = Files.newBufferedWriter(dst)) {
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                String result = flag ? caesarCipher.encrypt(string, key) : caesarCipher.decrypt(string, key);
                bufferedWriter.write(result);
                bufferedWriter.newLine();
            }
        }
    }
}

