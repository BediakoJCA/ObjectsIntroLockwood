import java.awt.*;

public class Hero {

    //variable decleration
    public int xpos;        //xposition
    public int ypos;        //yposition
    public int dx;          //the speed of the hero in the x direction
    public int dy;//the speed of the hero in the y direction
    public int width;
    public int height;
    public boolean isAlive;     // a boolean to denote if the hero is alive or notx
    public Rectangle rec;
    //constructor method
    public Hero(int pXpos, int pYpos, int pdx, int pdy) {
        xpos = pXpos;
        ypos = pYpos;

        dx = pdx;
        dy = pdy;
        width = 60;
        height = 80;
        isAlive = true;
        rec=new Rectangle(xpos, ypos,width,height);

    }

    public void printInfo() {
        System.out.println("xpos" + xpos + "ypos" + ypos + "dx" + dx + "dy" + dy + "width" + width + "height" + height + "isAlive" + isAlive);

    }
    public void wrappingMove() {
            //as an astronaut hits a wall it shows up on the opposite wall.
        //donow: set this up f`or the other three walls

        if(xpos>=1000){
            xpos=1;}
            if(ypos>=800){
                ypos=1;}
        if(xpos<0){
            xpos=1000;}
        if(ypos<0){
            ypos=800;}


        xpos=xpos+dx ;
        ypos=ypos+dy;
        rec = new Rectangle(xpos,ypos,width,height);

    }
        public void move() {
            xpos = xpos + 1;
            ypos = ypos + 1;
        }

public void bouncingMove(){
            if (xpos>1000){
                dx=-dx;}
    if (ypos>700){
        dy=-dy;}

            if (xpos<0){ dx=-dx;
        }
    if (ypos<0){
        dy=-dy;}

    xpos=xpos+dx ;
    ypos=ypos+dy;
    rec = new Rectangle(xpos,ypos,width,height);
}

}
