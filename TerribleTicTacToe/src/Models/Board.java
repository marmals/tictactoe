package Models;

public class Board{
    private int rows;
    private int cols;
    private final int board[][];

    public Board(final int rows, final int cols) {
        this.rows = rows;
        this.cols = cols;

        this.board = new int[rows][cols];
        setBoard(this.rows, this.cols);
    }

    public int getRows() {
        return this.rows;
    }

    public void setRows(final int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return this.rows;
    }

    public void setCols(final int cols) {
        this.cols = cols;
    }

    public int getBoard() {
        return this.board;
    }

    public void setBoard(final int row, final int col) {
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                this.board[i][j] = 0;
            }
        }
        return;
    }


}