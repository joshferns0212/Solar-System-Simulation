/*The "Moon" class
Programmed by Joshua Fernandes, January 9, 2017
This program creates a moon with the defined characteristics and moves it along its orbit*/
import java.awt.*;
import hsa.Console;

public class Moon extends CelestialBody
{
    //Variable declaration
    private double orbitSpeed;
    
    public Moon (Color colour, Console c, double orbitSpeed, int orbitRadius, int radius, boolean showOrbit)
    {
	//Variable Instantiation
	super (colour, c, 0 - c.maxx (), 0 - c.maxx (), orbitRadius, radius, showOrbit);
	
	this.orbitSpeed = orbitSpeed; //orbit speed in hundredths of radians

    } //Moon constructor


    public void setOrbit (int xOrbit, int yOrbit)
    {
	//resets center of orbit
	this.xOrbit = xOrbit;
	this.yOrbit = yOrbit;
    } //end of setOrbit method
    
    public void createOrbit () //overridden from CelestialBody class
    {
	super.createOrbit();
	currentAngle += 0.01 * orbitSpeed;         
    } //end of createOrbit method
} // end of Moon class
