import java.util.ArrayList; 

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Hero extends Creature
	{
	private int heroHP;
	private int adrenaline;
	private int overAllLevel;
	private int magicLevel;
	private int agilityLevel;
	private int strengthLevel;
	private int speechLevel;
	private String characterClass;
	
	static ArrayList <Hero> inventory = new ArrayList<Hero>();
	
	
	public Hero(String n, int h, int ad, int o, int m, int ag, int st, int sp, String c)
		{
		setName(n);
		heroHP = h;
		adrenaline = ad;
		overAllLevel = o;
		magicLevel = m;
		agilityLevel = ag;
		strengthLevel = st;
		speechLevel = sp;
		characterClass = c;
		}
	
	
	public static void chooseAttack()
		{
		JFrame frame = new JFrame();
		int CombatChoice;
		Object[] combatType = {"Melee", "Magic", "Scroll"};
		CombatChoice = JOptionPane.showOptionDialog(frame, "What would you like to do?",
				"COMBAT",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, combatType, combatType[1]);
		switch(CombatChoice)
			{
			case 0:
				{
				System.out.println("Melee");
				//attack(10, 3, 3, 20, 2);
				break;
				}
			case 1:
				{
				System.out.println("Magic");
				break;
				}
			case 2:
				{
				System.out.println("Scroll");
				break;
				}
			}
		}

	@Override
	public void attack(int hitPoints, int damage, int monsterDamage, int heroHP, int strengthLevel)
		{			
		JFrame frame = new JFrame();
		int meleeChoice;
		Object[] attackType = {"High", "Medium", "Low"};
		meleeChoice = JOptionPane.showOptionDialog(frame, "Where would you like to strike?",
				"MELEE",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, attackType, attackType[1]);
		switch(meleeChoice)
			{
			case 0:
				{
				
				break;
				}
			case 1:
				{

				break;
				}
			case 2:
				{

				break;
				}
			}
		}
	
	@Override
	public void defend()
		{
		//nothing yet
		}
	
	public void loot()
		{
		//randomly adds a piece of loot to the inventory
		}
	
	public void levelUp(int overAllLevel)
		{
		JFrame frame = new JFrame();
		int levelUpChoice;
		Object[] level = {"Magic", "Agility", "Strength", "Speech"};
		levelUpChoice = JOptionPane.showOptionDialog(frame, "What would you like to level up in?",
				"LEVEL UP: " + overAllLevel + " > " + (overAllLevel + 1) + "",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, level, level[1]);
		overAllLevel++;
		switch(levelUpChoice)
			{
			case 0:
				{
				
				break;
				}
			case 1:
				{
				break;
				}
			case 2:
				{
				break;
				}
			case 3:
				{
				break;
				}
			}
		}
	//also add:
	//buy/sell method
	//potion craft method
	//enhance attack method
	
	}
