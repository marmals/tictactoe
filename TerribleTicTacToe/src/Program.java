import Models.Board;


import Controllers.Controller;
import Controllers.Player;

public class Program {
    public static void main(String[] args){
        int numberOfPlayers = 2;
        int boardRules = 3;

        int streakToWin = boardRules;
        Board board = new Board(boardRules,boardRules);
        Player players[] = new Player[numberOfPlayers];

        players[0] = new Player();
        players[1] = new Player();
        //players[2] = new Player();

        players[0].setName("Martin");
        players[0].setCharacter("X");

        players[1].setName("Johannes");
        players[1].setCharacter("O");

        //players[2].setName("Gutta");
        //players[2].setCharacter("G");

        new Controller(board, players, streakToWin);
    }
}