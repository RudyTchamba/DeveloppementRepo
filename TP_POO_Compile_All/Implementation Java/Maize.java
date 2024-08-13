public class Maize extends Entity
{
	private int mQuality;
	public int isEat=0;
	public static Maize listMaize[] = new Maize[25];
	public static int nbMaize=0;
	public Maize(String name, int position)
	{
		super(name,position,"maize");
		this.mQuality=6;
		this.isEat=0;
	}
	public void QualityDown()
	{
		if(this.mQuality>0)
		{
			this.mQuality--;
		}
		else
		{
			this.nbMaize--;
			this.mPosition=0;
		}
	}
	public int getQuality()
	{
		return this.mQuality;
	}
}
