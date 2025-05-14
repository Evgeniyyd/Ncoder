package com.company;

public class Main {
    public static void main(String[] args) {
        while (true) {
            ConsoleHelper.writeMessage("Выберете действия в видя его номер");
            ConsoleHelper.writeMessage("1. Зашифровать текст в файле");
            ConsoleHelper.writeMessage("2. Расшифровать текст в файле");
            ConsoleHelper.writeMessage("3. Подобрать ключь используя метод перебора");
            ConsoleHelper.writeMessage("4. Расшифровать текс в файле используя синтактический анализ текста");
            ConsoleHelper.writeMessage("5. выход из програмы");

            String string = ConsoleHelper.readString();
            if (string.equals("1")) {
                EncryptedDecrypted encryptedDecrypted = new EncryptedDecrypted();
                encryptedDecrypted.encryptedDecrypted(true);
            } else if (string.equals("2")) {
                EncryptedDecrypted encryptedDecrypted = new EncryptedDecrypted();
                encryptedDecrypted.encryptedDecrypted(false);
            } else if (string.equals("3")) {
               BruteForce bruteForce = new BruteForce();
               bruteForce.bruteForce();
            } else if (string.equals("4")) {
                Parsing parsing = new Parsing();
                parsing.pars();
            } else if (string.equals("5")) {
                return;
            }
        }
    }
}
