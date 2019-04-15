/*The "Planet" class
Programmed by Joshua Fernandes, January 9, 2017
This program creates a planet with the defined characteristics and moves it along its orbit*/
import java.awt.*;
import hsa.Console;

public class Planet extends CelestialBody
{
    //Variable declaration
    private int orbitPeriod;
    private Moon[] moons;

    public Planet (Color colour, Console c, int xOrbit, int yOrbit, int orbitPeriod, int orbitRadius, int radius, boolean showOrbit, Moon[] moons)
    {
	//Variable Instantiation
	super (colour, c, xOrbit, yOrbit, orbitRadius, radius, showOrbit);

	this.moons = moons; //array of Moon objects

	this.orbitPeriod = orbitPeriod; //orbit period in milliseconds

    } //Planet constructor


    public void run () //abstract method implemented from the Runnable interface and overridden from the CelestialBody class
    {
	while (true)
	{
	    //Clears and draws planet
	    clearOrbit ();
	    createOrbit ();
	    
	    //Clears and draws moons
	    if (moons != null)
	    {
		for (int i = 0 ; i < moons.length ; i++)
		{
		    moons [i].clearOrbit ();
		    moons [i].setOrbit (this.xCoord, this.yCoord);
		    moons [i].createOrbit ();
		}
	    }

	    delay (orbitPeriod);
	}
    } //end of run method


    public void createOrbit () //overridden from CelestialBody class
    {
	super.createOrbit ();
	currentAngle += 0.01;
    } //end of createOrbit method
} // end of Planet class
