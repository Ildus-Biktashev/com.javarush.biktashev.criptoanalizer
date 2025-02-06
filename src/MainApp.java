import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Cipher cipher = new Cipher(CaesarCipher.ALPHABET);
        Validator validator = new Validator();
        BruteForce bruteForce = new BruteForce();
        FileManager fileManager = new FileManager();

        while (true) {
            System.out.println("\nВыберите пункт меню: ");
            System.out.println("1. Шифрование текста");
            System.out.println("2. Расшифровка текста с ключом");
            System.out.println("3. Brute force (перебор всех ключей)");
            System.out.println("4. Шифрование файла");
            System.out.println("5. Расшифровка файла с ключом");
            System.out.println("0. Выход");

            try {
                int choice = Integer.parseInt(console.nextLine());

                switch (choice) {
                    case 1:  // шифрование текста
                        System.out.print("Введите текст для шифрования: ");
                        String textToEncrypt = console.nextLine();

                        System.out.print("Введите ключ (целое число): ");
                        int encryptKey = Integer.parseInt(console.nextLine());

                        if (validator.isValidKey(encryptKey, CaesarCipher.ALPHABET)) {
                            String encryptedText = cipher.encrypt(textToEncrypt, encryptKey);
                            System.out.println("Зашифрованный текст: " + encryptedText);
                        } else {
                            System.out.println("Недопустимый ключ. Введите число от 0 до " + (CaesarCipher.ALPHABET.size() - 1));
                        }
                        break;

                    case 2:  // расшифровка текста с ключом
                        System.out.print("Введите текст для расшифровки: ");
                        String textToDecrypt = console.nextLine();

                        System.out.print("Введите ключ (целое число): ");
                        int decryptKey = Integer.parseInt(console.nextLine());

                        if (validator.isValidKey(decryptKey, CaesarCipher.ALPHABET)) {
                            String decryptedText = cipher.decrypt(textToDecrypt, decryptKey);
                            System.out.println("Расшифрованный текст: " + decryptedText);
                        } else {
                            System.out.println("Недопустимый ключ. Введите число от 0 до " + (CaesarCipher.ALPHABET.size() - 1));
                        }
                        break;

                    case 3:  // brute force
                        System.out.print("Введите текст для brute force расшифровки: ");
                        String bruteForceText = console.nextLine();
                        bruteForce.decryptByBruteForce(bruteForceText, CaesarCipher.ALPHABET);
                        break;

                    case 4: // шифрование файла
                        System.out.print("Введите путь к файлу для шифрования: ");
                        String inputFileEncrypt = console.nextLine();
                        if (validator.isFileExists(inputFileEncrypt)) {
                            System.out.println("Файл не существует.");
                            break;
                        }
                        System.out.print("Введите ключ (целое число): ");
                        int fileEncryptKey = Integer.parseInt(console.nextLine());
                        if (validator.isValidKey(fileEncryptKey, CaesarCipher.ALPHABET)) {
                            String fileContentToEncrypt = fileManager.readFile(inputFileEncrypt);
                            String encryptedFileContent = cipher.encrypt(fileContentToEncrypt, fileEncryptKey);
                            System.out.print("Введите путь для сохранения зашифрованного файла: ");
                            String outputFileEncrypt = console.nextLine();
                            fileManager.writeFile(encryptedFileContent, outputFileEncrypt);
                            System.out.println("Файл успешно зашифрован и сохранён в " + outputFileEncrypt);
                        } else {
                            System.out.println("Недопустимый ключ.");
                        }
                        break;

                    case 5:  // расшифровка файла с ключом
                        System.out.print("Введите путь к файлу для расшифровки: ");
                        String inputFileDecrypt = console.nextLine();
                        if (validator.isFileExists(inputFileDecrypt)) {
                            System.out.println("Файл не существует.");
                            break;
                        }
                        System.out.print("Введите ключ (целое число): ");
                        int fileDecryptKey = Integer.parseInt(console.nextLine());
                        if (validator.isValidKey(fileDecryptKey, CaesarCipher.ALPHABET)) {
                            String fileContentToDecrypt = fileManager.readFile(inputFileDecrypt);
                            String decryptedFileContent = cipher.decrypt(fileContentToDecrypt, fileDecryptKey);
                            System.out.print("Введите путь для сохранения расшифрованного файла: ");
                            String outputFileDecrypt = console.nextLine();
                            fileManager.writeFile(decryptedFileContent, outputFileDecrypt);
                            System.out.println("Файл успешно расшифрован и сохранён в " + outputFileDecrypt);
                        } else {
                            System.out.println("Недопустимый ключ.");
                        }
                        break;

                    case 0:
                        System.out.println("Выход из программы...");
                        console.close();
                        return;

                    default:
                        System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода! Пожалуйста, введите число.");
            } catch (Exception e) {
                System.out.println("Произошла ошибка: " + e.getMessage());
            }
        }
    }
}
