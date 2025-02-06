import java.util.List;

public class Cipher {
    private final List<Character> alphabet;

    public Cipher(List<Character> alphabet) {
        this.alphabet = alphabet;
    }
// метод шифрование текста
    public String encrypt(String text, int shift) {
        StringBuilder encryptedText = new StringBuilder();
        for (char character : text.toCharArray()) {
            encryptedText.append(shiftCharacter(character, shift));
        }
        return encryptedText.toString();
    }
// метод расшифровка текста
    public String decrypt(String encryptedText, int shift) {
        return encrypt(encryptedText, -shift);
    }
// метод сдвиг символа
    private char shiftCharacter(char character, int shift) {
        int index = alphabet.indexOf(character);
        if (index == -1) {
            return character;
        }
        int shiftedIndex = (index + shift + alphabet.size()) % alphabet.size();
        return alphabet.get(shiftedIndex);
    }
}