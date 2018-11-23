

import java.util.List;
import java.util.Scanner;

public class ConsoleReader {
    TextAnalyzer analyzer = new JacardTextAnalayzer();
    TextAnalyzer cosAnalyzer = new CosMethod();
    Scanner sc = new Scanner(System.in);
    String consolWord1 = sc.nextLine();
    String consolWord2 = sc.nextLine();
    double coef = analyzer.analyze(new SimpleTextProvider(consolWord1), new SimpleTextProvider(consolWord2));
    double cosCoef = cosAnalyzer.analyze(new SimpleTextProvider(consolWord1), new SimpleTextProvider(consolWord2));
    {
        System.out.println("Джакард: " + coef);
        System.out.println("мера: "+cosCoef);
    }
}