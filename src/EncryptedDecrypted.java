import javax.imageio.IIOException;
import java.io.*;
import java.util.Scanner;

public class EncryptedDecrypted {
    public void encryptedDecrypted(boolean flag){
        if (flag){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите полный адрес для расшифровки файла");
           String src = scanner.nextLine();
            System.out.println("Введите ключь для расшифроки файла");
            int key = Integer.parseInt(scanner.nextLine());
            System.out.println("Введите полный адрес куда записать результат");
            String dst = scanner.nextLine();
            CaesarCipher caesarCipher = new CaesarCipher();
            try (FileReader fileReader = new FileReader(src);
                 BufferedReader bufferedReader = new BufferedReader(fileReader);
                 FileWriter fileWriter = new FileWriter(dst);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
                   while (bufferedReader.ready()) {
                       String string = bufferedReader.readLine();
                       String decrypt = caesarCipher.decrypt(string, key);
                       bufferedWriter.write(decrypt);
                }
            }catch (IOException iioException){
                System.out.println(iioException);
            }

        }else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите полный адрес для зашифровке");
           String src = scanner.nextLine();
            System.out.println("Ведите ключь для рашифровке фаила");
            int key = Integer.parseInt(scanner.nextLine());
            System.out.println("Ведите полный адрес куда записать результат");
            String drc = scanner.nextLine();
            CaesarCipher caesarCipher = new CaesarCipher();
            try (FileReader fileReader = new FileReader(src);
                 BufferedReader bufferedReader = new BufferedReader(fileReader);
                 FileWriter fileWriter = new FileWriter(drc);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
                while (bufferedReader.ready()){
                String string= bufferedReader.readLine();
                    String engrupted = caesarCipher.encrypt(string,key);
                    bufferedWriter.write(engrupted);
                }

            }catch (IOException exception){
                System.out.println(exception);
            }
        }
    }
}
