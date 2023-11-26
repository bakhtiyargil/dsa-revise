package az.baxtiyargil.datastructuresalgorithms.array.game;

public class TicTacToe {

    private static final int X = 1;
    private static final int O = -1;
    private static final int EMPTY = 0;
    private final int[][] board = new int[3][3];
    private int player = X;

    public int winner() {
        return isWin(X) ? X : isWin(O) ? O : EMPTY;
    }

    private boolean isWin(int mark) {
        return ((board[0][0] + board[0][1] + board[0][2] == mark * 3)
                || (board[1][0] + board[1][1] + board[1][2] == mark * 3)
                || (board[2][0] + board[2][1] + board[2][2] == mark * 3)
                || (board[0][0] + board[1][0] + board[2][0] == mark * 3)
                || (board[0][1] + board[1][1] + board[2][1] == mark * 3)
                || (board[0][2] + board[1][2] + board[2][2] == mark * 3)
                || (board[0][0] + board[1][1] + board[2][2] == mark * 3)
                || (board[2][0] + board[1][1] + board[0][2] == mark * 3));
    }

    public void putMark(int row, int column) {
        if (row > 2 || row < 0 || column > 2 || column < 0) {
            throw new IllegalArgumentException("Invalid board position!");
        }
        if (board[row][column] != EMPTY) {
            throw new IllegalArgumentException("Board position occupied!");
        }
        board[row][column] = player;
        player = -player;
    }

    public void clearBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = EMPTY;
            }
        }
        player = X;
    }

    public void drawBoard() {
        var stringBuilder = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                switch (board[i][j]) {
                    case X -> stringBuilder.append("X");
                    case O -> stringBuilder.append("O");
                    case EMPTY -> stringBuilder.append(" ");
                }
                if (j < 2)
                    stringBuilder.append("|");
            }
            if (i < 2)
                stringBuilder.append("\n-----\n");
        }
        System.out.println(stringBuilder);
    }

}
