import java.io.File;
import java.util.List;

public class Validator {
    public boolean isValidKey(int key, List<Character> alphabet) {
        return key >= 0 && key < alphabet.size();
    }

    public boolean isFileExists(String filePath) {
        File file = new File(filePath);
        return !file.exists();
    }
}