import java.util.Arrays;

public class CaesarCipher {

    int key;
    char[] language;

    public CaesarCipher(int key, char[] alphabet) {
        this.key = key;
        this.language = alphabet;

    }

    private int findLetterIndex(char c, char[] language) {
        int i = 0;
        for (char l : language) {
            if (c == l) {return i;}
            else i++;
        }
        return  i;

    }

    private void returnCase(char[] origin, char[] text) {
        for (int i = 0; i < origin.length; i++) {
            if (Character.isUpperCase(origin[i])) {
                text[i] = Character.toUpperCase(text[i]);
            }
        }
    }

    private void ignoreCase(char[] text) {
        for (int i = 0; i < text.length; i++) {
            if (Character.isUpperCase(text[i])) {
                text[i] = Character.toLowerCase(text[i]);
            }
        }
    }

    public String encrypt(String message) {
        char[] messageCharArray = message.toCharArray();
        char[] messageCharArrayCopy = Arrays.copyOf(messageCharArray, messageCharArray.length);
        ignoreCase(messageCharArray);
        char[] answer = new char[messageCharArray.length];
        int border = language.length-key;

        for (int i = 0; i < messageCharArray.length; i++) {
            int newKey = findLetterIndex(messageCharArray[i], language);
            if (newKey >= border) { newKey = newKey+key-language.length;}
            else {newKey += key;}
            answer[i] = language[newKey];
        }
        returnCase(messageCharArrayCopy, answer);
        return String.valueOf(answer);
    }

    public String decrypt(String message) {
        char[] messageCharArray = message.toCharArray();
        char[] messageCharArrayCopy = Arrays.copyOf(messageCharArray, messageCharArray.length);
        ignoreCase(messageCharArray);
        char[] answer = new char[messageCharArray.length];
        int border = key;

        for (int i = 0; i < messageCharArray.length; i++) {
            int newKey = findLetterIndex(messageCharArray[i], language);
            if (newKey < border) {
                newKey = language.length - (border - newKey);
            }
            else { newKey -= key; }
            answer[i] = language[newKey];

        }
        returnCase(messageCharArrayCopy, answer);
        return String.valueOf(answer);
    }



}
