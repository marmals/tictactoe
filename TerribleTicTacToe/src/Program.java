package tictactoe.TerribleTicTacToe.src;
import Models.Board;
import Controllers.Controller;

public class Program {
    public static void main(String[] args){
        Board board = new Board(3,3);
        new Controller(board);
    }
}