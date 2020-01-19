package Controllers;

import Interface.GridClicked;
import Models.*;
import Views.View;

public class Controller implements GridClicked{
    View view;
    Board board;
    RuleEngine ruleEngine;
    Player players[];
    int streakToWin;

    public Controller(Board board, Player players[], int streakToWin){
        this.streakToWin = streakToWin;
        this.ruleEngine = new RuleEngine(board, players);
        this.view = new View(board.getRows(), board.getCols(), board.getBoard(), ruleEngine, players);
        view.setDelegate(this);
        
        this.board = board;
        this.players = players;
    }
    
    public void buttonClicked(int row, int col){
        Player player = players[ruleEngine.getPlayerTurn()];
        if(ruleEngine.checkIfValidMove(row, col)){
            player.makeMove(ruleEngine, row, col);
            board.updateBoard(row, col, player.getCharacter());
            if(ruleEngine.checkIfWon(streakToWin)){
                ruleEngine.setWinner(player.getName());
            }
            updateWindow();
        }
    }
    
    public void updateWindow(){
        view.updateWindow(board.getRows(), board.getCols(), board.getBoard(), ruleEngine.getWinner());
    }
}