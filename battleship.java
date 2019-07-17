import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int size = 10;
    private static int ships = 5;
    public static int[][] board = new int[size][size];


    public static void main(String[] args) {
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

            }
            System.out.println("|" + row);
        }
        numberLine();
    }

    public static void numberLine(){
        System.out.print("  ");
        for(int i = 0; i < size; i++){
            System.out.print(i);
        }
        System.out.println();
    }

}