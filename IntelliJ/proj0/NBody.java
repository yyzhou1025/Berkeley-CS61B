package proj0;

public class NBody {

    public static double readRadius(String filename) {
        In in = new In(filename);
        int numOfPlanets = in.readInt();
        double radius = in.readDouble();
        return radius;
        
    }

}
