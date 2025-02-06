// MainApp.java
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Cipher cipher = new Cipher(CaesarCipher.ALPHABET);1
        Validator validator = new Validator();
        BruteForce bruteForce = new BruteForce();
        StatisticalAnalyzer analyzer = new StatisticalAnalyzer();

        while (true) {
            System.out.println("\nВыберите пункт меню: ");
            System.out.println("1. Шифрование текста");
            System.out.println("2. Расшифровка текста с ключом");
            System.out.println("3. Brute force (перебор всех ключей)");
            System.out.println("4. Статистический анализ");
            System.out.println("0. Выход");

            int choice = Integer.parseInt(console.nextLine());

            switch (choice) {
                case 1:  // Шифрование текста
                    System.out.print("Введите текст для шифрования: ");
                    String textToEncrypt = console.nextLine();
                    System.out.print("Введите ключ (целое число): ");
                    int encryptKey = Integer.parseInt(console.nextLine());
                    if (validator.isValidKey(encryptKey, CaesarCipher.ALPHABET)) {
                        String encryptedText = cipher.encrypt(textToEncrypt, encryptKey);
                        System.out.println("Зашифрованный текст: " + encryptedText);
                    } else {
                        System.out.println("Недопустимый ключ.");
                    }
                    break;

                case 2:  // Расшифровка текста с ключом
                    System.out.print("Введите текст для расшифровки: ");
                    String textToDecrypt = console.nextLine();
                    System.out.print("Введите ключ (целое число): ");
                    int decryptKey = Integer.parseInt(console.nextLine());
                    if (validator.isValidKey(decryptKey, CaesarCipher.ALPHABET)) {
                        String decryptedText = cipher.decrypt(textToDecrypt, decryptKey);
                        System.out.println("Расшифрованный текст: " + decryptedText);
                    } else {
                        System.out.println("Недопустимый ключ.");
                    }
                    break;

                case 3:  // Brute force
                    System.out.print("Введите текст для brute force расшифровки: ");
                    String bruteForceText = console.nextLine();
                    bruteForce.decryptByBruteForce(bruteForceText, CaesarCipher.ALPHABET);
                    break;

                case 4:  // Статистический анализ
                    System.out.print("Введите текст для статистического анализа: ");
                    String statText = console.nextLine();
                    int likelyShift = analyzer.findMostLikelyShift(statText, CaesarCipher.ALPHABET);
                    String statDecryptedText = cipher.decrypt(statText, likelyShift);
                    System.out.println("Текст после статистического анализа: " + statDecryptedText);
                    break;

                case 0:  // Выход
                    System.out.println("Выход из программы...");
                    console.close();
                    return;

                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }
}
