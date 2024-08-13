public class Cat extends Entity
{
	public String mSex;
	private int mAge;
	private int mHealth;
	private Mouse mouseEaten[] = new Mouse[25];
	private int nbEat=0;
	private int nbKill=0;
	static public int healthMax=15;
	public int isDead;
	public static Cat listCat[] = new Cat[25];
	public static int nbCat=0;
	public Cat(String name, int position, String sex)
	{
		super(name,position,"cat");
		this.mSex=sex;
		this.mHealth=10;
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
			this.nbCat--;
		}
	}
	public int getHealth()
	{
		return this.mHealth;
	}
	public void KillMouse(Mouse mouse)
	{
		this.nbKill++;
		mouse.nbMouse--;
		mouse.isDead=1;
		if(this.mHealth<this.healthMax)
		{
			this.EatMouse(mouse);
		}
		mouse.moveEntity(0);
	}
	public void EatMouse(Mouse mouse)
	{
		this.mouseEaten[nbEat]=mouse;
		this.HealthUp();
		this.nbEat++;
	}
	public void Reproduction()
	{
		if(this.nbCat<=22)
		{
			int i;
			int position1=1+(int)(Math.random() * 25);
			int position2=1+(int)(Math.random() * 25);
			Cat newCat = new Cat("Cat"+this.nbCat,position1,"Female");
			this.listCat[this.nbCat]=newCat;
			this.nbCat++;
			newCat = new Cat("Cat"+this.nbCat,position2,"Male");
			this.listCat[this.nbCat]=newCat;
			this.nbCat++;
		}
	}
}
