package Controllers;

import Models.Board;
import Views.View;

public class Controller{
    View view;
    Board board;

    public Controller(Board board){
        this.view = new View(board.getRows(), board.getCols(), board.getBoard());
        
        this.board = board;
    }
}