package az.baxtiyargil.datastructuresalgorithms.list.utility;

import az.baxtiyargil.datastructuresalgorithms.list.positional.Position;
import az.baxtiyargil.datastructuresalgorithms.list.positional.PositionalList;

public class Sorter {

    public static void insertionSort(PositionalList<Integer> list) {
        Position<Integer> marker = list.first();
        while (marker != list.last()) {
            Position<Integer> pivot = list.after(marker);
            int value = pivot.getElement();
            if (value > marker.getElement()) {
                marker = pivot;
            } else {
                Position<Integer> walk = marker;
                while (walk != list.first() && list.before(walk).getElement() > value) {
                    walk = list.before(walk);
                }
                list.remove(pivot);
                list.addBefore(walk, value);
            }
        }
    }

}
