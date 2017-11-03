public class Point {

    public static void main(String[] args) {

        double x1 = 1.0;
        double x2 = 4.0;
        double y1 = 1.0;
        double y2 = 4.0;
        System.out.println("Расстояние между точками" + "(") + x1 + ";" + y1 + ")" + "(") + x2 + ";" + y2 + ")" + "=" + distance()

    }


    public static double distance(Point p1, Point p2){
        p1 = (x1-x2)*(x1-x2);
        p2 = (y1-y2)*(y1-y2);
        return Math.sqrt(p1+p2);
    }
}
