import org.junit.*;

import java.io.File;
import java.util.Scanner;

import static org.junit.Assert.assertTrue;

public class MatrixTest {

    @Test
    public void testFileExists () {
        assertTrue(new File("pyat.txt").exists());
    }

    @Test
    public void testContainsZero () {
        boolean has = false;
        Scanner file = new Scanner("pyat.txt");
        while (file.hasNextInt()) {
            if (file.nextInt() == 0) {
                has = true;
            }
        }
        System.out.println(has);
        assertTrue(has);
    }
}
