import java.util.ArrayList;


public class Monster extends Creature
	{
	private boolean boss;
	private String location;
	private int damage;
	
	static ArrayList <Monster> monsters = new ArrayList<Monster>();
	
	public Monster(String n, int h, boolean b, String l, int d)
		{
		setHitPoints(h);
		setName(n);
		boss = b;
		location = l;
		damage = d;
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
