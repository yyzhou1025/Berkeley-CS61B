package proj0;

public class Planet {
    /**
     * instance variable.
     * Its current x position
     */
    public double xxPos;
    /**
     * Its current y position
     */
    public double yyPos;
    /**
     * Its current velocity in the x direction
     */
    public double xxVel;
    /**
     * Its current velocity in the y direction
     */
    public double yyVel;
    /**
     * Its mass
     */
    public double mass;
    /**
     *  The name of the file that corresponds to the image that depicts the planet 
     */
    public String imgFileName;
    
    /**
     * The first constructor to initialize an instance of the Planet class.
     * @param xP xxPos
     * @param yP yyPox
     * @param xV xxVel
     * @param yV yyVel
     * @param m  mass
     * @param img  imgFileName
     */
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    
    /**
     * The second constructor to initialize an identical Planet object.
     * @param p planet object
     */
    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;     
    }
    /**
     * The method to calculate the distance of two planet.
     * @param p  one of the planet
     * @return  double distance
     */
    public double calcDistance(Planet p) {
        double xxDiff = this.xxPos - p.xxPos;
        double yyDiff = this.yyPos - p.yyPos;
        double distance = Math.sqrt(xxDiff * xxDiff + yyDiff * yyDiff);
        return distance;
    }
    /**
     * calculate the force between two planet.
     * @param p the planet
     * @return a double describing the force exerted on this planet by the given planet.
     */
    public double calcForceExertedBy(Planet p) {
        final double G = 6.67e-11;
        double r = this.calcDistance(p);
        double force = (G * this.mass * p.mass) / (r * r);
        
        return force;
    }
    /**
     * this method is to calculate the force exerted in the X directions, respectively. 
     * @param p the planet
     * @return double value of force
     */
    public double calcForceExertedByX(Planet p) {
        double xDiff = p.xxPos - this.xxPos;
        double force = (this.calcForceExertedBy(p) * xDiff)/this.calcDistance(p);
        return force;
    }
    /**
     * this method is to calculate the force exerted in the Y directions, respectively. 
     * @param p the planet
     * @return double value of force
     */
    public double calcForceExertedByY(Planet p) {
        double yDiff = p.yyPos - this.yyPos;
        double force = (this.calcForceExertedBy(p) * yDiff)/this.calcDistance(p);
        return force;
    }
    /**
     * calculate the net X  force exerted by all planets in that array
     * @param planets planets array
     * @return the net X force
     */
    public double calcNetForceExertedByX(Planet[] planets) {
        double force = 0;
        for (int i = 0; i < planets.length; i++) {
            if (this.equals(planets[i])) {
                continue;
            }
            force = force + this.calcForceExertedByX(planets[i]);
        }
        return force;
    }
    /**
     * calculate the net Y  force exerted by all planets in that array
     * @param planets planets array
     * @return  the net Y force
     */
    public double calcNetForceExertedByY(Planet[] planets) {
        double force = 0;
        for (int i = 0; i < planets.length; i++) {
            if (this.equals(planets[i])) {
                continue;
            }
            force = force + this.calcForceExertedByY(planets[i]);
        }
        return force;
    }
    /**
     * update the planet’s position and velocity instance variables.
     * @param dt  time 
     * @param fX the net X force
     * @param fY the net Y force
     */
    public void update(double dt, double fX, double fY) {
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        double vX = this.xxVel + dt * aX;
        double vY = this.yyVel + dt * aY;
        double pX = this.xxPos + dt * vX;
        double pY = this.yyPos + dt * vY;
        this.xxPos = pX;
        this.yyPos = pY;
        this.xxVel = vX;
        this.yyVel = vY;
    }
    

   
    
    

}
