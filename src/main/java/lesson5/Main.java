package lesson5;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Thing> things = new ArrayList<>();
        for (int i = 0; i < r.nextInt(10); i++) {
            things.add(new Thing(r.nextInt(50), r.nextInt(1000)));
        }

        Thing.PrintArr(things);
        Thing.PrintArr(Thing.SearchArr(things, 50, new ArrayList<>()));
    }
}
