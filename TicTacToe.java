/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.Scanner;

public class TicTacToe {
    
    private char[][] board;
    private char currentPlayerMark;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayerMark = 'X';
        initializeBoard();
    }
    
    // Set the board to empty values.
    public void initializeBoard() {
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }
    
    // Print the current board (may be replaced by GUI implementation later)
    public void printBoard() {
        
        System.out.println("-------------");
        
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    
    // Loop through all cells of the board and check if any are empty.
    // If found, return true, otherwise return false.
    public boolean isBoardFull() {
        
        boolean isFull = true;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    isFull = false;
                }
            }
        }
        
        return isFull;
    }
    
    // Check if a player has won. Return X, O, or null (if no winner).
    public char checkForWin() {
        
        // Check horizontal wins.
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return board[i][0];
            }
        }
        
        // Check vertical wins.
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
                return board[0][j];
            }
        }
        
        // Check diagonal wins.
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-') {
            return board[0][2];
        }
        
        return '\0';
    }
    
    // Change player marks back and forth.
    public void changePlayer() {
        
        if (currentPlayerMark == 'X') {
            currentPlayerMark = 'O';
        } else {
            currentPlayerMark = 'X';
        }
    }
    
    // Place a mark at the cell specified by row and col with the mark of the current player.
    public boolean placeMark(int row, int col) {
        
        // Check if row and column are within bounds of the board.
        if ((row >= 0     && row < 3) && (col >= 0 && col < 3)) {
        
        // Check if cell is empty.
        if (board[row][col] == '-') {
            board[row][col] = currentPlayerMark;
            return true;
        }
    }
    
    return false;
}

public static void main(String[] args) {
    
    TicTacToe game = new TicTacToe();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Tic Tac Toe Game Started!");
    game.printBoard();
    
    while (true) {
        System.out.println("Player " + game.currentPlayerMark + ", enter row and column for your move: ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        
        if (game.placeMark(row, col)) {
            game.printBoard();
            
            if (game.checkForWin() != '\0') {
                System.out.println("Congratulations! Player " + game.currentPlayerMark + " has won the game!");
                break;
            } else if (game.isBoardFull()) {
                System.out.println("Game is a draw!");
                break;
            } else {
                game.changePlayer();
            }
        } else {
            System.out.println("Invalid move, try again.");
        }
    }
}
}
