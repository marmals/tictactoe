package Views;
import javax.javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

public class View {

    private JFrame frame;
    private JButton buttons[][];
    private JLabel myLabel = new JLabel("", SwingConstants.CENTER);
    private JPanel myTextPanel = new JPanel();

    public View(int rows, int cols, int board[][]) {
        frame = new JFrame("Not so terrible tic tac toe!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel myButtonPanel = new JPanel();
        myButtonPanel.setLayout(new GridLayout(rows, cols));

        buttons = new JButton[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                final int _r = r;
                final int _c = c;
                JButton button = buttons[row][col] = new JButton();
                button.setPreferredSize(new Dimension(650 / rows, 650 / cols));
                if (board[row][col] != 0) {
                    button.setText("" + board[row][col]);
                }
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // todo
                    }
                });
                myButtonPanel.add(button);
            }
        }

        myTextPanel.setLayout(new GridLayout(1, 1));
        myTextPanel.setPreferredSize(new Dimensions(150, 50));
        myLabel.setText("Player " + turn + "'s turn");
        myTextPanel.add(myLabel);

        JPanel myMainPanel = new JPanel();
        myMainPanel.setLayout(new BoxLayout(myMainPanel, BoxLayout.Y_AXIS));
        myMainPanel.add(myButtonPanel);
        myMainPanel.add(myTextPanel);

        frame.getContentPane().add(myMainPanel);

        frame.pack();
        frame.setVisible(true);
    }
}