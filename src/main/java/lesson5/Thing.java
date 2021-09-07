package lesson5;

import java.util.ArrayList;

public class Thing {
    int weight;
    int prise;

    public Thing(int weight, int prise) {
        this.weight = weight;
        this.prise = prise;
    }

    public void Print() {
        System.out.print(this.weight + ":" + this.prise);
    }

    public static ArrayList<Thing> SearchArr (ArrayList<Thing> things, int maxWeight, ArrayList<Thing> newArr) {
        if ((getFullWeight(things) <= maxWeight && getFullPrice(things) > getFullPrice(newArr)) || things.isEmpty()) {
            return things;
        }
        else {
            for (int i = 0; i < things.size(); i++) {
                ArrayList<Thing> arr = new ArrayList<>();
                for (int j = 0; j < things.size(); j++) {
                    if (j != i) {
                        arr.add(things.get(j));
                    }
                }

                if (getFullWeight(arr) <= maxWeight && getFullPrice(arr) > getFullPrice(newArr)) {
                    newArr.clear();
                    newArr.addAll(arr);
                }
                else SearchArr(arr, maxWeight, newArr);
            }
        }
        return newArr;
    }

    public static int getFullWeight(ArrayList<Thing> thingArrayList) {
        int i = 0;
        if (!thingArrayList.isEmpty()) {
            for (Thing th : thingArrayList) {
                i += th.weight;
            }
        }
        return i;
    }

    public static int getFullPrice(ArrayList<Thing> thingArrayList) {
        int i = 0;
        if (thingArrayList.size() != 0) {
            for (Thing th : thingArrayList) {
                i += th.prise;
            }
        }
        return i;
    }

    public static void PrintArr(ArrayList<Thing> thingArrayList) {
        int w = getFullWeight(thingArrayList);
        int p = getFullPrice(thingArrayList);
        if (!thingArrayList.isEmpty()) {
            System.out.print("[");
            for (int i = 0; i < thingArrayList.size(); i++) {
                if (i != 0) System.out.print(", ");
                thingArrayList.get(i).Print();
            }
            System.out.print("] ");
        }
        else {
            System.out.print("Array is empty! ");
        }
        System.out.println("fullWeight = " + w + ", fullPrice = " + p);
    }
}
