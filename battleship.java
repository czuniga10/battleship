import java.util.ArrayList;
import java.util.Scanner;

public class battleship {
    private static int size = 10;
    private static int ships = 5;
    public static int[][] board = new int[size][size];


    public static void main(String[] args) {
        showMap();
        playerShips();
        showMap();
    }

    public static void showMap() {
        numberLine();
        for(int row = 0; row < size; row++){
            System.out.print(row + "|");
            for(int col = 0; col < board[row].length; col++){
                if(board[row][col] == 0){
                    System.out.print(" ");
                }
                if(board[row][col] == 1){
                    System.out.print("@");
                }

            }
            System.out.println("|" + row);
        }
        numberLine();
    }

    public static void playerShips(){
        for(int i = 1; i <= ships; i++) {
            deployShips(i);
        }
    }

    public static void deployShips(int i){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter X Coordinate for Ship " + i + ": ");
        int x = input.nextInt();
        System.out.print("Enter Y Coordinate for Ship " + i + ": ");
        int y = input.nextInt();
        if(x < 10 && y < 10 && board[x][y] == 0) {
            board[x][y] = 1;
        }else if(x > 10 || y > 10){
            System.out.println("Invalid Coordinates... try again");
            deployShips(i);
        }else{
            System.out.println("You already chose these coordinates... try again");
            deployShips(i);
        }

    }
    public static void numberLine(){
        System.out.print("  ");
        for(int i = 0; i < size; i++){
            System.out.print(i);
        }
        System.out.println();
    }
}