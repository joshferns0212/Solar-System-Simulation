
/*The "SolarSystem" program
Programmed by Joshua Fernandes, January 9, 2017
This program draws a solar system*/
import hsa.Console;
import java.awt.*;

public class SolarSystem {
	public static void main(String[] args) {
		// Variable declaration
		Console c = new Console(39, 134);

		CelestialBody[] celestialBodies = new CelestialBody[8];
		Thread[] thread = new Thread[celestialBodies.length];

		int centerX = c.maxx() / 2 + 140, centerY = c.maxy() / 2;
		boolean showOrbit;

		// Title page
		// Sets background
		c.setColor(new Color(10, 10, 40));
		c.fillRect(0, 0, c.maxx(), c.maxy());

		// Draws Text
		c.setColor(Color.yellow);
		c.setFont(new Font("Lucida Handwriting", Font.BOLD, 50));
		c.drawString("The Solar System", c.maxx() / 2 - 250, 320);
		c.setFont(new Font("Lucida Handwriting", Font.PLAIN, 30));
		c.drawString("by: Joshua Fernandes", c.maxx() / 2 - 180, 420);
		delay(1500);
		c.clear();

		// Asks user whether or not they want to see the orbits of the planets and moons
		showOrbit = getYesNoInput(c, "Do you want to see the orbits?");

		// Clears screen
		c.clear();

		// Sets background
		c.setColor(new Color(10, 10, 40));
		c.fillRect(0, 0, c.maxx(), c.maxy());

		// Creates celestial bodies
		// Sun
		c.setColor(Color.yellow);
		fillCircle(c, centerX, centerY, 20);

		// Mercury
		celestialBodies[0] = new Planet(Color.gray, c, centerX, centerY, 2, 35, 2, showOrbit, null);

		// Venus
		celestialBodies[1] = new Planet(new Color(229, 160, 32), c, centerX, centerY, 3, 50, 5, showOrbit, null);

		// Earth Moon
		Moon moon = new Moon(Color.lightGray, c, 2, 9, 2, showOrbit);
		Moon[] earthMoon = { moon };

		// Earth
		celestialBodies[2] = new Planet(new Color(81, 142, 204), c, centerX, centerY, 5, 75, 6, showOrbit, earthMoon);

		// Phobos
		Moon phobos = new Moon(Color.gray, c, 2.1, 7, 1, showOrbit);

		// Deimos
		Moon deimos = new Moon(Color.gray, c, 1.4, 9, 1, showOrbit);

		// Mars Moons
		Moon[] marsMoons = { phobos, deimos };

		// Mars
		celestialBodies[3] = new Planet(new Color(196, 75, 9), c, centerX, centerY, 10, 100, 3, showOrbit, marsMoons);

		// Main Asteroid Belt
		randomizeAsteroids(c, 180, centerX, centerY, 118, 150);

		// Io
		Moon io = new Moon(new Color(216, 188, 84), c, 17.3, 16, 2, showOrbit);

		// Europa
		Moon europa = new Moon(new Color(209, 174, 104), c, 13.7, 20, 2, showOrbit);

		// Ganymeade
		Moon ganymeade = new Moon(new Color(175, 163, 123), c, 10.9, 24, 2, showOrbit);

		// Callisto
		Moon callisto = new Moon(new Color(142, 132, 98), c, 8.2, 28, 2, showOrbit);

		// Jupiter Moons
		Moon[] jupiterMoons = { io, europa, ganymeade, callisto };

		// Jupiter
		celestialBodies[4] = new Planet(new Color(216, 171, 112), c, centerX, centerY, 60, 190, 12, showOrbit,
				jupiterMoons);

		// Titan
		Moon titan = new Moon(new Color(247, 197, 98), c, 4.6, 14, 2, showOrbit);

		// Enceladus
		Moon enceladus = new Moon(new Color(188, 224, 211), c, 11.6, 17, 1, showOrbit);

		// Mimas
		Moon mimas = new Moon(Color.gray, c, 13.3, 20, 1, showOrbit);

		// Saturn Moons
		Moon[] saturnMoons = { titan, enceladus, mimas };

		// Saturn
		celestialBodies[5] = new Planet(new Color(224, 170, 44), c, centerX, centerY, 148, 240, 10, showOrbit,
				saturnMoons);

		// Titania
		Moon titania = new Moon(new Color(175, 164, 110), c, 14.6, 12, 1, showOrbit);

		// Oberon
		Moon oberon = new Moon(new Color(170, 163, 129), c, 12.6, 14, 1, showOrbit);

		// Uranus Moons
		Moon[] uranusMoons = { titania, oberon };

		// Uranus
		celestialBodies[6] = new Planet(new Color(64, 209, 187), c, centerX, centerY, 420, 305, 8, showOrbit,
				uranusMoons);

		// Triton
		Moon triton = new Moon(new Color(156, 179, 193), c, -17.6, 12, 2, showOrbit);

		// Neptune Moon
		Moon[] neptuneMoon = { triton };

		// Neptune
		celestialBodies[7] = new Planet(Color.blue, c, centerX, centerY, 825, 370, 7, showOrbit, neptuneMoon);

		// Kuiper Belt
		randomizeAsteroids(c, 1000, centerX, centerY, 400, 600);

		// Creates sidebar
		// background
		c.setColor(new Color(37, 37, 114));
		c.fillRect(30, 30, 240, c.maxy() - 60);

		// Sun
		c.setColor(Color.yellow);
		fillCircle(c, 90, 100, 30);

		// Planets
		for (int i = 0; i < celestialBodies.length; i++) {
			c.setColor(celestialBodies[i].getColour());
			fillCircle(c, 90, 180 + i * 67, 20);
		}

		// Text
		c.setColor(Color.white);
		c.setFont(new Font("Lucida Handwriting", Font.PLAIN, 20));

		c.drawString("Sun", 135, 120);
		c.drawString("Mercury", 135, 200);
		c.drawString("Venus", 135, 267);
		c.drawString("Earth", 135, 334);
		c.drawString("Mars", 135, 401);
		c.drawString("Jupiter", 135, 468);
		c.drawString("Saturn", 135, 535);
		c.drawString("Uranus", 135, 602);
		c.drawString("Neptune", 135, 669);

		// Creates threads for celestial bodies
		for (int i = 0; i < celestialBodies.length; i++) {
			thread[i] = new Thread(celestialBodies[i]);
			thread[i].start();
		}

	} // main method

	public static boolean getYesNoInput(Console c, String message) {
		// Variable declaration
		String userInput;
		boolean convertedInput;

		// Gets user input
		c.println(message);
		userInput = c.readLine();

		// Error trapping for input
		while (!userInput.equalsIgnoreCase("yes") && !userInput.equalsIgnoreCase("no")) {
			c.println("Enter either yes or no");
			userInput = c.readLine();
		}

		// Translating input to boolean
		if (userInput.equalsIgnoreCase("yes")) {
			convertedInput = true;
		} else {
			convertedInput = false;
		}

		return convertedInput;
	} // end of getYesNoInput method

	public static void randomizeAsteroids(Console c, int numberOfAsteroids, int centerX, int centerY, int innerRadius,
			int outerRadius) {
		// Variable declaration
		int x, y, orbitRadius;

		// Sets colour of all asteroids to gray
		c.setColor(Color.gray);

		// Creates as many asteroids as specified
		for (int i = 0; i < numberOfAsteroids; i++) {
			do {
				x = (int) (2 * outerRadius * Math.random() + centerX - outerRadius);
				y = (int) (2 * outerRadius * Math.random() + centerY - outerRadius);
				orbitRadius = (int) (Math.round(Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2))));
			} while (orbitRadius < innerRadius || orbitRadius > outerRadius); // makes sure asteroid is created within
																				// bounds

			// Creates oddly shaped objects
			fillCircle(c, x, y, 1);
		}
	} // end of randomizeAsteroids method

	public static void fillCircle(Console c, int x, int y, int radius) {
		c.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
	} // end of fillCircle method

	public static void fillOval(Console c, int x, int y, int radius) {
		// randomly decides the orientation of the oval
		if (Math.random() < 0.5) {
			c.fillOval(x - radius, y - radius, 3 * radius, 2 * radius);
		} else {
			c.fillOval(x - radius, y - radius, 2 * radius, 3 * radius);
		}
	} // end of fillOval method

	public static void delay(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
		}
	} // end of delay method
} // end of SolarSystem class
