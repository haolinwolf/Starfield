import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Starfield extends PApplet {


Particle [] explosion;//your code here
public void setup()
{
	size(400,400);//your code here
	explosion = new Particle[200];
	for (int nI = 0; nI < 199; nI++)
	{
		explosion[nI] = new NormalParticle();
	}
	explosion[199] = new OddballParticle();
	
}
public void draw()
{
	background(0);
	for (int nI = 0; nI < 200; nI++)
	{
		explosion[nI].move();
		explosion[nI].show();
	}

	explosion[199].show();//your code here
}
class NormalParticle implements Particle
{
	double myX, myY, speed, angle;
	int colorA, colorB, colorC;
	NormalParticle()
	{
	     myX = myX +(Math.random()*400);
	     myY = myY +(Math.random()*400);
	     speed = Math.random()*10;
	     angle = Math.PI*2*Math.random();
	     colorA = (int)(Math.random()*251);
	     colorB = (int)(Math.random()*251);  
	     colorC = (int)(Math.random()*251); 
	}

	public void move()
	{
		angle+=0.01f;
	 myX = myX + Math.cos(angle)*speed;
	 myY = myY + Math.sin(angle)*speed;
	}

	public void show()
	{
	 fill(colorA,colorB,colorC,100);
	 ellipse((int)myX,(int)myY,10,10);//your code here
	}
}
interface Particle
{
	public void show();
	public void move();//your code here
}
class OddballParticle implements Particle
{
	double myX, myY, angle, speed;
	int myColor;
	OddballParticle()
	{
	 myX = (Math.random()*400);
	 myY = (Math.random()*400);
	 angle = Math.PI*2*Math.random();
	 speed = Math.random()*10; 
	 myColor = 250;
	}
	public void move()
 {
 	angle+=0.1f;
 	myX = myX +Math.cos(angle)*speed;
	 myY = myY + Math.sin(angle)*speed;
 }
	public void show()
	{
		noStroke();
	 fill(myColor);
	 ellipse((int)myX,(int)myY,20,20);
	}//your code here

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
