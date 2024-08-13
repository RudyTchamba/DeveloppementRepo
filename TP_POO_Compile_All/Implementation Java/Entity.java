public class Entity{
	protected String mName;
	public int mPosition;
	protected int mLifetime;
	protected String mTypeEntity;
	public Entity(String name, int position, String typeEntity)
	{
		this.mName=name;
		this.mPosition=position;
		this.mTypeEntity=typeEntity;
	}
	public void setName(String name)
	{
		this.mName=name;
	}
	public String getName()
	{
		return this.mName;
	}
	public void moveEntity(int position)
	{
		this.mPosition=position;
	}
	protected void setTypeEntity(String typeEntity)
	{
		this.mTypeEntity=typeEntity;
	}
}
