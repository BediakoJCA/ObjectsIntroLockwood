//Game Example
//Lockwood Version 2023-24
// Learning goals:
// make an object class to go with this main class
// the object class should have a printInfo()
//input picture for background
//input picture for object and paint the object on the screen at a given point
//create move method for the object, and use it
// create a wrapping move method and a bouncing move method
//create a second object class
//give objects rectangles
//start interactions/collisions

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics


import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameLand implements Runnable {

    //Variable Declaration Section
    //Declare the variables used in the program
    //You can set their initial values here if you want

    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 700;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;

    public BufferStrategy bufferStrategy;
    /**STEP 0 declare object**/
    //Declare the objects used in the program below
//public Hero inc ;
    public Hero ray;
    public Hero duke;
    public Hero kai;
    public Hero Agent;
    /**STEP 1 declare image for object**/
    public Image incPic;
    public Image dukePic;
    public Image rayPic;
    public Image kaiPic;
    public Image AgentPic;
    //declare background image
    public Image AMPpic;
    //intersection booleans
    public boolean astroIsIntersectingStar=false;




    // Main method definition: PSVM
    // This is the code that runs first and automatically
    public static void main(String[] args) {
        GameLand ex = new GameLand();   //creates a new instance of the game and tells GameLand() method to run
        new Thread(ex).start();       //creates a thread & starts up the code in the run( ) method
    }

    // Constructor Method
    // This has no return type and has the same name as the class
    // This section is the setup portion of the programm,,zxxncm,sz c,zcx,xzc,zxcz
    // This section is the setup portion of the program xm xmz c,. c,.
    // Initialize your variables and  ruct your program objects here.
    public GameLand() {
        setUpGraphics(); //this calls the setUpGraphics() method

        //create (construct) the objects needed for the game below
/**STEP 2 construct object**/
        duke=new Hero(500,500, 10, 15);
        ray=new Hero(300,200, 8, 4);
        kai=new Hero(200,400, 9, 6);
        Agent=new Hero(175,200, -2, -8);





        /**STEP 3 add image to object**/
        dukePic=Toolkit.getDefaultToolkit().getImage("fit.jpeg");
        rayPic = Toolkit.getDefaultToolkit().getImage("kai.jpeg");
        kaiPic=Toolkit.getDefaultToolkit().getImage("wanum.jpeg");
        AgentPic=Toolkit.getDefaultToolkit().getImage("ray.jpeg");
        AMPpic=Toolkit.getDefaultToolkit().getImage("AMP.jpeg");



        System.out.println();
        //for each object that has a picture, load in images as well

    }// GameLand()

//*******************************************************************************
//User Method Section

// put your code to do things here.

    // main thread
    // this is the code that plays the game after you set things up
    public void run() {
        //for the moment we will loop things forever using a while loop
        while (true) {
            moveThings();  //move all the game objects
            collisions();
            render();  // paint the graphics
            pause(20); // sleep for 20 ms
        }
    }

    //paints things on the screen using bufferStrategy
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        //draw background below
        g.drawImage(AMPpic,0,0,WIDTH,HEIGHT,null);

        //draw the image of your objects below:
/** STEP 4 draw object images**/
        g.drawImage(dukePic, duke.xpos,duke.ypos,duke.width,duke.height,null);
        g.drawImage(kaiPic,kai.xpos,kai.ypos,kai.width,kai.height,null);
        g.drawImage(rayPic,ray.xpos,ray.ypos,ray.width,ray.height,null);
        g.drawImage(AgentPic,Agent.xpos,Agent.ypos,Agent.width,Agent.height,null);
        //dispose the images each time(this allows for the illusion ofment).
        g.dispose();

        bufferStrategy.show();
    }

    public void moveThings() {
        //call r4the move() method code from your object class
        duke.bouncingMove();
        ray.bouncingMove();
        kai.wrappingMove();
        Agent.wrappingMove();

    }




    public void collisions() {
        if (duke.rec.intersects(ray.rec) == true) {
            System.out.println("Ouch");
            duke.width = duke.width + 1;
            duke.height = duke.height + 1;
            ray.width = ray.width - 1;
            ray.height = ray.height - 1;
        }

            if (duke.rec.intersects(kai.rec) == true) {
                System.out.println("Ouch");
                duke.width = duke.width + 1;
                duke.height = duke.height + 1;
                kai.width = kai.width - 1;
                kai.height = kai.height - 1;
            }
            if (duke.rec.intersects(Agent.rec) == true) {
                System.out.println("Ouch");
                duke.width = duke.width + 1;
                duke.height = duke.height + 1;
                Agent.width = Agent.width - 1;
                Agent.height = Agent.height - 1;
            }

            }




    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time) {
        //sleep
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }

    //Graphics setup method
    private void setUpGraphics() {
        frame = new JFrame("Game Land");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);


        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");
    }

}


//*******************************************************************************

// Class Definition Section
