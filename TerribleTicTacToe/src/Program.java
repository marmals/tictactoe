import Models.Board;


import Controllers.Controller;
import Controllers.Player;

public class Program {
    public static void main(String[] args){
        int numberOfPlayers = 2;
        int boardSize = 3;
        int streakToWin = 3;

        Board board = new Board(boardSize,boardSize);
        Player players[] = new Player[numberOfPlayers];

        players[0] = new Player("Martin", "X");
        players[1] = new Player("Johannes", "O");
        //players[2] = new Player("Gutta", "G");

        new Controller(board, players, streakToWin);
    }
}