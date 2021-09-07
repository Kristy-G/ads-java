package lesson2.sort;

public class BubbleSort {
    public static void sort(Integer[] arr) {
        boolean isChange;
        int limit = arr.length;
        do {
            isChange = false;
            limit--;
            for (int i = 0; i < limit; i++) {
                if (arr[i] > arr[i + 1]) {
                    Integer temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isChange = true;
                }
            }
        } while (isChange);
    }
}
