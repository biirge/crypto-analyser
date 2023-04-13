import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    public String encrypt(String message) {
        char[] messageCharArray = message.toCharArray();
        char[] answer = new char[messageCharArray.length];
        int border = language.length-key;

        for (int i = 0; i < messageCharArray.length; i++) {
            int newKey = findLetterIndex(messageCharArray[i], language);
            if (newKey >= border) { newKey = newKey+key-language.length;}
            else {newKey += key;}
            answer[i] = language[newKey];
        }
        return String.valueOf(answer);
    }

    public String decrypt(String message) {
        char[] messageCharArray = message.toCharArray();
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
        return String.valueOf(answer);
    }



}
