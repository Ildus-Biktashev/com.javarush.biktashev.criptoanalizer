import java.util.List;

public class Cipher {
    private List<Character> alphabet;

    public Cipher(List<Character> alphabet) {
        this.alphabet = alphabet;
    }

    public String encrypt(String text, int shift) {
        StringBuilder encryptedText = new StringBuilder();
        for (char character : text.toCharArray()) {
            encryptedText.append(shiftCharacter(character, shift));
        }
        return encryptedText.toString();
    }

    public String decrypt(String encryptedText, int shift) {
        return encrypt(encryptedText, -shift);
    }

    private char shiftCharacter(char character, int shift) {
        int index = alphabet.indexOf(character);
        if (index == -1) {
            return character; // Символ не найден в алфавите
        }
        int shiftedIndex = (index + shift + alphabet.size()) % alphabet.size();
        return alphabet.get(shiftedIndex);
    }
}