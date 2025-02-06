import java.util.List;

public class Validator {
    public boolean isValidKey(int key, List<Character> alphabet) {
        return key >= 0 && key < alphabet.size();
    }

}