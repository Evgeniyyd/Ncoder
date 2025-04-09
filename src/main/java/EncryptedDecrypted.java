import java.io.*;


public class EncryptedDecrypted {
    public void encryptedDecrypted(boolean flag) {

        ConsoleHelper.writeMessage("Введите полный адрес для " + (flag ? "за" : "раз") + "шифровки файла");
        String src = ConsoleHelper.readString();
        ConsoleHelper.writeMessage("Введите ключь");
        int key = ConsoleHelper.readInt();
        ConsoleHelper.writeMessage("Введите полный адрес куда записать результат");
        String dst = ConsoleHelper.readString();
        CaesarCipher caesarCipher = new CaesarCipher();
        try (FileReader fileReader = new FileReader(src);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(dst);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                String result = flag ? caesarCipher.encrypt(string, key) : caesarCipher.decrypt(string, key);
                bufferedWriter.write(result);
                bufferedWriter.newLine();
            }
        } catch (IOException ignore) {
        }
    }
}

