public class Mouse extends Entity
{
	public String mSex;
	private int mAge;
	private int mHealth;
	public int isDead;
	private Maize maizeEaten[] = new Maize[25];
	private int nbEat=0;
	public static Mouse listMouse[] = new Mouse[25];
	public static int nbMouse=0;
	public Mouse(String name, int position, String sex)
	{
		super(name,position,"mouse");
		this.mSex=sex;
		this.mHealth=8;
		this.mAge=1;
		this.isDead=0;
	}
	public void AgeUp()
	{
		this.mAge++;
	}
	public void HealthUp()
	{
		this.mHealth++;
	}
	public void HealthDown()
	{
		if(this.mHealth>0)
		{
			this.mHealth--;
		}
		else
		{
			this.isDead=1;
			this.moveEntity(0);
			this.nbMouse--;
		}
	}
	public void EatMaize(Maize maize)
	{
		maize.isEat=1;
		maize.moveEntity(0);
		this.maizeEaten[nbEat]=maize;
		nbEat++;
		if(maize.getQuality()==0)
		{
			this.HealthDown();	
		}
		else
		{
			this.HealthUp();
		}
		
	}
	public void Reproduction()
	{
		if(this.nbMouse<=22)
		{
			int i;
			int position1=1+(int)(Math.random() * 25);
			int position2=1+(int)(Math.random() * 25);
			Mouse newMouse = new Mouse("Mouse"+this.nbMouse,position1,"Female");
			this.listMouse[this.nbMouse]=newMouse;
			this.nbMouse++;
			newMouse = new Mouse("Mouse"+this.nbMouse,position2,"Male");
			this.listMouse[this.nbMouse]=newMouse;
			this.nbMouse++;
		}
	}
}
