import java.util.Scanner;

public class WarShip {
    static int sh = 1;

    static void help_create(int[][] array1){
        for(int i =0; i < array1.length; i++){
            for(int j = 0; j< array1[i].length; j++){
                if(array1[i][j] == 0){
                    System.out.println("~");
                }
                else if(array1[i][j] == -1){
                    System.out.println("X");
                }
                else{
                    System.out.println(array1[i][j]);
                }
            }
        }
    }

    static void second_help_create(int[][] array3){
        for(int i =0; i< array3.length; i++){
            for(int j = 0; j < array3[i].length; i++){
                if(array3[i][j] == 0){
                    System.out.println("~");
                }
                else if (array3[i][j] == -1) {
                    System.out.println("X");
                }
                else{
                    System.out.println(array3[i][j]);
                }
            }
        }
    }

    static void create(int[][] array1, int array2[][]){
        System.out.println(" ");
        for(int i = 0; i < array1.length; i++){
            System.out.println(i);
        }
        System.out.println("\n") ;
        for(int i =0; i< array1.length; i++){
            System.out.println(i);
            for(int j = 0; j < array1[i].length; j++){
                if(array2[i][j] == 1){
                    if(array1[i][j] == 0){
                        System.out.println("~");
                    }
                    else if(array1[i][j] == -1){
                        System.out.println("X");
                    }
                    else{
                        System.out.println(array1[i][j]);
                    }
                }
                else{
                    System.out.println(" ");
                }
                System.out.println("\n");
            }
        }
    }

    static void second_create(int[][] array3, int[][] array4){
        System.out.println(" ");
        for(int i =0; i < array3.length; i++){
            System.out.print(i);
        }
        System.out.print("\n");
        for(int i =0; i < array3.length; i++){
            System.out.println(i);
            for(int j = 0; j < array3[i].length; j++){
                if(array4[i][j] == 1){
                    if(array3[i][j] == 0){
                        System.out.println("~");
                    }
                    else if(array3[i][j] == -1){
                        System.out.println("X");
                    }
                    else {
                        System.out.println(array3[i][j]);
                    }
                }
                else{
                    System.out.println(" ");
                }
                System.out.println("\n");
            }
        }
    }
    //тут идет проверка границ карты и при помощи рандома он вставляет направление чтобы вставить кусок корабля и в массив кораблики записываются палубы
    static int limit_ship(int[][] array1, int ship_palub, int ship_count, int[] ships){
        boolean limit = true;
        int x;
        int y;
        int dir = 0;
        int tmp_x;
        int tmp_y;
        int tmp_ship = 0;
        while(tmp_ship < ship_count){
            do {
                x = (int) (Math.random() * 10);
                y = (int) (Math.random() * 10);
                System.out.println("X coordinate " + x + " Y coordinate " + y);
                tmp_x = x;
                tmp_y = y;

                dir = (int) (Math.random() * 5);

                limit = true;
                for (int i = 0; i < ship_palub; i++) {
                    if (x < 0 || y < 0 || x >= array1.length - 1 || y >= array1.length - 1) {
                        limit = false;
                        break;
                    }
                    if (array1[x][y] >= 1||
                            array1[x][y + 1] >= 1 ||
                            array1[x][y-1] >= 1 ||
                            array1[x + 1][y] >= 1 ||
                            array1[x + 1][y + 1] >= 1 ||
                            array1[x + 1][y - 1] >= 1 ||
                            array1[x - 1][y] >= 1 ||
                            array1[x - 1][y + 1] >= 1 ||
                            array1[x - 1][y - 1] >= 1) {
                        limit = false;
                        break;
                    }
                    if (dir == 0) {
                        x++;
                    }
                    if (dir == 1) {
                        y++;
                    }
                    if (dir == 2) {
                        x--;
                    }
                    if (dir == 3) {
                        y--;
                    }
                }
            }while(limit != true);

            if(limit == true){
                x = tmp_x;
                y = tmp_y;
                for(int i = 0; i < ship_palub; i++){
                    if(dir == 0){
                        array1[x][y] = sh;
                        x++;
                    }
                    if (dir == 1) {
                        array1[x][y] = sh;
                        y++;
                    }
                    if (dir == 2) {
                        array1[x][y] = sh;
                        x--;
                    }
                    if (dir == 3) {
                        array1[x][y] = sh;
                        y--;
                    }
                }
            }
            ships[sh] = ship_palub;
            sh++;
            tmp_ship++;

        }
        return array1[array1.length-1][array1.length-1];
    }
    // тоже самое и тут
    static int second_limit_ship(int[][] array3, int ship_palub, int ship_count, int ships[]){
        boolean limit = true;
        int x;
        int y;
        int dir = 0;
        int tmp_x;
        int tmp_y;
        int tmp_ship = 0;
        while (tmp_ship < ship_count) {
            do {
                x = (int)(Math.random() * 11);
                y = (int)(Math.random() * 11);

                tmp_x = x;
                tmp_y = y;

                dir = (int)(Math.random() * 11);

                limit = true;
                for (int i = 0; i < ship_palub; i++) {
                    if (x < 0 || y < 0 || x >= array3.length || y >= array3.length) {
                        limit = false;
                        break;
                    }
                    if (array3[x][y] >= 1 ||
                            array3[x][y + 1] >= 1 ||
                            array3[x][y - 1] >= 1 ||
                            array3[x + 1][y] >= 1 ||
                            array3[x + 1][y + 1] >= 1 ||
                            array3[x + 1][y - 1] >= 1 ||
                            array3[x - 1][y] >= 1 ||
                            array3[x - 1][y + 1] >= 1 ||
                            array3[x - 1][y - 1] >= 1)
                    {
                        limit = false;
                        break;
                    }
                    if (dir == 0) {
                        x++;
                    }
                    if (dir == 1) {
                        y++;
                    }
                    if (dir == 2) {
                        x--;
                    }
                    if (dir == 3) {
                        y--;
                    }
                }
            } while (limit != true);

            if (limit == true) {
                x = tmp_x;
                y = tmp_y;
                for (int i = 0; i < ship_palub; i++) {
                    if (dir == 0) {
                        array3[x][y] = sh;
                        x++;
                    }
                    if (dir == 1) {
                        array3[x][y] = sh;
                        y++;
                    }
                    if (dir == 2) {
                        array3[x][y] = sh;
                        x--;
                    }
                    if (dir == 3) {
                        array3[x][y] = sh;
                        y--;
                    }
                }
            }
            ships[sh] = ship_palub;
            sh++;
            tmp_ship++;
        }

        return array3[array3.length][array3.length];
    }
    //определяется количетсво кораблей и палуб
    static int create_ship(int array1[][], int ships[]) {
        limit_ship(array1, 4, 1, ships);
        limit_ship(array1, 3, 2, ships);
        limit_ship(array1, 2, 3, ships);
        limit_ship(array1, 1, 3, ships);
        return array1[array1.length][array1.length];
    }

    static int  second_create_ship(int array3[][], int ships[]) {
        sh = 1;
        second_limit_ship(array3, 4, 1, ships);
        second_limit_ship(array3, 3, 2, ships);
        second_limit_ship(array3, 2, 3, ships);
        second_limit_ship(array3, 1, 3, ships);
        return array3[array3.length][array3.length];
    }
    //карта
    static void result(int array1[][], int array2[][], int array3[][], int array4[][]) {
        create(array1, array2);
        System.out.println("\n");
        second_create(array3, array4);
    }
    //сама игра очередь ходов попадение уничтожение
    static void GAME11(int array1[][], int array2[][], int array3[][], int array4[][], int ships[]) throws InterruptedException {
        boolean game = false;
        int x;
        int y;
        for (int i = 0; i < 1000; i++) {
            result(array1, array2, array3, array4);

            if (i % 2 == 0) {

                System.out.println("First player's move\n");
                System.out.println("Enter your cordinates\n");
                Scanner in = new Scanner(System.in);
                System.out.print(" ");
                x = in.nextInt();
                System.out.print(" ");
                y = in.nextInt();

                if (array1[x][y] >= 1) {
                    ships[array1[x][y]]--;
                    if (ships[array1[x][y]] <= 0) {
                        System.out.println("The ship was destroyed\n");
                    }
                    else {
                        System.out.println("You hit the ship\n");
                    }
                    array1[x][y] = -1;
                }
                else {
                    System.out.println("Miss\n");
                }

                array2[x][y] = 1;

                if (x == 33 && y == 33) {
                    System.out.println("You wanna quit the game\n");
                    int quit;
                    System.out.println("0 - stay)\n");
                    System.out.println("1 - quit\n");
                    System.out.print("Input a digit: ");
                    quit = in.nextInt();
                    if (quit == 0) {
                        System.out.println("Cool\n");
                    }
                    else if (quit == 1) {
                        break;
                    }
                }

                boolean game_over = false;
                for (i = 0; i < array1.length; i++) {
                    for (int j = 0; j < array1.length; j++) {
                        if (array1[i][j] == 1) {
                            game_over = true;
                        }
                    }
                }
                if (game_over == false){
                    System.out.println("First player - Win\n");
                    break;
                }
            }
            if (i % 2 == 1) {
                System.out.println("Second plater's move\n");
                System.out.println("Enter your cordinates\n");
                Scanner in = new Scanner(System.in);
                System.out.print("Input your digit: ");
                x = in.nextInt();
                System.out.print("Input your digit: ");
                y = in.nextInt();
                if (array3[x][y] >= 1) {
                    ships[array3[x][y]]--;
                    if (ships[array3[x][y]] <= 0) {
                        System.out.println("The ship was destroyed\n");
                    }
                    else {
                        System.out.println("You hit the ship\n");
                    }

                    array3[x][y] = -1;

                }
                else {
                    System.out.println("Miss\n");
                }

                array4[x][y] = 1;

                if (x == 33 && y == 33) {
                    System.out.print("YOU WANNA QUIT THE GAME!!!\n");
                    System.out.println("You wanna quit the game\n");
                    int quit;
                    System.out.println("0 - stay)\n");
                    System.out.println("1 - quit\n");
                    System.out.print("Input a digit: ");
                    quit = in.nextInt();
                    if (quit == 0) {
                        System.out.println("cool\n");
                    }
                    else if (quit == 1) {
                        break;
                    }
                }

                boolean game_over = false;
                for (i = 0; i < array1.length; i++) {
                    for (int j = 0; j < array1.length; j++) {
                        if (array3[i][j] == 1) {
                            game_over = true;
                        }
                    }
                }
                if (game_over == false) {
                    System.out.println("Second player - WIN\n");
                    break;
                }
            }

            Thread.sleep(500);

        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[][] a1 = new int[10][10];
        int[][] a2 = new int[10][10];
        int[][] a3 = new int[10][10];
        int[][] a4 = new int[10][10];
        int[] s = new int[10];
        for(int i =0; i < 10;i++){
            for(int j = 0; j < 10; j++){
                a1[i][j] = 0;
                a2[i][j] = 0;
                a3[i][j] = 0;
                a4[i][j] = 0;
            }
        }
        for(int i =0; i < 10; i++){
            s[i] = 0;
        }
        create_ship(a1, s);
        second_create_ship(a3, s);
        GAME11(a1, a3, a2, a4, s);
    }
}
