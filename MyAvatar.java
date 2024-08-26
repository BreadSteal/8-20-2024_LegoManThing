import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;

/**
 * Lesson 4: Activity - Using Classes and Objects
 * 
 * Uses the MiniFig class to draw a custom avatar.
 * 
 * @author CS121 instructors
 * @author <you>
 */
@SuppressWarnings("serial")
public class MyAvatar extends JPanel
{
	public final int INITIAL_WIDTH = 800;
	public final int INITIAL_HEIGHT = 600;
	
	/**
	 * Draws the picture in the panel. This is where all of your
	 * code will go.
	 * @param canvas The drawing area of the window.
	 */
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);

		/* Store the height and width of the panel at the time
		 * the paintComponent() method is called.
		 */
		int currentHeight = getHeight();
		int currentWidth = getWidth();
		
		/* This is the anchor point for the MiniFig (x,y) -> (mid,top) */
		int mid = currentWidth / 2;
		int top = currentHeight / 6;
		
		/* This is the scaler that is used to calculate the dimensions (height / width) 
		 * of each of the MiniFig components. It uses the Math.min() function to select
		 * the smaller of currentWidth/INITIAL_WIDTH and currentHeight/INITIAL_HEIGHT.
		 * This way all the components are scaled to fit within the smaller of the two 
		 * panel dimensions.
		 */
		double scaleFactor = Math.min(currentWidth/(double)INITIAL_WIDTH,currentHeight/(double)INITIAL_HEIGHT );
		
		// TODO: 1. Instantiate a new Point object called "anchor". Use "mid" as your x value and
		//       "top" as your y value.
		Point anchor = new Point(mid, top);
		MiniFig bob = new MiniFig(g, scaleFactor, anchor);
		MiniFig robert = bob;
		//MiniFig bobby2 = new MiniFig(g, scaleFactor / 1.25, anchor2);
		//MiniFig robert2 = bobby2;
		//MiniFig bobby3 = new MiniFig(g, scaleFactor / 1.75, anchor);
		//MiniFig robert3 = bobby3;
		robert.setTorsoColor(Color.BLACK);
		robert.setBeltColor(Color.RED);
		robert.setEyeColor(Color.BLACK);
		robert.setFootColor(Color.BLACK);
		robert.setLegColor(Color.BLACK);
		robert.setHandColor(Color.BLACK);
		robert.setHeadColor(Color.WHITE);
		robert.setOutlineColor(Color.WHITE);
		robert.setArmColor(Color.BLACK);
		robert.setHandHoleColor(Color.GRAY);
		robert.draw();
		//robert2.setHandHoleColor(Color.WHITE);
		//robert2.draw();
		//robert3.draw();

		// TODO: 2. Instantiate a new MiniFig object and give the reference variable a name of a person, 
		//       such as "bob". Use the MiniFig constructor with the following
		//       parameters: MiniFig(g, scaleFactor, anchor)
		
		// TODO: 3. Create a new custom Color object. An example is shown below.
		
		// TODO: 4. Invoke the setTorsoColor(Color color) method on your MiniFig instance.
		//       Use your color object as a parameter to change the shirt color.
		//       This lets you change the color of "bob's" shirt. :)
		
		// TODO: 5. Invoke the draw() method on your MiniFig instance. This is where "bob" is displayed on the screen.
		
		// TODO: 6. Adjust the size of your Avatar's window. Notice how the avatar does not stay grounded
		//       on the grass. To fix this, use the getBaseMidPoint() method to find the the base mid point of your
		//       MiniFig. This method returns a Point object that represents the x,y coordinates at the
		//       base of the MiniFig, right between its feet. 
		//       Replace the hard-coded value of grassYOffset with the y value 
		//       of the returned point.

		Point feet = bob.getBaseMidPoint();
		int figYpos = (int)feet.getY();
		System.out.println(figYpos);

		Point pcap = bob.getCapPoint();
		int capy = (int)pcap.getY();
		int capx = (int)pcap.getX();
		int facewidth = bob.getFaceWidth();
		int faceheight = bob.getFaceHeight();
		Color brownbelt = new Color (145, 75, 5);
		int halffacewidth = (facewidth / 2);
		int thirdfacewidth = (faceheight / 3);
		int halffaceheight = (faceheight / 2);

		Point phand = bob.getRightHandCenterPoint();
		int handy = (int)phand.getY();
		int handx = (int)phand.getX();
		

		g.setColor(brownbelt);
		//g.fillOval(capx - halffacewidth, capy, facewidth, faceheight);

		g.setColor(Color.BLACK);
		g.fillOval(capx - halffacewidth, capy + halffaceheight, facewidth, faceheight / 3);
		g.fillOval(capx - halffacewidth, capy, facewidth / 3, faceheight / 3);
		g.fillOval(capx + thirdfacewidth / 2, capy, facewidth / 3, faceheight / 3);
		g.setColor(Color.CYAN);
		g.fillRect(capx - halffacewidth * 2, capy - thirdfacewidth * 2, facewidth * 2, faceheight / 2);
		g.fillRect(capx - halffacewidth * 2, capy - thirdfacewidth, facewidth / 2, faceheight / 2);
		g.fillRect(capx + halffacewidth, capy - thirdfacewidth, facewidth / 2, faceheight / 2);
		g.setColor(brownbelt);
		g.fillRect(handx - thirdfacewidth, handy - halffaceheight * 3, facewidth/2, faceheight * 2);
		g.setColor(Color.CYAN);
		g.fillRect(handx - facewidth, handy - halffaceheight * 3, halffacewidth * 4, faceheight/2 );
		g.fillRect(handx - halffacewidth * 2, handy - halffaceheight * 2, halffacewidth * 1, faceheight/2 );
		g.fillRect(handx + halffacewidth, handy - halffaceheight * 2, halffacewidth * 1, faceheight/2 );

		Color grassGreen = new Color (60,80,38);
		Color grassGreener = new Color (60,145,38);
		g.setColor(grassGreen);
		g.fillRect(0, figYpos, currentWidth, currentHeight);
		g.setColor(grassGreener);
		g.fillRect(0, figYpos, currentWidth, currentHeight / 25);
		g.setColor(Color.WHITE);
		g.fillRect(currentWidth / 7, currentHeight / 7, currentWidth / 7, currentHeight / 25);
		g.fillRect(currentWidth / 10, currentHeight / 8, currentWidth / 7, currentHeight / 25);

		g.fillRect(currentWidth - currentWidth / 4, currentHeight / 9, currentWidth / 7, currentHeight / 25);
		g.fillRect(currentWidth - currentWidth / 5, currentHeight / 11, currentWidth / 7, currentHeight / 25);


		// TODO: 7. Create an Alias of for your MiniFig object and change the torso color of the alias.
		//       If in step 2 you used the variable name "bob", you can create an alias named "robert"
		//       using the following:
		//       MiniFig robert = bob;
		//       robert.setTorsoColor(Color.RED);

		
	        // TODO: 8. Comment out the draw statement under TODO item 5 and then draw the original MiniFig 
		//       below. If you used the variable name "bob" is would simply be the following:
		//       bob.draw();
		//       What color is Bob's Shirt?  Why?
	}


	/**
	 * Constructor (panel initialization)
	 */
	public MyAvatar()
	{
		setBackground(Color.GRAY);
		setPreferredSize(new Dimension(INITIAL_WIDTH, INITIAL_HEIGHT));
	}

	/**
	 * Sets up a JFrame and the MiniFigDriver panel.
	 * @param args unused
	 */

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("MyAvatar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new MyAvatar());
		frame.pack();
		frame.setVisible(true);
	}
	
}