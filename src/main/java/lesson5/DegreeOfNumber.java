package lesson5;

public class DegreeOfNumber {
    public static void main(String[] args) {
        System.out.println(Method(2, 8));
        System.out.println(Method(2, -5));
        System.out.println(Method(3, 3));
    }

    public static double Method(double number, int degree) {
        if (degree == 0) return 1;
        else if (degree == 1) return number;
        else if (degree > 1) return number * Method(number, degree - 1);
        else return 1 / Method(number, -degree);
    }
}
