package Models;

import java.lang.reflect.Array;

import Controllers.Player;

public class RuleEngine {

    Board board;
    Player players[];
    int playerTurn = 0;
    String winner = "";

    public RuleEngine(Board board, Player players[]){
        this.board = board;
        this.players = players;
    }

    public boolean checkIfValidMove(int row, int col){
        if(board.getBoard()[row][col] == null){
            return true;
        }else{
            return false;
        }
    }

    public int getPlayerTurn (){
        int numberOfPlayers = Array.getLength(players);
        if(playerTurn > numberOfPlayers-1){
            playerTurn = 0;
        }
        return playerTurn;
    }
    
    public void nextPlayer(){
        playerTurn++;
    }

    public boolean checkIfWon(int streakToWin){
        Player player = players[this.playerTurn-1];
        String playerCharacter = player.getCharacter();
        int streak = 0;

        //Vertical
        for(int row = 0; row < board.getRows(); row++) {
			streak = 0;
			for(int col = 0; col < board.getCols(); col++) {
				if(board.getBoard()[row][col] == playerCharacter) {
					streak++;
				}
				else {
					streak = 0;
				}
				if(streak >= streakToWin) {
					return true;
				}
			}
        }

        //Horizontal
        for(int col = 0; col < board.getCols(); col++) {
			streak = 0;
			for(int row = 0; row < board.getCols(); row++) {
				if(board.getBoard()[row][col] == playerCharacter) {
					streak++;
				}
				else {
					streak = 0;
				}
				if(streak >= streakToWin) {
					return true;
				}
			}
        }
        
        //Diagonal that start left corner to upper right corner
        for(int rowStart = 0; rowStart < board.getRows(); rowStart++) {
			int row = rowStart;
			int col = 0;
			streak = 0;
			while(row >= 0 && col < board.getCols()){
				if(board.getBoard()[row][col] == playerCharacter) {
					streak++;
				}
				else {
					streak = 0;
				}
				if(streak >= streakToWin) {
					return true;
				}
				row --;
				col ++; 
			}
        }
        
        //Diagonal that start left corner to lower right corner
        for(int rowStart = 0; rowStart < board.getRows(); rowStart++) {
			int row = rowStart;
			int col = 0;
			streak = 0;
			while(row < board.getRows() && col < board.getCols()){
				if(board.getBoard()[row][col] == playerCharacter) {
					streak++;
				}
				else {
					streak = 0;
				}
				if(streak >= streakToWin) {
					return true;
				}
				row ++;
				col ++; 
			}
        }
        
        //Diagonal start down to upper right
        for(int colStart = 1; colStart < board.getCols(); colStart++) {
			int row = board.getRows() -1;
			int col = colStart;
			streak = 0;
			while(row >= 0 && col < board.getCols()){
				if(board.getBoard()[row][col] == playerCharacter) {
					streak++;
				}
				else {
					streak = 0;
				}
				if(streak >= streakToWin) {
					return true;
				}
				row --;
				col ++; 
			}
        }
        
        //Diagonal start up to lower right
        for(int colStart = 1; colStart < board.getCols(); colStart++) {
			int row = 0;
			int col = colStart;
			streak = 0;
			while(row < board.getRows() && col < board.getCols()){
				if(board.getBoard()[row][col] == playerCharacter) {
					streak++;
				}
				else {
					streak = 0;
				}
				if(streak >= streakToWin) {
					return true;
				}
				row ++;
				col ++; 
			}
		}

        
        return false;

    }

    public void setWinner(String playerName) {
		winner = playerName;
    }

    public String getWinner(){
        return winner;
    }
    
    
}


