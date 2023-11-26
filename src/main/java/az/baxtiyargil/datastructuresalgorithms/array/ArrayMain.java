package az.baxtiyargil.datastructuresalgorithms.array;

import az.baxtiyargil.datastructuresalgorithms.array.game.TicTacToe;
import az.baxtiyargil.datastructuresalgorithms.array.model.GameEntry;
import az.baxtiyargil.datastructuresalgorithms.array.model.ScoreBoard;
import az.baxtiyargil.datastructuresalgorithms.array.utility.Sorter;

import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Logger;

public class ArrayMain {

    private static final Logger logger = Logger.getLogger(ArrayMain.class.getName());

    public static void main(String[] args) {
        ticTacToeTest();
    }

    public static void ticTacToeTest() {
        var game = new TicTacToe();
        game.putMark(1, 1); //first player
        game.putMark(0, 0); //second player

        game.putMark(0, 2);
        game.putMark(2, 0);

        game.putMark(1, 0);
        game.putMark(1, 2);

        game.putMark(0, 1);
        game.putMark(2, 1);

        game.putMark(2, 2);
        game.drawBoard();
        System.out.println("Winner is: " + game.winner() + "\n");
        //-----------------------------------------------//
        game.clearBoard();
        game.putMark(0, 0); //first player
        game.putMark(2, 0); //second player

        game.putMark(0, 1);
        game.putMark(1, 1);

        game.putMark(1, 0);
        game.putMark(0, 2);
        game.drawBoard();
        System.out.println("Winner is: " + game.winner());
    }

    public static void sortingTest() {
        var array = new int[]{9, 1, 8, 2, 7, 3};
        System.out.println("Before: " + Arrays.toString(array));
        //Sorter.bubbleSort(array);
        Sorter.insertionSort(array);
        System.out.println("After: " + Arrays.toString(array));
    }

    public static void scoreBoardTesting() {
        var scoreBoard = new ScoreBoard(10);
        scoreBoard.addEntry(new GameEntry("A", 18));
        scoreBoard.addEntry(new GameEntry("C", 10));
        scoreBoard.addEntry(new GameEntry("B", 13));

        System.out.println("Before:");
        Arrays.stream(scoreBoard.getBoard())
                .filter(Objects::nonNull)
                .forEach(element -> System.out.println((element.getScore())));

        System.out.println("After:");
        scoreBoard.removeEntry(0);
        Arrays.stream(scoreBoard.getBoard())
                .filter(Objects::nonNull)
                .forEach(element -> System.out.println((element.getScore())));
    }

}
