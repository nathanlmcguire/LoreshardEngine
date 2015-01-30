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
	static ArrayList <Item> heroInventory = new ArrayList<Item>();
	
	
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
	
	
	public static void chooseAttack(int monsterNum)
		{
		int weaponNumber;
		JFrame frame = new JFrame();
		int CombatChoice;
		int damage = 1;
		
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
				
				for(int i = 0; i < Hero.heroInventory.size(); i++)
					{
					System.out.println(Hero.heroInventory.get(i).getItemType() + " hi");
					if(Hero.heroInventory.size() > 0)
						{
						if(Hero.heroInventory.get(i).getItemType().equals("Weapon") && Hero.heroInventory.get(i).getIsEquipped() == true)
							{
							damage = Hero.heroInventory.get(i).getDamage();
							
							}
						}
					else
						{
						damage = 2;
						}
					}
				attack(Monster.monsters.get(monsterNum).getHitPoints(), Monster.monsters.get(monsterNum).getMonsterDamage(), 3, Hero.heroes.get(0).getHeroHP(), Hero.heroes.get(0).getStrengthLevel());
				Monster.monsters.get(monsterNum).setHitPoints(10);
				break;
				}
			case 1:
				{
				castMagic(Monster.monsters.get(monsterNum).getHitPoints(), Hero.heroes.get(0).getMagicLevel());
				break;
				}
			case 2:
				{
				
				break;
				}
			}
		}

	public static void attack(int hitPoints, int damage, int monsterDamage, int heroHP, int strengthLevel)
		{			
		JFrame frame = new JFrame();
		int meleeChoice;
		damage = (int) (Math.random() * damage) + strengthLevel;
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
				damage = damage + (strengthLevel * 2);
				JOptionPane.showMessageDialog(frame, "You attack high and do " + damage + " damage to the monster!",
						"COMBAT",
						JOptionPane.QUESTION_MESSAGE);	
				hitPoints = hitPoints - damage;
				JOptionPane.showMessageDialog(frame, "The monster has " + hitPoints + " HP left!",
						"COMBAT",
						JOptionPane.QUESTION_MESSAGE);		
				break;
				}
			case 1:
				{
				damage = damage + strengthLevel;
				JOptionPane.showMessageDialog(frame, "You attack mid and do " + damage + " damage to the monster!",
						"COMBAT",
						JOptionPane.QUESTION_MESSAGE);	
				hitPoints = hitPoints - damage;
				JOptionPane.showMessageDialog(frame, "The monster has " + hitPoints + " HP left!",
						"COMBAT",
						JOptionPane.QUESTION_MESSAGE);	
				break;
				}
			case 2:
				{
				JOptionPane.showMessageDialog(frame, "You attack low and do " + damage + " damage to the monster!",
						"COMBAT",
						JOptionPane.QUESTION_MESSAGE);			
				hitPoints = hitPoints - damage;
				JOptionPane.showMessageDialog(frame, "The monster has " + hitPoints + " HP left!",
						"COMBAT",
						JOptionPane.QUESTION_MESSAGE);	
				break;
				}
			}
		Monster.monsters.get(0).setHitPoints(hitPoints);
		if(hitPoints <= 0)
			{
			JOptionPane.showMessageDialog(frame, "You have defeated the monster!",
					"COMBAT",
					JOptionPane.QUESTION_MESSAGE);	
			Hero.heroInventory.add(Hero.openLoot());
			Hero.levelUp(Hero.heroes.get(0).getHeroHP(), Hero.heroes.get(0).getAdrenaline(), Hero.heroes.get(0).getOverAllLevel(), Hero.heroes.get(0).getMagicLevel(), Hero.heroes.get(0).getAgilityLevel(), Hero.heroes.get(0).getStrengthLevel(), Hero.heroes.get(0).getSpeechLevel());
			}
		}
	
	public static void castMagic(int hitPoints, int magicLev)
		{
		JFrame frame = new JFrame();
		Object[] magicType = {"Fire", "Water", "Earth", "Air"};
		int magicChoice = JOptionPane.showOptionDialog(frame, "What element would you like to cast?",
				"COMBAT",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, magicType, magicType[1]);
		
		switch(magicChoice)
			{
			case 0:
				{
				JOptionPane.showMessageDialog(frame, "You blast fire at the creature!",
						"COMBAT",
						JOptionPane.QUESTION_MESSAGE);
				}
			case 1:
				{
				JOptionPane.showMessageDialog(frame, "You heal yourself!",
						"COMBAT",
						JOptionPane.QUESTION_MESSAGE);
				}
			case 2:
				{
				JOptionPane.showMessageDialog(frame, "You turn your skin to stone!",
						"COMBAT",
						JOptionPane.QUESTION_MESSAGE);
				}
			case 3:
				{
				JOptionPane.showMessageDialog(frame, "You teleport past the monster!",
						"COMBAT",
						JOptionPane.QUESTION_MESSAGE);
				}
			}
		}
	
	public void defend()
		{
		//nothing yet
		}
	
	public static Item openLoot()
		{
		JFrame frame = new JFrame();
		int lootNumber = (int) (Math.random() * Item.items.size());
		JOptionPane.showMessageDialog(frame, "You found: " + Item.items.get(lootNumber).getItemName() + "!",
				"LOOTING",
				JOptionPane.QUESTION_MESSAGE);
		Item.items.get(lootNumber).setIsEquipped(true);
		return Item.items.get(lootNumber);
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


	public static ArrayList<Item> getInventory()
		{
		return heroInventory;
		}


	public static void setInventory(ArrayList<Item> inventory)
		{
		Hero.heroInventory = inventory;
		}
	
	
	}
