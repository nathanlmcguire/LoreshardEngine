import java.util.ArrayList;


public class Monster extends Creature
	{
	private boolean boss;
	private String location;
	private int monsterDamage;
	
	static ArrayList <Monster> monsters = new ArrayList<Monster>();
	
	public Monster(String n, int h, boolean b, String l, int md)
		{
		setHitPoints(h);
		setName(n);
		boss = b;
		location = l;
		monsterDamage = md;
		}
	@Override
	public void attack(int hitPoints, int damage, int monsterDamage, int heroHP, int strengthLevel)
		{
		//takes in the hero health and the monster damage returns damage done
		}
	
	@Override
	public void defend()
		{
		//nothing yet
		}
	}
