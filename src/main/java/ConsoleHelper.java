import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;


public class ConsoleHelper {

    private static final BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

    private ConsoleHelper() {
    }

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        try {
            return console.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readInt(){
        return Integer.parseInt(readString());
    }

    public static Path buildFileName(String path, String suffix){
        return null;
    }
}
// вовсём проекте заменить System.out.println на writeMessage
// прочитать метод класса Paths прочитать что такое maven
