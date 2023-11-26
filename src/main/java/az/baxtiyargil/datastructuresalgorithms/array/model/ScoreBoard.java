package az.baxtiyargil.datastructuresalgorithms.array.model;

public class ScoreBoard {

    private int numEntries = 0;
    private final GameEntry[] board;

    public ScoreBoard(int capacity) {
        this.board = new GameEntry[capacity];
    }

    public void addEntry(GameEntry gameEntry) {
        int newScore = gameEntry.getScore();
        if (numEntries < board.length || newScore > board[numEntries - 1].getScore()) {
            if (numEntries < board.length) {
                numEntries++;
            }

            int j = numEntries - 1;
            while (j > 0 && board[j - 1].getScore() < newScore) {
                board[j] = board[j - 1];
                j--;
            }
            board[j] = gameEntry;
        }
    }

    public GameEntry removeEntry(int index) {
        if (index > board.length || index < 0 || index >= numEntries) {
            throw new IndexOutOfBoundsException("Out of bounds: Index = " + index);
        }

        GameEntry temp = board[index];
        for (int i = index; i < numEntries - 1; i++) {
            board[i] = board[i + 1];
        }
        board[numEntries] = null;
        numEntries--;
        return temp;
    }

    public GameEntry[] getBoard() {
        return board;
    }

    public int getNumEntries() {
        return numEntries;
    }

}
