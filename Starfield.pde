
Particle [] explosion;//your code here
void setup()
{
	size(400,400);//your code here
	explosion = new Particle[200];
	for (int nI = 0; nI < 198; nI++)
	{
		explosion[nI] = new NormalParticle();
		explosion[198] = new JumboParticle();
	}
	
	explosion[199] = new OddballParticle();
	
}
void draw()
{
	background(0);
	for (int nI = 0; nI < 198; nI++)
	{
		explosion[nI].move();
		explosion[nI].show();
  
	}
	explosion[198].move();
  explosion[198].show();
 explosion[199].move();
	explosion[199].show();//your code here
}
class NormalParticle implements Particle
{
	double myX, myY, speed, angle;
	int colorA, colorB, colorC,mySize;
	NormalParticle()
	{
	     myX = 200;
	     myY = 200;
	     speed = Math.random()*5;
	     angle = Math.PI*2*Math.random();
	     colorA = (int)(Math.random()*251);
	     colorB = (int)(Math.random()*251);  
	     colorC = (int)(Math.random()*251); 
	     mySize = 10;
	}

	public void move()
	{
		angle+=0.01;
	 myX = myX + Math.cos(angle)*speed;
	 myY = myY + Math.sin(angle)*speed;
	}

	public void show()
	{
	 fill(colorA,colorB,colorC,150);
	 ellipse((int)myX,(int)myY,mySize,mySize);//your code here
	}
}
interface Particle
{
	public void show();
	public void move();//your code here
}
class JumboParticle extends NormalParticle
{
  JumboParticle()
  {
  	mySize = 40;
  	colorA = 150;
  	colorB = 150;
  	colorC = 150;
  }
}
class OddballParticle implements Particle
{
	double myX, myY, angle, speed;
	int myColor;
	OddballParticle()
	{
	 myX = 200;
	 myY = 200;
	 angle = Math.PI*2*Math.random();
	 speed = Math.random()*10; 
	 myColor = 250;
	}
	public void move()
 {
 	angle+=0.1;
 	myX = myX +Math.cos(angle)*speed;
	 myY = myY + Math.sin(angle)*speed;
 }
	void show()
	{
		noStroke();
	 fill(myColor);
	 ellipse((int)myX,(int)myY,20,20);
	}//your code here

}