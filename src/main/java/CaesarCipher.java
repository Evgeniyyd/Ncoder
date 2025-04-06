public class CaesarCipher {
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "абвгдеёжзийклмнопрстуфхцчшщъыьэюя" + "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ" +
            ".,\":!? +-*/\\@#$%^&(){}[];'|`~=_©«»—" + "0123456789";

    public String encrypt(String message, int key) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char charAt = message.charAt(i);
            int index = alphabet.indexOf(charAt);
            if (index >= 0) {
                int newIndex = (index + key) % alphabet.length();
                char aChar = newIndex < 0 ? alphabet.charAt(newIndex + alphabet.length()) : alphabet.charAt(newIndex);
                builder.append(aChar);
            }
        }
        return builder.toString();
    }
    public String decrypt(String message, int key) {
        return encrypt(message, key * -1);

    }

    public int getAlphabetLength() {

        return alphabet.length();
    }
}

// дз переписать строчки с 12-по 17 через тернарный оператор
// разобраться почему всё зашифровалось в одну строчку
//написать аналогично класс для расшифровки
// сделать гит хаб новый