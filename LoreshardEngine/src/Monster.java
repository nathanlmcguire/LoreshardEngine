import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


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
	
	public static int randomize()
		{
		JFrame frame = new JFrame();
		int monsterNumber = 0;
		
		if(Monster.monsters.size() <= 0)
			{
			JOptionPane.showMessageDialog(frame, "As the last of your foes falls to the ground the crowd cheers!",
					"",
					JOptionPane.QUESTION_MESSAGE);
			JOptionPane.showMessageDialog(frame, "You have beaten the arena, and are free to leave.",
					"",
					JOptionPane.QUESTION_MESSAGE);
			JOptionPane.showMessageDialog(frame, "You walk through the gates of the arena into a land of danger.",
					"",
					JOptionPane.QUESTION_MESSAGE);
			JOptionPane.showMessageDialog(frame, "Adventure awaits.",
					"",
					JOptionPane.QUESTION_MESSAGE);
			System.exit(0);
			}
		else
			{
			monsterNumber = (int) (Math.random() * monsters.size());
			JOptionPane.showMessageDialog(frame, "A monster enters the arena.",
					"COMBAT",
					JOptionPane.QUESTION_MESSAGE);
			JOptionPane.showMessageDialog(frame, "It is a " + Monster.monsters.get(monsterNumber).getName() + "!",
					"COMBAT",
					JOptionPane.QUESTION_MESSAGE);
			}
		return monsterNumber;
		}
	
	//@Override
	public static void attack(int hitPoints, int damage, int monsterDamage, int heroHP, int strengthLevel, int monsterNum)
		{
		JFrame frame = new JFrame();
		damage = (int) (Math.random() * damage) + 1;
		int enemyAttackLovation = (int) (Math.random() * 2);
		if(Hero.defend(enemyAttackLovation) == false)
			{
			if(Hero.heroInventory.get(1) instanceof Armor)
				{
				Armor armor = (Armor) Hero.heroInventory.get(1);
				heroHP = heroHP - (damage - armor.getArmorLevel());
				}
			Hero.heroes.get(0).setHeroHP(heroHP);
			JOptionPane.showMessageDialog(frame, "The monster attacks and does " + damage + " damage!",
					"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "",
					JOptionPane.QUESTION_MESSAGE);
			if(Hero.heroes.get(0).getHeroHP() <= 0)
				{
				JOptionPane.showMessageDialog(frame, "You have been slain!",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE);
				JOptionPane.showMessageDialog(frame, "GAME OVER",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE);
				System.exit(0);
				}
			}
		}
	
	//@Override
	public static boolean defend(int meleeChoice)
		{
		int enemyBlockLocation = (int) (Math.random() * 15);
		if(enemyBlockLocation == meleeChoice)
			{
			return true;
			}
		return false;
		}
	
	public boolean isBoss()
		{
		return boss;
		}

	public void setBoss(boolean boss)
		{
		this.boss = boss;
		}

	public String getLocation()
		{
		return location;
		}

	public void setLocation(String location)
		{
		this.location = location;
		}

	public int getMonsterDamage()
		{
		return monsterDamage;
		}

	public void setMonsterDamage(int monsterDamage)
		{
		this.monsterDamage = monsterDamage;
		}

	public static ArrayList<Monster> getMonsters()
		{
		return monsters;
		}

	public static void setMonsters(ArrayList<Monster> monsters)
		{
		Monster.monsters = monsters;
		}

	
	}
