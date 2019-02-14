import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new SimpleMap<>();
        Scanner sc = new Scanner("Дом Машина Дом Собака Квартира Квартира Квартира");
        while (sc.hasNext()) {
            map.put(sc.next(), map.get(sc.next()) + 1);
        }
        map.out();

    }
}