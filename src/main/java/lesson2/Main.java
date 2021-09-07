package lesson2;

import lesson2.sort.BubbleSort;

public class Main {
    public static void main(String[] args) {
        MyArray.isRepeat = false;
        MyArray.isShuffle = true;
        final int SIZE = 30;
        Integer[] arr = MyArray.getArray(SIZE);

        MyArray.shuffleArray(arr);
        SpeedTest.printSortName("Шейкерная сортировка");
        SpeedTest.startTime();

        BubbleSort.sort(arr);

        SpeedTest.endTime();
    }
}
