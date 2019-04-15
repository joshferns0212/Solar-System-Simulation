/*The "Asteroids" class
Programmed by Joshua Fernandes, January 9, 2017
This program creates asteroid within a certain radius*/
import java.awt.*;
import hsa.Console;

public class Asteroids extends CelestialBody
{
    private Asteroid[] asteroids;
    private double orbitSpeed, currentAngle;
    private int numberOfAsteroids, innerRadius, outerRadius;

    public Asteroids (Console c, int xOrbit, int yOrbit, int orbitSpeed, int numberOfAsteroids, int innerRadius, int outerRadius)
    {
	//Variable Instantiation
	super (Color.lightGray, c, xOrbit, yOrbit, 0, 1, false);

	this.orbitSpeed = orbitSpeed;

	this.currentAngle = 2 * Math.PI * Math.random (); //randomizes starting angle

	this.numberOfAsteroids = numberOfAsteroids;

	this.innerRadius = innerRadius;

	this.outerRadius = outerRadius;

	this.asteroids = new Asteroid [numberOfAsteroids];

    } //Asteroids constructor


    public void run ()  //abstract method implemented from the Runnable interface and overridden from the CelestialBody class
    {
	randomizeOrbits ();

	while (true)
	{
	    clearOrbit ();
	    createOrbit ();
	    delay (100);
	}
    }


    public void createOrbit ()  //overridden from CelestialBody class
    {
	//Sets colour of all asteroids to gray
	c.setColor (colour);

	for (int i = 0 ; i < numberOfAsteroids ; i++)
	{
	    rotateCircle (currentAngle + asteroids [i].getRelativeAngle (), asteroids [i].getOrbitRadius ());
	}
    } //end of createOrbit method


    public void clearOrbit ()  //overridden from CelestialBody class
    {
	//Clears previous objects
	c.setColor (new Color (10, 10, 40));
    } //end of clearOrbit method


    public void rotateCircle (double currentAngle, int orbitRadius)  //overridden from CelestialBody class
    {
	//Variable declaration
	int xCoord, yCoord;
	
	//Determines coordinates of object
	xCoord = xOrbit + (int) (Math.round (orbitRadius * Math.cos (currentAngle)));
	yCoord = yOrbit - (int) (Math.round (orbitRadius * Math.sin (currentAngle)));
	
	fillOval (xCoord, yCoord, 1);        
    } //end of rotateCircle method


    public void randomizeOrbits ()
    {
	//Variable declaration
	double relativeAngle;
	int orbitRadius;

	//Creates as many asteroids as specified
	for (int i = 0 ; i < numberOfAsteroids ; i++)
	{
	    //Stores asteroid data
	    relativeAngle = 2 * Math.PI * Math.random ();
	    orbitRadius = (int) (Math.round (((outerRadius - innerRadius + 1) * Math.random () + innerRadius)));
	    asteroids [i] = new Asteroid (relativeAngle, orbitRadius);
	}
    } //end of randomizeAsteroids method


    public void fillOval (int x, int y, int radius)
    {
	//randomly decides the orientation of the oval
	if (Math.random () < 0.5)
	{
	    c.fillOval (x - radius, y - radius, 3 * radius, 2 * radius);
	}
	else
	{
	    c.fillOval (x - radius, y - radius, 2 * radius, 3 * radius);
	}
    } //end of fillOval method
} // end of Asteroids class


