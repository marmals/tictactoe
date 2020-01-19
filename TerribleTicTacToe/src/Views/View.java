package Views;

import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import Controllers.*;
import Interface.GridClicked;
import Models.RuleEngine;

public class View {

    private GridClicked delegate;
    private JFrame frame;
    private JButton buttons[][];
    private JLabel myLabel = new JLabel("", SwingConstants.CENTER);
    private JPanel myTextPanel = new JPanel();
    private RuleEngine ruleEngine;
    private Player players[];

    public void setDelegate(GridClicked delegate){
        this.delegate = delegate;
    }

    public View(int rows, int cols, String board[][], RuleEngine ruleEngine, Player players[]) {
        this.ruleEngine = ruleEngine;
        this.players = players;
        frame = new JFrame("Not so terrible tic tac toe!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel myButtonPanel = new JPanel();
        myButtonPanel.setLayout(new GridLayout(rows, cols));

        buttons = new JButton[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                final int _r = row;
                final int _c = col;
                JButton button = buttons[row][col] = new JButton();
                button.setPreferredSize(new Dimension(650 / rows, 650 / cols));
                if (board[row][col] != null) {
                    button.setText("" + board[row][col]);
                }
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        delegate.buttonClicked(_r, _c);
                    }
                });
                myButtonPanel.add(button);
            }
        }

        myTextPanel.setLayout(new GridLayout(1, 1));
        myTextPanel.setPreferredSize(new Dimension(150, 50));
        myLabel.setText("Player " + players[ruleEngine.getPlayerTurn()].getName() + "'s turn");
        myTextPanel.add(myLabel);

        JPanel myMainPanel = new JPanel();
        myMainPanel.setLayout(new BoxLayout(myMainPanel, BoxLayout.Y_AXIS));
        myMainPanel.add(myButtonPanel);
        myMainPanel.add(myTextPanel);

        frame.getContentPane().add(myMainPanel);

        frame.pack();
        frame.setVisible(true);
    }

    public void updateWindow(int rows, int cols, String board[][], String winner){
        for(int row = 0; row < rows; row++) {
	    	for(int col = 0; col < cols; col++) {
	    		if(board[row][col] != null) {
	    			JButton button = buttons[row][col];
					button.setText(""+board[row][col]);
				}
	    	}
        }
        if(winner == "") {
            myLabel.setText("Player " + players[ruleEngine.getPlayerTurn()].getName() + "'s turn");
	    }
	    else {
            myLabel.setText("Player " + winner + " WON!");
	    }
        
        myTextPanel.add(myLabel);
    }
}