import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Matrix {
    private static boolean done;
    public static int savex;
    public static int savey;
    public static int cell;
    static Main mn = new Main();
    public static int[][] pt;
    private static int x;
    private static int y;
    static File file = new File("pyat.txt");
    public static int [][] zero = new int [10][0];
    public static int count = 0;

    public static void readFile(int n, int m) throws FileNotFoundException, IOException {
        pt = new int[n][m];
        Scanner scannerfile = new Scanner(file);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (scannerfile.hasNextInt()) {
                    pt[i][j] = scannerfile.nextInt();
                    if (pt[i][j] == 0) {
                        x = i;
                        y = j;
                    }
                }
            }
        }
    }

    public static void shift() throws IOException {
        done = false;
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        if (answer.equals("exit")) {
            mn.play = false;
            return;
        }
        else if (answer.equals("type")) {
            type();
            done = true;
        }
        else if (answer.equals("undo")){
            save(x, y);
            done = true;
            System.out.println("Previous move undone");
        }
        else {
            cell = parseInt(answer);
        }
        if (cell / 10 + 1 == x && cell % 10 == y) {
            pt[x][y] = pt[cell / 10][cell % 10];
            pt[cell / 10][cell % 10] = 0;
            x = cell / 10;
            y = cell % 10;
            savex = cell / 10 + 1;
            savey = cell % 10;
            done = true;
        } else if (cell / 10 - 1 == x && cell % 10 == y) {
            pt[x][y] = pt[cell / 10][cell % 10];
            pt[cell / 10][cell % 10] = 0;
            x = cell / 10;
            y = cell % 10;
            savex = cell / 10 - 1;
            savey = cell % 10;
            done = true;
        } else if (cell / 10 == x && cell % 10 + 1 == y) {
            pt[x][y] = pt[cell / 10][cell % 10];
            pt[cell / 10][cell % 10] = 0;
            x = cell / 10;
            y = cell % 10;
            savex = cell / 10;
            savey = cell % 10 + 1;
            done = true;
        } else if (cell / 10 == x && cell % 10 - 1 == y) {
            pt[x][y] = pt[cell / 10][cell % 10];
            pt[cell / 10][cell % 10] = 0;
            x = cell / 10;
            y = cell % 10;
            savex = cell / 10;
            savey = cell % 10 - 1;
            done = true;
        } if (!done) {
            System.out.println("Wrong coordinate");
        }
        vivod();
    }

    public static void type() throws IOException {
        boolean hasZero = false;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < pt.length; i++) {
            for (int j = 0; j < pt.length; j++) {
                pt[i][j] = sc.nextInt();
                if (pt[i][j] == 0) {
                    hasZero = true;
                }
            }
        }
        if (hasZero) {
            writeFile();
            System.out.println("New matrix was successfully saved");
        }
        else {
            System.out.println("New matrix doesn't contain Zero, matrix wasn't saved");
        }
    }


    public static void vivod() {
        for (int i = 0; i < pt.length; i++) {
            for (int j = 0; j < pt.length; j++) {
                System.out.format("%5d", pt[i][j]);
            }
            System.out.println();
        }
    }

    public static void check() {
        boolean completed = true;
        int count = 0;
        for (int i = 0; i < pt.length; i++) {
            for (int j = 0; j < pt.length; j++) {
                if (pt[i][j] != count++) {
                    completed = false;
                }
            }
        }
        if (completed) {
            System.out.println("Поздравляю, вы прошли игру");
            mn.play = false;
        }
    }

    public static void save (int x,int y) {
        pt[x][y] = pt[savex][savey];
        pt[savex][savey] = 0;
    }


    public static void writeFile() throws IOException {
        FileWriter file = new FileWriter(new File("pyat.txt"));
        for (int i = 0; i < pt.length; i++) {
            for (int j = 0; j < pt.length; j++) {
                file.write(String.valueOf(pt[i][j]) + " ");
            }
            file.write("\r\n");
        }
        file.close();
    }

}
/*
0 1
0 2
0 3
0 4
 */