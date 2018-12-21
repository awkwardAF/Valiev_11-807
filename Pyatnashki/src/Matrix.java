import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
    public static int n;
    static File file = new File("pyat.txt");
    public static int count = 0;

    public static void readFile(int o) throws IOException {
        n = o;
        pt = new int[n][n];
        Scanner scannerfile = new Scanner(file);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
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
        switch (answer) {
            case "random":
                System.out.println("Сколько строк (столбцов) в новой матрице?");
                int q = sc.nextInt();
                readFile(q);
                done = true;
                break;
            case "exit":
                mn.play = false;
                writeFile();
                System.out.println("Thanks for playing");
                return;
            case "type":
                type();
                done = true;
                break;
            case "save":
                saveMatrix();
                done = true;
                break;
            case "undo":
                save(x, y);
                done = true;
                System.out.println("Previous move undone");
                break;
            default:
                try {
                    cell = parseInt(answer);
                } catch (NumberFormatException nfe) {
                    System.err.println("No such command");
                    done = true;
                }
                break;
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
        }
        if (!done) {
            System.err.println("Wrong coordinate");
        }

    }

    private static void saveMatrix() throws IOException {
        writeFile();
        System.out.println("Matrix was saved");
    }

    public static void type() throws IOException {
        int[][] newMatrix = new int[n][n];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMatrix[i][j] = sc.nextInt();
            }
        }
        if (perfect(newMatrix)) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    pt[i][j] = newMatrix[i][j];
                    if (pt[i][j] == 0) {
                        x = i;
                        y = j;
                    }
                }
            }
            writeFile();
            System.out.println("New matrix was successfully saved");
        } else {
            System.err.println("New matrix is built not following the rules, matrix wasn't saved");
        }
    }

    private static boolean perfect(int[][] newOne) {
        boolean re = false;
        int count = 0;
        int sum = 0;
        for (int i = 0; i < n * n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (newOne[j][k] == count) {
                        re = true;
                    }
                }
            }
            count++;
            if (re) {
                sum++;
            }
            re = false;
        }
        if (sum == n * n) {
            return true;
        } else return false;
    }

    public static void randomMatrix(int q) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        boolean added = false;
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < q; j++) {
                while (!added) {
                    int a = ((int) ((Math.random() * q*q)));
                    if (!list.contains(a)) {
                        pt[i][j] = a;
                        if (pt[i][j] == 0) {
                            x = i;
                            y = j;
                        }
                        list.add(a);
                        added = true;
                    }
                }
                added = false;
            }
        }
        System.out.println("Random matrix generated");
        writeFile();
    }


    public static void vivod() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
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
            System.out.println("\u001B[32m" + "Поздравляю, вы прошли игру" + "\u001B[0m");
            mn.play = false;
        }
    }

    public static void save(int x, int y) {
        pt[x][y] = pt[savex][savey];
        pt[savex][savey] = 0;
    }


    private static void writeFile() throws IOException {
        FileWriter file = new FileWriter(new File("pyat.txt"));
        for (int i = 0; i < pt.length; i++) {
            for (int j = 0; j < pt.length; j++) {
                file.write((pt[i][j]) + " ");
            }
            file.write("\r\n");
        }
        file.close();
    }

    public static void readFile() throws IOException {
        int elements = 0;
        int nothing;
        Scanner scannerfile = new Scanner(file);
        while (scannerfile.hasNextInt()) {
            elements++;
            nothing = scannerfile.nextInt();
        }
        n = (int) Math.sqrt(elements);
        for (int i = 0; i < Math.sqrt(elements); i++) {
            for (int j = 0; j < Math.sqrt(elements); j++) {
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

}
/*
0 1
0 2
0 3
0 4
 */