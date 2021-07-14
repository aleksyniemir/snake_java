package sample;

import java.util.Random;

public class Podstawka {
    int[][][] board;
    int lenght;

    public Podstawka(int height, int width, int lenght) {
        this.board = new int[height][width][2];
        this.lenght =  lenght;
    }

    public static void main (String [] args) {
        int width = 20;
        int height = 10;
        int lenght = 3;
        Podstawka podstawka = new Podstawka(height, width, lenght);
        String direction = new String("Up");


        podstawka.basicBoard();
        podstawka.showBoard();
        //podstawka.apple(podstawka.board);
        podstawka.step(5, 5, direction);
        podstawka.showBoard();
        podstawka.step(5, 4, direction);
        podstawka.showBoard();
        podstawka.step(5, 3, direction);
        podstawka.showBoard();
        podstawka.step(5, 2, "Right");
        podstawka.showBoard();

    }

    public  void showBoard() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                if (this.board[i][j][0] == 0 )
                    System.out.print("-");
                else if (this.board[i][j][0] == 1)
                    System.out.print("*");
                else
                    System.out.print("o");

            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public  void basicBoard () {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                this.board[i][j][0] = 0;
            }
        }
        //ozywienie komorki
        this.board[5][3][0]=1;
        this.board[5][4][0]=1;
        this.board[5][5][0]=1;

        //czas zycia komorki
        this.board[5][3][1]=1;
        this.board[5][4][1]=2;
        this.board[5][5][1]=3; //glowa weza

        this.board[3][5][0]=2; // apple

    }
    //podstawa poruszania sie weza
    public  void step(int x, int y, String direction) {
        if (direction.equals("Up")) {
           if(board[y - 1][x][0] == 0 || board[y - 1][x][1] == 1 ) {
                board[y - 1][x][0] = 1;
                board[y - 1][x][1] = (this.lenght + 1);
            } else if (board[y - 1][x][0] == 1 && board[y - 1][x][1] > 1) {
                System.out.println("Przejebales gre lol");
            } else if (board[y - 1][x][0] == 2) {
               for (int i = 0; i < this.board.length; i++)
                   for (int j = 0; j < this.board[i].length; j++)
                       if (this.board[i][j][0] == 1)
                           this.board[i][j][1]++;
               this.board[y - 1][x][0] = 1;
           }
        } else
        if (direction.equals("Right")) {
            if(this.board[y - 1][x][0] == 0 || board[y - 1][x][1] == 1 ) {
                this.board[y - 1][x][0] = 1;
                this.board[y - 1][x][1] = (this.lenght + 1);
            } else if (this.board[y - 1][x][0] == 1 && this.board[y - 1][x][1] > 1) {
                System.out.println("Przejebales gre lol");
            } else if (this.board[y - 1][x][0] == 2) {
                for (int i = 0; i < this.board.length; i++)
                    for (int j = 0; j < this.board[i].length; j++)
                        if (this.board[i][j][0] == 1)
                            this.board[i][j][1]++;
                this.board[y - 1][x][0] = 1;
            }
        } else
        if (direction.equals("Down")) {
        } else
        if (direction.equals("Left")) {
        } else {
            System.out.println("Blad w odczytaniu kierunku");
           }

        //zmniejszanie zycia kazdej zyjacej komorki o 1
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                if(this.board[i][j][0] == 1) {
                    this.board[i][j][1]--;
                    if(this.board[i][j][1] == 0) {
                        this.board[i][j][0] = 0;
                    }
                }
            }
        }
    }

    public  void apple() {
        Random rn = new Random();
        int xApple = rn.nextInt(9);
        int yApple = rn.nextInt(9);
        if (this.board[yApple][xApple][0] == 1){
            apple();
        } else if (this.board[yApple][xApple][0] == 0){
            this.board[yApple][xApple][0] = 2;
        } else {
            System.out.println("Blad w apple");
        }
    }
}

