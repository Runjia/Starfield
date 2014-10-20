Particle [] number;


void setup()
{
	size(500,500);
	number=new Particle[1000];
	for (int i=1;i<number.length;i++){
		number[0]=new OddballParticle();
		number[i]=new NormalParticle();
	}
}

void draw()
{
	background(0);
	for (int i=0;i<number.length;i++){
		number[i].move();
		number[i].show();
	}
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
		}
	}

	public void show()
	{
		noStroke();
		fill(colorfulR,colorfulG,colorfulB);
		ellipse((float)x,(float)y,4,4);
	}
}

interface Particle
{
	public void move();
	public void show();
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


