/*The "CelestialBody" class
Programmed by Joshua Fernandes, January 9, 2017
This program creates a celestial body with the defined characteristics and moves it along its orbit*/
import java.awt.*;
import hsa.Console;

public class CelestialBody implements Runnable
{
    //Variable declaration
    protected Color colour;
    protected Console c;
    protected int xOrbit, yOrbit, orbitRadius, orbitPeriod, radius, xCoord, yCoord;
    protected double currentAngle;
    protected boolean showOrbit;

    public CelestialBody (Color colour, Console c, int xOrbit, int yOrbit, int orbitRadius, int radius, boolean showOrbit)
    {
	//Variable Instantiation
	this.colour = colour; //colour of object

	this.c = c; //Console to draw to

	this.xOrbit = xOrbit; //x coordinate of center of orbit

	this.yOrbit = yOrbit; //y coordinate of center of orbit

	this.orbitRadius = orbitRadius; //radius of orbit

	this.radius = radius; //radius of object

	this.currentAngle = 2 * Math.PI * Math.random (); //randomizes starting angle

	this.showOrbit = showOrbit; //whether or not to show the path the object takes

    } //CelestialBody constructor


    public void run ()  //abstract method implemented from the Runnable interface
    {
    }


    public void createOrbit ()
    {
	//New orbit circle
	if (showOrbit)
	{
	    c.setColor (new Color (64, 124, 153));
	    drawCircle (xOrbit, yOrbit, orbitRadius);
	}

	//Creates object
	c.setColor (colour);
	rotateCircle (currentAngle);
    } //end of createOrbit method


    public void clearOrbit ()
    {
	//Deletes previous image
	c.setColour (new Color (10, 10, 40));

	if (showOrbit)
	{
	    drawCircle (xOrbit, yOrbit, orbitRadius);
	}

	fillCircle (xCoord, yCoord, radius);
    } //end of clearOrbit method


    public void rotateCircle (double currentAngle)
    {
	//Determines coordinates of object
	xCoord = xOrbit + (int) (Math.round (orbitRadius * Math.cos (currentAngle)));
	yCoord = yOrbit - (int) (Math.round (orbitRadius * Math.sin (currentAngle)));

	fillCircle (xCoord, yCoord, radius);
    } //end of rotateCircle method


    public void fillCircle (int x, int y, int radius)
    {
	c.fillOval (x - radius, y - radius, 2 * radius, 2 * radius);
    } //end of fillCircle method


    public void drawCircle (int x, int y, int radius)
    {
	c.drawOval (x - radius, y - radius, 2 * radius, 2 * radius);
    } //end of drawCircle method


    public Color getColour ()
    {
	return colour;
    } //end of getColour method


    public void delay (int time)
    {
	try
	{
	    Thread.sleep (time);
	}
	catch (InterruptedException e)
	{
	}
    } //end of delay method
} // end of CelestialBody class
