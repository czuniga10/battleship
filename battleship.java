import java.util.Random;
import java.util.Scanner;

public class battleship {
    private static int size = 10;
    private static int ships = 5;
    private static int playerShips = ships;
    private static int computerShips = ships;
    public static int[][] board = new int[size][size];


    public static void main(String[] args) {
        System.out.println();
        System.out.println("Battleship Game:");  
        showMap();
        System.out.println();
        System.out.println("Choose your ship coordinates:");
        playerShips();
        showMap();
        computerShips();
        ship();
        battle();
    }

    //Shows map in its current state
    public static void showMap() {
        System.out.println();
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
                if(board[row][col] == 2){
                    System.out.print(" ");
                }
                if(board[row][col] == 3){
                    System.out.print("X");
                }
                if(board[row][col] == 4){
                    System.out.print("*");
                }
                if(board[row][col] == 5){
                    System.out.print("-");
                }
                if(board[row][col] == 6){
                    System.out.print(".");
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

    //Player ships

    public static void playerShips(){
        System.out.println();
        for(int i = 1; i <= ships; i++) {
            deployPlayerShips(i);
        }
        System.out.println();
    }

    public static void deployPlayerShips(int i){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter X Coordinate for Ship " + i + ": ");
        int x = input.nextInt();
        System.out.print("Enter Y Coordinate for Ship " + i + ": ");
        int y = input.nextInt();
        if(x <= 10 && y <= 10 && board[x][y] == 0) {
            board[x][y] = 1;
        }else if(x > 10 || y > 10){
            System.out.print("Invalid Coordinates");
            deployPlayerShips(i);
        }else{
            System.out.println("You already chose these coordinates... try again");
            deployPlayerShips(i);
        }
    }

    //Computer Ships

    public static void computerShips(){
        System.out.println();
        for(int i = 1; i <= ships; i++) {
            deployComputerShips(i);
        }
        System.out.println();
        System.out.println("All Enemy Ships Deployed...");
        System.out.println();
    }

    public static void deployComputerShips(int i){
        Random rand = new Random();
        int x = rand.nextInt(10);
        int y = rand.nextInt(10);
        if(x <= 10 && y <= 10 && board[x][y] == 0) {
            board[x][y] = 2;
            System.out.println("Enemy Ship Deployed... ");
        }else{
            deployComputerShips(i);
        }
    }

    //Battle

    public static void battle(){
        while(playerShips > 0 && computerShips > 0){
            playerMove();
            computerMove();
            showMap();
            System.out.println("Player Ships remaining: " + playerShips + " | Computer Ships remaining: " + computerShips);
            if(playerShips == 0){
                System.out.println("Enemy Wins. Too bad");
                break;
            }else if(computerShips == 0){
                System.out.println("You Win!! Congrats");
            }
        }
    }

    public static void playerMove(){
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter X Coordinate for target: ");
        int x = input.nextInt();
        System.out.print("Enter Y Coordinate for target: ");
        int y = input.nextInt();
        if(x < 10 && y < 10 && board[x][y] == 1) {
            System.out.println("You can't hit your own ship... Try again");
            playerMove();
        }else if(x < 10 && y < 10 && board[x][y] == 2){
            System.out.println("You sunk an enemy ship... Great Shot!!");
            board[x][y] = 3;
            computerShips -= 1;
        }else if(x < 10 && y < 10 && board[x][y] == 0){
            System.out.println("Miss");
            board[x][y] = 4;
        }else{
            System.out.println("Invalid Move... Try again");
            playerMove();
        }
    }

    public static void computerMove(){
        Random rand = new Random();
        System.out.println();
        System.out.println("Computer's turn:");
        int x = rand.nextInt(10);
        int y = rand.nextInt(10);
        if(x < 10 && y < 10 && board[x][y] == 2) {
            computerMove();
        }else if(x <= 10 && y <= 10 && board[x][y] == 1){
            System.out.println("Enemy Sunk one of you ships...");
            board[x][y] = 5;
            playerShips -= 1;
        }else if(x < 10 && y < 10 && board[x][y] == 0 || board[x][y] == 3 || board[x][y] == 4 || board[x][y] == 5){
            System.out.println("Miss");
            board[x][y] = 6;
        }else{
            computerMove();
        }
    }

    public static void ship(){
        System.out.println("                                     # #  ( )");
        System.out.println("                                  ___#_#___|__");
        System.out.println("                              _  |____________|  _");
        System.out.println("                       _=====| | |            | | |==== _");
        System.out.println("                 =====| |.---------------------------. | |====");
        System.out.println("   <--------------------'   .  .  .  .  .  .  .  .  '---------------/");
        System.out.println("     \\                                                             /");
        System.out.println("      \\_____________________________________________Battleship____/");
        System.out.println("  wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
        System.out.println(" wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
        System.out.println("   wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
        System.out.println();
        System.out.println();
        System.out.println("                         PREPARE FOR BATTLE!!!");
    }

}