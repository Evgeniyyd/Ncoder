import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберете действия в видя его номер");
            System.out.println("1. Зашифровать текст в файле");
            System.out.println("2. Расшифровать текст в файле");
            System.out.println("3. Подобрать ключь используя метод перебора");
            System.out.println("4. Расшифровать текс в файле используя синтактический анализ текста");
            System.out.println("5. выход из програмы");

            String string = scanner.nextLine();
            if (string.equals("1")) {
                EncryptedDecrypted encryptedDecrypted = new EncryptedDecrypted();
                encryptedDecrypted.encryptedDecrypted(true);
            } else if (string.equals("2")) {
                EncryptedDecrypted encryptedDecrypted = new EncryptedDecrypted();
                encryptedDecrypted.encryptedDecrypted(false);
            } else if (string.equals("3")) {
                System.out.println("action");
            } else if (string.equals("4")) {
                System.out.println("action");
            } else if (string.equals("5")) {
                return;
            }


        }
    }
}
