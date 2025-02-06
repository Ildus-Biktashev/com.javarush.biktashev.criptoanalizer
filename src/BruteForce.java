import java.util.List;

public class BruteForce {
    // метод взлома шифра Цезаря
    public void decryptByBruteForce(String encryptedText, List<Character> alphabet) {
        Cipher cipher = new Cipher(alphabet);
        for (int key = 1; key < alphabet.size(); key++) {
            String decryptedText = cipher.decrypt(encryptedText, key);
            System.out.println("Ключ " + key + ": " + decryptedText);
        }
    }
}