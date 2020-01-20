package Controllers;

import Models.RuleEngine;

public class Player {
    private String name;
    private String character;

    public Player(String name, String character){
        this.name = name;
        this.character = character;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setCharacter(String character){
        this.character = character;
    }
    public String getCharacter(){
        return character;
    }    

    public void makeMove(RuleEngine ruleEngine, int row, int col){
        ruleEngine.nextPlayer();
    }
}