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

Particle [] number;

public void setup()
{
	size(500,500);
	number=new Particle[1000];
	number[0]=new OddballParticle();
	number[1]=new JumboParticle();
	for (int i=2;i<number.length;i++){
		number[i]=new NormalParticle();
	}
}

public void draw()
{
	background(0);
	for (int i=0;i<number.length;i++){
		number[i].move();
		number[i].show();
	}
}

interface Particle
{
	public void move();
	public void show();
}

class NormalParticle implements Particle
{
	double x,y,angle,speed;
	int colorfulR,colorfulG,colorfulB;
	NormalParticle()
	{
		x=250;
		y=250;
		angle=(Math.random()*2)*(Math.PI);
		speed=Math.random()*2+2;
		colorfulR=(int)(Math.random()*255+1);
		colorfulG=(int)(Math.random()*255+1);
		colorfulB=(int)(Math.random()*255+1);
	}

	public void move()
	{
		x=x+(Math.cos(angle)*speed);
		y=y+(Math.sin(angle)*speed);
		if ((x<0 || x>500) || (y<0 || y>500)){
			x=250;
			y=250;
			angle=(Math.random()*2)*(Math.PI);
			speed=Math.random()*2+2;
		}
	}

	public void show()
	{
		noStroke();
		fill(colorfulR,colorfulG,colorfulB);
		ellipse((float)x,(float)y,4,4);
	}
}

class OddballParticle implements Particle
{
	int speed;
	double x,y,angle;
	OddballParticle()
	{
		x=250;
		y=250;
		angle=(Math.random()*2)*(Math.PI);
		speed=(int)(Math.random()*5+1);
	}

	public void move()
	{
		x=x+(Math.cos((Math.random()*2)*(Math.PI))*(int)(Math.random()*5+1));
		y=y+(Math.sin((Math.random()*2)*(Math.PI))*(int)(Math.random()*5+1));
		if ((x<0 || x>500) || (y<0 || y>500)){
			x=250;
			y=250;
		}
	}

	public void show()
	{
		noStroke();
		fill(255);
		ellipse((float)x,(float)y,50,50);
	}
}

class JumboParticle extends NormalParticle
{
	double x,y,angle,speed;
	JumboParticle()
	{
		x=250;
		y=250;
		angle=(Math.random()*2)*(Math.PI);
		speed=Math.random()*2+2;
	}

	public void move()
	{
		x=x+(Math.cos(angle)*speed);
		y=y+(Math.sin(angle)*speed);
		if ((x<0 || x>500) || (y<0 || y>500)){
			x=250;
			y=250;
			angle=(Math.random()*2)*(Math.PI);
			speed=Math.random()*2+2;
			
		}
	}

	public void show()
	{
		noStroke();
		fill(0,255,0);
		ellipse((float)x,(float)y,80,80);
	}
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
