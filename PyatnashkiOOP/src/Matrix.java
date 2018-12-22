import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Matrix {

    private boolean loggedIn = true;
    private boolean saved = false;
    private int saveX;
    private int saveY;
    private int size;
    private int zeroX;
    private int zeroY;
    private int[][] pt;
    private String username;
    private File file;


    boolean getSaved () {
        return saved;
    }

    void setSaved (boolean q) {
        saved = q;
    }

    void setUsername (String username) {
        this.username = username;
        file = new File(username + ".txt");
    }

    String getUsername () {
        return username;
    }

    int getSaveX() {
        return saveX;
    }

    int getSaveY() {
        return saveY;
    }

    int getSize() {
        return size;
    }

    public int getZeroX() {
        return zeroX;
    }

    public int getZeroY() {
        return zeroY;
    }

    void setSize(int n) {
        pt = new int[n][n];
        this.size = n;
    }

    private void setZeroX(int zeroX) {
        this.zeroX = zeroX;
    }

    private void setZeroY(int zeroY) {
        this.zeroY = zeroY;
    }

    public void readFile() throws FileNotFoundException {
        Scanner fileReader = new Scanner(file);
        int elements = 0;
        int nothing;
        while (fileReader.hasNextInt()) {
            elements++;
            fileReader.nextInt();
        }
        if (Math.sqrt(elements) % 1 == 0) {
            setSize((int) Math.sqrt(elements));
        } else {
            System.err.println(getUsername() + ", для того, чтобы продолжить игру, разберитесь с матрицей в текстовом файле, она не квадратная");
            System.exit(2);
        }
        Scanner reader = new Scanner(file);
        for (int i = 0; i < Math.sqrt(elements); i++) {
            for (int j = 0; j < Math.sqrt(elements); j++) {
                if (reader.hasNextInt()) {
                    pt[i][j] = reader.nextInt();
                    if (pt[i][j] == 0) {
                        setZeroX(i);
                        setZeroY(j);
                    }
                }
            }
        }
        if (!perfect(pt)) {
            System.err.println(getUsername() + ", количество элементотв в матрице верно, однако она составлена не верно, ну-ка разберитесь");
            System.exit(3);
        }
        out();
    }

    private void out() {
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                System.out.format("%5d", pt[i][j]);
            }
            System.out.println();
        }
    }

    public void random() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Сколько строк (столбцов) вы хотите в матрице?");
        int n = sc.nextInt();
        setSize(n);
        ArrayList<Integer> list = new ArrayList<>();
        boolean added = false;
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                while (!added) {
                    int a = ((int) ((Math.random() * getSize() * getSize())));
                    if (!list.contains(a)) {
                        pt[i][j] = a;
                        if (pt[i][j] == 0) {
                            setZeroX(i);
                            setZeroY(j);
                        }
                        list.add(a);
                        added = true;
                    }
                }
                added = false;
            }
        }
        System.out.println("Новая матрица размерами " + getSize() + "x" + getSize() + " была сгенерирована");
        out();
    }

    public void undo() {
        pt[getZeroX()][getZeroY()] = pt[getSaveX()][getSaveY()];
        pt[getSaveX()][getSaveY()] = 0;
        System.out.println("Ход успешно отменён");
    }

    public void type(Matrix matrix) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Какие размеры новой матрицы?");
        int n = sc.nextInt();
        System.out.println("Вводите элементы");
        int[][] newMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMatrix[i][j] = sc.nextInt();
            }
        }
        if (perfect(newMatrix)) {
            matrix.setSize(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    pt[i][j] = newMatrix[i][j];
                    if (pt[i][j] == 0) {
                        setZeroX(i);
                        setZeroY(j);
                    }
                }
            }
            System.out.println("Новая матрица была успешно сохранена, для сохранения в текстовый документ напишите \"save\"");
            out();
        } else {
            System.err.println("С новой матрицой что-то явно не так");
        }
    }

    private static boolean perfect(int[][] newOne) {
        boolean re;
        int count = 0;
        for (int i = 0; i < newOne.length * newOne.length; i++) {
            re = false;
            for (int j = 0; j < newOne.length; j++) {
                for (int k = 0; k < newOne.length; k++) {
                    if (newOne[j][k] == count) {
                        re = true;
                    }
                }
            }
            count++;
            if (!re) {
                return false;
            }
        }
        return true;
    }


    public void writeFile() throws IOException {
        FileWriter file = new FileWriter(new File(getUsername() + ".txt"));
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                file.write((pt[i][j]) + " ");
            }
            file.write("\r\n");
        }
        file.close();
        System.out.println("Игра сохранена и будет доступна при следующем запуске игры");
    }

    public void shift(int coordinates) {
        int newX = coordinates / 10;
        int newY = coordinates % 10;
        if (newX + 1 == getZeroX() && newY == getZeroY()) {
            pt[getZeroX()][getZeroY()] = pt[newX][newY];
            pt[newX][newY] = 0;
            setZeroX(newX);
            setZeroY(newY);
            saveX = newX + 1;
            saveY = newY;
        } else if (newX - 1 == getZeroX() && newY == getZeroY()) {
            pt[getZeroX()][getZeroY()] = pt[newX][newY];
            pt[newX][newY] = 0;
            setZeroX(newX);
            setZeroY(newY);
            saveX = newX - 1;
            saveY = newY;
        } else if (newX == getZeroX() && newY + 1 == getZeroY()) {
            pt[getZeroX()][getZeroY()] = pt[newX][newY];
            pt[newX][newY] = 0;
            setZeroX(newX);
            setZeroY(newY);
            saveX = newX;
            saveY = newY + 1;
        } else if (newX == getZeroX() && newY - 1 == getZeroY()) {
            pt[getZeroX()][getZeroY()] = pt[newX][newY];
            pt[newX][newY] = 0;
            setZeroX(newX);
            setZeroY(newY);
            saveX = newX;
            saveY = newY - 1;
        }
        if (check()) {
            System.exit(1);
        }
        out();
    }

    public boolean check() {
        boolean completed = true;
        int count = 0;
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                if (pt[i][j] != count++) {
                    completed = false;
                }
            }
        }
        if (completed) {
            System.out.println("\u001B[32m" + "Поздравляю, вы прошли игру" + "\u001B[0m");
        }
        out();
        return completed;
    }


}
