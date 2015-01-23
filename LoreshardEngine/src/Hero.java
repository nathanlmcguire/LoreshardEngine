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
	static ArrayList <Hero> heroes = new ArrayList<Hero>();
	
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
				attack(10, 3, 3, Hero.heroes.get(0).getHeroHP(), Hero.heroes.get(0).getStrengthLevel());
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

	public static int attack(int hitPoints, int damage, int monsterDamage, int heroHP, int strengthLevel)
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
				JOptionPane.showMessageDialog(frame, "You do " + damage + strengthLevel + " damage to the monster!",
						"COMBAT",
						JOptionPane.QUESTION_MESSAGE);				
				JOptionPane.showMessageDialog(frame, "The monster has " + hitPoints + " HP left!",
						"COMBAT",
						JOptionPane.QUESTION_MESSAGE);		
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
		return hitPoints;
		}
	
	public void defend()
		{
		//nothing yet
		}
	
	public static void openLoot()
		{
		JFrame frame = new JFrame();
		int lootNumber = (int) (Math.random() * Item.items.size());
		JOptionPane.showMessageDialog(frame, "You found: " + Item.items.get(lootNumber).getItemName() + "!",
				"LOOTING",
				JOptionPane.QUESTION_MESSAGE);
		//add to inventory
		}
	
	public static void levelUp(int heroHP, int adrenaline, int overAllLevel, int magicLevel, int agilityLevel, int strengthLevel, int speechLevel)
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
		heroHP = heroHP + (10 * strengthLevel);
		switch(levelUpChoice)
			{
			case 0:
				{
				magicLevel++;
				JOptionPane.showMessageDialog(frame, "You have leveled up in Magic!",
						"LEVEL UP",
						JOptionPane.QUESTION_MESSAGE);
				break;
				}
			case 1:
				{
				agilityLevel++;
				JOptionPane.showMessageDialog(frame, "You have leveled up in Agility!",
						"LEVEL UP",
						JOptionPane.QUESTION_MESSAGE);
				break;
				}
			case 2:
				{
				strengthLevel++;
				JOptionPane.showMessageDialog(frame, "You have leveled up in Strength!",
						"LEVEL UP",
						JOptionPane.QUESTION_MESSAGE);
				break;
				}
			case 3:
				{
				speechLevel++;
				JOptionPane.showMessageDialog(frame, "You have leveled up in Charisma!",
						"LEVEL UP",
						JOptionPane.QUESTION_MESSAGE);
				break;
				}
			}
		}
	
	//also add:
	//buy/sell method
	//potion craft method
	//enhance attack method


	public int getHeroHP()
		{
		return heroHP;
		}


	public void setHeroHP(int heroHP)
		{
		this.heroHP = heroHP;
		}


	public int getAdrenaline()
		{
		return adrenaline;
		}


	public void setAdrenaline(int adrenaline)
		{
		this.adrenaline = adrenaline;
		}


	public int getOverAllLevel()
		{
		return overAllLevel;
		}


	public void setOverAllLevel(int overAllLevel)
		{
		this.overAllLevel = overAllLevel;
		}


	public int getMagicLevel()
		{
		return magicLevel;
		}


	public void setMagicLevel(int magicLevel)
		{
		this.magicLevel = magicLevel;
		}


	public int getAgilityLevel()
		{
		return agilityLevel;
		}


	public void setAgilityLevel(int agilityLevel)
		{
		this.agilityLevel = agilityLevel;
		}


	public int getStrengthLevel()
		{
		return strengthLevel;
		}


	public void setStrengthLevel(int strengthLevel)
		{
		this.strengthLevel = strengthLevel;
		}


	public int getSpeechLevel()
		{
		return speechLevel;
		}


	public void setSpeechLevel(int speechLevel)
		{
		this.speechLevel = speechLevel;
		}


	public String getCharacterClass()
		{
		return characterClass;
		}


	public void setCharacterClass(String characterClass)
		{
		this.characterClass = characterClass;
		}


	public static ArrayList<Hero> getInventory()
		{
		return inventory;
		}


	public static void setInventory(ArrayList<Hero> inventory)
		{
		Hero.inventory = inventory;
		}
	
	
	}
