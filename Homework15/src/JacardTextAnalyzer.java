
import java.util.ArrayList;
import java.util.List;

class JacardTextAnalayzer implements TextAnalyzer {
    @Override
    public double analyze(TextProvider text1, TextProvider text2) {
        List<String> list1 = tokenize(text1.getText());
        List<String> list2 = tokenize(text2.getText());
        return jaccardSimilarity(list1, list2);
    }

    private double jaccardSimilarity(List<String> list1, List<String> list2) {
        int wordsCount = 0;
        for (String word : list1) {
            if (list2.contains(word)) {
                wordsCount++;
            }
        }
        return (double) wordsCount / (list1.size() + list2.size() - wordsCount);
    }

    private List<String> tokenize(String text) {
        text = text.replace(",", " ");
        String[] words = text.split(" ");
        List<String> uniqueWords = new ArrayList<>();
        for (String word : words) {
            word = word.toLowerCase();
            if (!uniqueWords.contains(word)) {
                uniqueWords.add(word);
            }
        }
        return uniqueWords;
    }
}