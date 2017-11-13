package ru.stqa.pft.sandbox;

public class Distance {

    public static void main(String[] args) {
        Point p1 = new Point(5, 5);
        Point p2 = new Point (-5, -5);
        System.out.println("Расстояние между двумя точками p1 и p2" + " = " + p1.distance(p2));
    }
}
