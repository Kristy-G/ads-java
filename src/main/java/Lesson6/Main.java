package Lesson6;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Tree> arr = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            arr.add(new TreeImpl(4));
            for (int j = 0; j < r.nextInt(100); j++) {
                arr.get(i).add(r.nextInt(51) - 25);
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            System.out.println("Tree " + (i + 1) + ":");
            System.out.println("Tree is balanced - " + TreeImpl.isBalanced(arr.get(i).getRoot()));
            arr.get(i).display();
        }

        int num = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (!(TreeImpl.isBalanced(arr.get(i).getRoot()))) num++;
        }

        System.out.println(((num * 100) / arr.size()) + "%");
    }
}
