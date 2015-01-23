
public abstract class Creature
	{
	private int hitPoints;
	private String name;
	
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
	
	//public abstract void attack(int hitPoints, int damage, int monsterDamage, int heroHP, int strengthLevel);
	
	public abstract void defend();
	
	}
