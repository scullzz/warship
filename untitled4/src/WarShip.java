import java.util.Scanner;

public class WarShip {
    static int sh = 1;

    public static void create(int[][] array1, int[][] array2){
        System.out.print(" ");
        for(int i = 0; i < 10; i++){
            System.out.print(i);
        }
        System.out.print("\n") ;
        for(int i =0; i< 10; i++) {
            System.out.print(i);
            for (int j = 0; j < 10; j++) {
                if (array2[i][j] == 1) {
                    if (array1[i][j] == 0) {
                        System.out.print("~");
                    } else if (array1[i][j] == -1) {
                        System.out.print("X");
                    } else {
                        System.out.print(array1[i][j]);
                    }
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }

    }

    public static void second_create(int[][] array3, int[][] array4){
        System.out.print(" ");
        for(int i =0; i < 10; i++){
            System.out.print(i);
        }
        System.out.print("\n");
        for(int i =0; i < 10; i++){
            System.out.print(i);
            for(int j = 0; j < 10; j++) {
                if (array4[i][j] == 1) {
                    if (array3[i][j] == 0) {
                        System.out.print("~");
                    } else if (array3[i][j] == -1) {
                        System.out.print("X");
                    } else {
                        System.out.print(array3[i][j]);
                    }
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }

    }
    //тут идет проверка границ карты и при помощи рандома он вставляет направление чтобы вставить кусок корабля и в массив кораблики записываются палубы
    public static void limit_ship(int[][] array1, int ship_palub, int ship_count, int[] ships){
        boolean limit = true;
        int x;
        int y;
        int dir = 0;
        int tmp_x;
        int tmp_y;
        int tmp_ship = 0;
        while(tmp_ship < ship_count){
            do {
                x = (int)(Math.random() * 10);
                y = (int)(Math.random() * 10);

                tmp_x = x;
                tmp_y = y;

                dir = (int)(Math.random() * 4);

                limit = true;
                for (int i = 0; i < ship_palub; i++) {
                    if (x < 0 || y < 0 || x >= array1.length || y >= array1.length) {
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
            }while(!limit);

            if(limit){
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
    }
    // тоже самое и тут
    public static void second_limit_ship(int[][] array3, int ship_palub, int ship_count, int[] ships) {
        boolean limit = true;
        int x;
        int y;
        int dir = 0;
        int tmp_x;
        int tmp_y;
        int tmp_ship = 0;
        while (tmp_ship < ship_count) {
            do {
                x = (int) (Math.random() * 10);
                y = (int) (Math.random() * 10);

                tmp_x = x;
                tmp_y = y;

                dir = (int) (Math.random() * 4);

                limit = true;
                for (int i = 0; i < ship_palub; i++) {
                    if (x < 0 || y < 0 || x >= array3.length || y >= array3.length) {
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
            }
            while (!limit);

            if (limit) {
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

    }

    //определяется количетсво кораблей и палу
    public static void  second_create_ship(int[][] array3, int[] ships) {
        sh = 1;
        second_limit_ship(array3, 4, 1, ships);
        second_limit_ship(array3, 3, 2, ships);
        second_limit_ship(array3, 2, 3, ships);
        second_limit_ship(array3, 1, 3, ships);
    }
    //карта
    public static void result(int[][] array1, int[][] array2, int[][] array3, int[][] array4) {
        create(array1, array2);
        System.out.print("\n");
        create(array3, array4);
    }
    //сама игра очередь ходов попадение уничтожение
    public static void GAME11(int[][] array1, int[][] array2, int[][] array3, int[][] array4, int[] ships)  {
        boolean game = false;
        int x;
        int y;
        for (int i = 0; i < 1000; i++) {
            result(array1, array2, array3, array4);

            if (i % 2 == 0) {

                System.out.print("First player's move\n");
                System.out.print("Enter your cordinates\n");
                Scanner in = new Scanner(System.in);
                System.out.print("Input the digit: ");
                x = in.nextInt();
                System.out.print("Input the digit: ");
                y = in.nextInt();

                if (array1[x][y] >= 1) {
                    ships[array1[x][y]]--;
                    if (ships[array1[x][y]] <= 0) {
                        System.out.print("The ship was destroyed\n");
                    }
                    else {
                        System.out.print("You hit the ship\n");
                    }
                    array1[x][y] = -1;
                } else {
                    System.out.print("Miss\n");
                }

                array2[x][y] = 1;

                boolean game_over = false;
                for (i = 0; i < array2.length; i++) {
                    for (int j = 0; j < array2.length; j++) {
                        if (array2[i][j] == 1) {
                            game_over = true;
                        }
                    }
                }
                if (game_over == false) {
                    System.out.print("First player - Win\n");
                    break;
                }
            }
            if (i % 2 == 1) {
                System.out.print("Second plater's move\n");
                System.out.print("Enter your cordinates\n");
                Scanner in = new Scanner(System.in);
                System.out.print("Input your digit: ");
                x = in.nextInt();
                System.out.print("Input your digit: ");
                y = in.nextInt();
                if (array3[x][y] >= 1) {
                    ships[array3[x][y]]--;
                    if (ships[array3[x][y]] <= 0) {
                        System.out.print("The ship was destroyed\n");
                    } else {
                        System.out.print("You hit the ship\n");
                    }

                    array3[x][y] = -1;

                } else {
                    System.out.print("Miss\n");
                }

                array4[x][y] = 1;

                boolean game_over = false;
                for (i = 0; i < array4.length; i++) {
                    for (int j = 0; j < array4.length; j++) {
                        if (array4[i][j] == 1) {
                            game_over = true;
                        }
                    }
                }
                if (game_over == false) {
                    System.out.print("Second player - WIN\n");
                    break;
                }
            }

        }
    }
    public static void second_hand_ship(int[][] array3, int ship_palub, int ship_count, int[] ships){
        System.out.print("if you push 0 the ship set to in right direction\n" +
                "if you push 1 the ship set to in top down direction\n" +
                "if you push 2 the ship set to in left direction\n" +
                "if you push 3 the ship set to in upward direction\n");
        boolean limit = true;
        int x;
        int y;
        int dir = 0;
        int tmp_x;
        int tmp_y;
        int tmp_ship = 0;
        while(tmp_ship < ship_count){
            do{
                Scanner in = new Scanner(System.in);
                System.out.print("Input the first digit\n");
                x = in.nextInt();
                System.out.print("Input the second digit\n");
                y = in.nextInt();

                tmp_x = x;
                tmp_y = y;

                System.out.print("Input direction for palubs\n");
                dir = in.nextInt();

                limit = true;
                for(int i =0; i < ship_palub; i++){
                    if(x < 0 || y < 0 || x>= array3.length || y>= array3.length){
                        limit = false;
                        break;
                    }
                    if(dir == 0){
                        x++;
                    }
                    if(dir == 1){
                        y++;
                    }
                    if(dir == 2){
                        x--;
                    }
                    if(dir == 3){
                        y--;
                    }
                }
            }while(!limit);
            if(limit){
                x = tmp_x;
                y = tmp_y;
                for(int i = 0; i < ship_palub; i++){
                    if(dir == 0){
                        array3[x][y] = sh;
                        x++;
                    }
                    if(dir == 1){
                        array3[x][y] = sh;
                        y++;
                    }
                    if(dir == 2){
                        array3[x][y] = sh;
                        x--;
                    }
                    if(dir == 3){
                        array3[x][y] = sh;
                        y--;
                    }
                }
            }
            ships[sh] = ship_palub;
            sh++;
            tmp_ship++;
        }
    }

    public static void  create_hand_ship2(int[][] array3, int[] ships) {
        sh = 1;
        System.out.println("You have to input two coordinates x and y, beginning with 4palub ship, number of the ship - 1");
        System.out.println("3palub ship, number of the ship - 2");
        System.out.println("2palub ship, number of the ship - 3");
        System.out.println("1palub ship, number of the ship - 1");
        second_hand_ship(array3, 4, 1, ships);
        second_hand_ship(array3, 3, 2, ships);
        second_hand_ship(array3, 2, 3, ships);
        second_hand_ship(array3, 1, 3, ships);
    }

    public static void main(String[] args){
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
        create_hand_ship2(a1, s);
        create_hand_ship2(a3, s);
        GAME11(a1, a2, a3, a4, s);
    }
}