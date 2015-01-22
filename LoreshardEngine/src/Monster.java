import java.util.ArrayList;


public class Monster extends Creature
	{
	protected boolean boss;
	protected String location;
	
	ArrayList <Monster> monster = new ArrayList<Monster>();
	
	public Monster(int h, String n, boolean b, String l)
		{
		setHitPoints(h);
		setName(n);
		boss = b;
		location = l;
		}
	@Override
	public void attack()
		{
		//takes in the hero health and the monster damage returns damage done
		}
	
	@Override
	public void defend()
		{
		//nothing yet
		}
	}
