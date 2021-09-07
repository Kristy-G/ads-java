package lesson1.bigO;

public class Rule4 {
    public static boolean findDuplicates(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j) {
                    if (array[i] == array[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static boolean findDuplicates2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                    if (array[i] == array[j]) {
                        return true;
                }
            }
        }
        return false;
    }


    public static boolean findDuplicates3(int[] array) {
        for (int i = 1; i < array.length; i *= 2) { //O(logn)
//        for (int i = 0; i < array.length; i += 2) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
