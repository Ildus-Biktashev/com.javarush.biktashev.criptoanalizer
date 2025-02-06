import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticalAnalyzer {
    public int findMostLikelyShift(String encryptedText, List<Character> alphabet) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : encryptedText.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        char mostFrequentChar = encryptedText.charAt(0);
        int maxFrequency = 0;

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostFrequentChar = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }

        char commonChar = 'о'; // Самая частая буква в русском языке
        int encryptedIndex = alphabet.indexOf(mostFrequentChar);
        int commonIndex = alphabet.indexOf(commonChar);

        return (encryptedIndex - commonIndex + alphabet.size()) % alphabet.size();
    }
}