public class Main {
    public static void main(String[] args) {

        String text = "семен увольняйся будем гонять личесс";

        CaesarCipher cipher = new CaesarCipher(5 , Alphabet.ru);

        System.out.println(cipher.encrypt(text));
        System.out.println(cipher.decrypt(cipher.encrypt(text)));
    }
}