
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    TextAnalyzer analyzer = new JacardTextAnalayzer();
    TextAnalyzer cosAnalyzer = new CosMethod();
    File file1 = new File("C:\\home15\\src\\Text1.txt");
    File file2 = new File("C:\\home15\\src\\Text2.txt");
    double coef = analyzer.analyze(new FileTextProvider(file1), new FileTextProvider(file2));
    double cosCoef = cosAnalyzer.analyze(new FileTextProvider(file1), new FileTextProvider(file2));
    {
        System.out.println("Жакард "+coef);
        System.out.println("Косинус "+cosCoef);
    }
}