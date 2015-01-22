
public abstract class Creature
	{
	protected int hitPoints;
	protected String name;
	
	public int getHitPoints()
		{
		return hitPoints;
		}
	
	public void setHitPoints(int hitPoints)
		{
		this.hitPoints = hitPoints;
		}
	
	public String getName()
		{
		return name;
		}
	
	public void setName(String name)
		{
		this.name = name;
		}
	
	public abstract void attack();
	
	public abstract void defend();
	
	}
