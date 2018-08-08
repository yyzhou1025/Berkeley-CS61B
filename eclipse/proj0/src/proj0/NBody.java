package proj0;

public class NBody {
    /**
     * read radius from planets.txt.
     * @param filename txt file name
     * @return double value radium
     */
    public static double readRadius(String filename) {
        In in = new In(filename);
        int numOfPlanets = in.readInt();
        double radius = in.readDouble();
        return radius;
        
    }
    
    /**
     * print the array of planets according to file.
     * @param planetsTxtPath
     * @return array of planets
     */
    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        int numOfPlanets = in.readInt();
        Planet[] planets =new Planet[numOfPlanets];
        double radius = in.readDouble();
        int i = 0;
        while (i != numOfPlanets){
            
            double xxP = in.readDouble();
            double yyP = in.readDouble();
            double xxV = in.readDouble();
            double yyV = in.readDouble();
            double mass = in.readDouble();
            String image = in.readString();
            planets[i] = new Planet(xxP, yyP, xxV, yyV, mass, image);
            i = i + 1;
        }
        
        return planets; 
    }
    
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        
        //initial the canvas
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        String imageName = "starfield.jpg";
        StdDraw.picture(0,0,imageName);
        for (int i = 0; i < planets.length; i++) {
            planets[i].draw();
        }
        //do the animation 
        StdDraw.enableDoubleBuffering();
        double time = 0;
        String audioName = "2001.mid";
        StdAudio.play(audioName);
        while (time != T) {
            double[] xForse = new double[planets.length];
            double[] yForse = new double[planets.length];
            
            for (int i = 0; i < planets.length; i++) {
                xForse[i] = planets[i].calcNetForceExertedByX(planets);
                yForse[i] = planets[i].calcNetForceExertedByY(planets);
            }
            
            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForse[i], yForse[i]);
            }
            
            
            StdDraw.picture(0,0,imageName);
            
            for (int i = 0; i < planets.length; i++) {
                planets[i].draw();
            }
            
            StdDraw.show();
            int waitTimeMilliseconds = 10;
            
            StdDraw.pause(waitTimeMilliseconds);
            
            time = time + dt;
        }  
        
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                          planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
        
    }

}
