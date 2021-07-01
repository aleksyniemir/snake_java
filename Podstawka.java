package sample;

public class Podstawka {
    int[][][] board;

    public Podstawka(int height, int width) {
        board = new int[height][width][2];
    }

    public static void main (String [] args) {
        int width = 20;
        int height = 10;
        int lenght = 3;
        Podstawka podstawka = new Podstawka(height, width);
        String direction = new String("Up");

        basicBoard(podstawka.board);
        showBoard(podstawka.board);
        step(5, 5, direction, podstawka.board, lenght);
        showBoard(podstawka.board);
        step(5, 6, direction, podstawka.board, lenght);
        showBoard(podstawka.board);
    }

    public static void showBoard(int [][][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j][0] == 0 ) {
                    System.out.print("-");
                } else if (board[i][j][0] == 1)
                    System.out.print("*");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void basicBoard (int[][][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j][0] = 0;
            }
        }
        //ozywienie komorki
        board[5][3][0]=1;
        board[5][4][0]=1;
        board[5][5][0]=1;

        //czas zycia komorki
        board[5][3][1]=1;
        board[5][4][1]=2;
        board[5][5][1]=3; //glowa weza
    }

    public static void step(int x, int y, String direction, int [][][] board, int lenght) {
        if (direction.equals("Up")) {
           if(board[y - 1][x][0] == 0 || board[y - 1][x][1] == 1 ) {
                board[y - 1][x][0] = 1;
                board[y - 1][x][1] = (lenght + 1);

            } else if (board[y - 1][x][0] == 1 && board[y - 1][x][1] > 1) {
                System.out.println("Przejebales gre lol");
            }
           else if (board[y + 1][x][0] == 2) {
               System.out.println("japko");
           }
        } else
        if (direction.equals("Right")) {
        } else
        if (direction.equals("Down")) {
        } else
        if (direction.equals("Left")) {
        } else {
            System.out.println("Blad w odczytaniu kierunku");
           }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j][0] == 1) {
                    board[i][j][1]--;
                    if(board[i][j][1] == 0) {
                        board[i][i][0] = 0;
                    }
                }
            }
        }
    }
}

