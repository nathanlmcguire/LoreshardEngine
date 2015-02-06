import java.util.ArrayList; 

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Hero extends Creature
	{
	private int heroHP;
	private int maxHeroHP;
	private int adrenaline;
	private int overAllLevel;
	private int magicLevel;
	private int agilityLevel;
	private int strengthLevel;
	private int speechLevel;
	private String characterClass;
	private int wardPower;
	static ArrayList <Hero> heroes = new ArrayList<Hero>();
	static ArrayList <Item> heroInventory = new ArrayList<Item>();
	
	
	public Hero(String n, int ch, int mh, int ad, int o, int m, int ag, int st, int sp, String c, int wp)
		{
		setName(n);
		heroHP = ch;
		maxHeroHP = mh;
		adrenaline = ad;
		overAllLevel = o;
		magicLevel = m;
		agilityLevel = ag;
		strengthLevel = st;
		speechLevel = sp;
		characterClass = c;
		wardPower = wp;
		}


	public static void chooseAttack(int monsterNum)
		{
		int weaponNumber;
		int CombatChoice;
		int damage = 2;
		int wardCost = 0;
		JFrame frame = new JFrame();
		
		if(Hero.heroInventory.get(2) instanceof Ward)
			{
			Ward ward = (Ward) Hero.heroInventory.get(2);
			wardCost = ward.getWardPowerNeeded();
			}
		
		if(Hero.heroes.get(0).getWardPower() < wardCost)
			{
			Object[] combatType = {"Melee", "Magic", "Potion"};
			CombatChoice = JOptionPane.showOptionDialog(frame, "What would you like to do?",
					"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null, combatType, combatType[1]);
			}
		else
			{
			Object[] combatType = {"Melee", "Magic", "Potion", "Ward"};
			CombatChoice = JOptionPane.showOptionDialog(frame, "What would you like to do?",
					"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null, combatType, combatType[1]);
			}
		
		
		Hero.heroes.get(0).setWardPower(Hero.heroes.get(0).getWardPower() + 1);
		switch(CombatChoice)
			{
			case 0:
				{
				if(Hero.heroInventory.get(0) instanceof Weapon)
					{
					Weapon weapon = (Weapon) Hero.heroInventory.get(0);
					damage = weapon.getDamage();
					}
				attack(Monster.monsters.get(monsterNum).getHitPoints(), Monster.monsters.get(monsterNum).getMonsterDamage(), damage, Hero.heroes.get(0).getHeroHP(), Hero.heroes.get(0).getStrengthLevel(), monsterNum);
				break;
				}
			case 1:
				{
				Magic.castMagic(Monster.monsters.get(monsterNum).getHitPoints(), Hero.heroes.get(0).getMagicLevel(), monsterNum);
				break;
				}
			case 2:
				{
				
				break;
				}
			case 3:
				{
				Ward.useWard(monsterNum);
				break;
				}
			}
		continueBattle(monsterNum);
		}

	public static void attack(int hitPoints, int monsterDamage, int damage, int heroHP, int strengthLevel, int monsterNum)
		{	
		ImageIcon icon = new ImageIcon(("combat.jpg"));
		int meleeChoice;
		damage = (int) (Math.random() * (damage + strengthLevel)) + strengthLevel;
		JFrame frame = new JFrame();
		
		Object[] attackType = {"High", "Medium", "Low"};
		meleeChoice = JOptionPane.showOptionDialog(frame, "Where would you like to strike?",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + heroHP + "",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, attackType, attackType[1]);
		
		
		
		if(Monster.defend(meleeChoice))
			{
			switch(meleeChoice)
				{
				case 0:
					{
					damage = checkForCrit(damage) + (strengthLevel * 2);
					JOptionPane.showMessageDialog(frame, "You attack high and do " + damage + " damage to the monster!",
							"" + Hero.heroes.get(0).getName() + "'s HP = " + heroHP + "",
							JOptionPane.QUESTION_MESSAGE,
							icon);	
					hitPoints = hitPoints - damage;
					
					JOptionPane.showMessageDialog(frame, "The monster has " + hitPoints + " HP left!",
							"" + Hero.heroes.get(0).getName() + "'s HP = " + heroHP + "",
							JOptionPane.QUESTION_MESSAGE,
							icon);		
					break;
					}
				case 1:
					{
					damage = checkForCrit(damage) + strengthLevel;
					
					JOptionPane.showMessageDialog(frame, "You attack mid and do " + damage + " damage to the monster!",
							"" + Hero.heroes.get(0).getName() + "'s HP = " + heroHP + "",
							JOptionPane.QUESTION_MESSAGE,
							icon);
					
					hitPoints = hitPoints - damage;
					JOptionPane.showMessageDialog(frame, "The monster has " + hitPoints + " HP left!",
							"" + Hero.heroes.get(0).getName() + "'s HP = " + heroHP + "",
							JOptionPane.QUESTION_MESSAGE,
							icon);	
					break;
					}
				case 2:
					{
					damage = checkForCrit(damage);
					JOptionPane.showMessageDialog(frame, "You attack low and do " + damage + " damage to the monster!",
							"" + Hero.heroes.get(0).getName() + "'s HP = " + heroHP + "",
							JOptionPane.QUESTION_MESSAGE,
							icon);			
					hitPoints = hitPoints - damage;
					JOptionPane.showMessageDialog(frame, "The monster has " + hitPoints + " HP left!",
							"" + Hero.heroes.get(0).getName() + "'s HP = " + heroHP + "",
							JOptionPane.QUESTION_MESSAGE,
							icon);	
					break;
					}
				}
			Monster.monsters.get(monsterNum).setHitPoints(hitPoints);
			}
		else
			{
			JOptionPane.showMessageDialog(frame, "Your attack was blocked!",
					"" + Hero.heroes.get(0).getName() + "'s HP = " + heroHP + "",
					JOptionPane.QUESTION_MESSAGE);		
			}
		}
	
	public static int checkForCrit(int damage)
		{
		int chance = (int) (Math.random() * 100) + 1;
		ImageIcon icon = new ImageIcon(("crit.jpg"));
		JFrame frame = new JFrame();
				
		if(chance <= 5)
			{
			JOptionPane.showMessageDialog(frame, "CRITICAL HIT, 2x DAMAGE!",
					"CRITICAL HIT",
					JOptionPane.QUESTION_MESSAGE,
					icon);
			damage = damage * 2;
			}
		return damage;
		}
	
	public static boolean defend(int enemyAttackLocation)
		{
		ImageIcon iconOne = new ImageIcon(("shield.jpg"));
		ImageIcon iconTwo = new ImageIcon(("claws.jpg"));
		int blockChoice;
		JFrame frame = new JFrame();
		
		Object[] blockType = {"High", "Medium", "Low"};
		blockChoice = JOptionPane.showOptionDialog(frame, "Where would you like to block?",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, blockType, blockType[1]);
		if(blockChoice == enemyAttackLocation)
			{
			JOptionPane.showMessageDialog(frame, "You block the opponent's blow!",
					"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "",
					JOptionPane.QUESTION_MESSAGE,
					iconOne);
			return true;
			}
		else
			{
			JOptionPane.showMessageDialog(frame, "Your opponent gets past your block!",
					"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "",
					JOptionPane.QUESTION_MESSAGE,
					iconTwo);
			return false;
			}
		}
	
	public static void continueBattle(int monsterNum)
		{
		JFrame frame = new JFrame();
		
		if(Monster.monsters.get(monsterNum).getHitPoints() <= 0)
			{
			JOptionPane.showMessageDialog(frame, "You have defeated the monster!",
					"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "",
					JOptionPane.QUESTION_MESSAGE);
			Hero.levelUp(Hero.heroes.get(0).getMaxHeroHP(), Hero.heroes.get(0).getAdrenaline(), Hero.heroes.get(0).getOverAllLevel(), Hero.heroes.get(0).getMagicLevel(), Hero.heroes.get(0).getAgilityLevel(), Hero.heroes.get(0).getStrengthLevel(), Hero.heroes.get(0).getSpeechLevel());
			Hero.openLoot();
			}
		else
			{
			Monster.attack(Monster.monsters.get(monsterNum).getHitPoints(), Monster.monsters.get(monsterNum).getMonsterDamage(), 3, Hero.heroes.get(0).getHeroHP(), Hero.heroes.get(0).getStrengthLevel(), monsterNum);
			}
		}
	
	public static void openLoot()
		{
		int lootNumber = (int) (Math.random() * Item.items.size());
		ImageIcon icon = new ImageIcon(("search.jpg"));
		JFrame frame = new JFrame();
		
		JOptionPane.showMessageDialog(frame, "You found: " + Item.items.get(lootNumber).getItemName() + "!",
				"LOOTING",
				JOptionPane.QUESTION_MESSAGE,
				icon );
		Item.items.get(lootNumber).setIsEquipped(true);
		Item loot = Item.items.get(lootNumber);
		
			if(loot instanceof Weapon && Hero.heroInventory.get(0) instanceof Weapon)
				{
				Weapon oldWeapon = (Weapon) Hero.heroInventory.get(0);
				int oldDamage = oldWeapon.getDamage();
				
				Weapon newWeapon = (Weapon) loot;
				int newDamage = newWeapon.getDamage();
				if(newDamage > oldDamage)
					{
					Hero.heroInventory.set(0, loot);
					}
				}
			if(loot instanceof Armor && Hero.heroInventory.get(1) instanceof Armor)
				{
				Armor oldArmor = (Armor) Hero.heroInventory.get(1);
				int oldAC = oldArmor.getArmorLevel();
				
				Armor newArmor = (Armor) loot;
				int newAC = newArmor.getArmorLevel();
				if(newAC > oldAC)
					{
					Hero.heroInventory.set(1, loot);
					}
				}
			
			if(loot instanceof Ward && Hero.heroInventory.get(2) instanceof Ward)
				{
				Hero.heroInventory.set(2, loot);
				}
		
		showInventory(Hero.heroInventory.get(0).getItemName(), Hero.heroInventory.get(1).getItemName(), Hero.heroInventory.get(2).getItemName());
		}
	
	public static void showInventory(String weapon, String armor, String ward)
		{
		ImageIcon icon = new ImageIcon(("bag.jpg"));
		JFrame frame = new JFrame();
		
		JOptionPane.showMessageDialog(frame, "WEAPON: " + weapon + "\n ARMOR: " + armor + "\n WARD: " + ward + "",
				"INVENTORY",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		}
	
	public static void levelUp(int maxHeroHP, int adrenaline, int overAllLevel, int magicLevel, int agilityLevel, int strengthLevel, int speechLevel)
		{
		int levelUpChoice;
		ImageIcon icon = new ImageIcon(("arrow.jpg"));
		JFrame frame = new JFrame();
		
		Object[] level = {"Magic", "Agility", "Strength", "Speech"};
		levelUpChoice = JOptionPane.showOptionDialog(frame, "What would you like to level up in?",
				"LEVEL UP: " + overAllLevel + " > " + (overAllLevel + 1) + "",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, level, level[1]);
		
		overAllLevel++;
		Hero.heroes.get(0).setOverAllLevel(overAllLevel);
		maxHeroHP = maxHeroHP + (2 * strengthLevel);
		Hero.heroes.get(0).setMaxHeroHP(maxHeroHP);
		Hero.heroes.get(0).setHeroHP(maxHeroHP);
		switch(levelUpChoice)
			{
			case 0:
				{
				magicLevel++;
				JOptionPane.showMessageDialog(frame, "You have leveled up in Magic!",
						"Magic: " + (magicLevel - 1) + " > " + magicLevel + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				Hero.heroes.get(0).setMagicLevel(magicLevel);
				break;
				}
			case 1:
				{
				agilityLevel++;
				JOptionPane.showMessageDialog(frame, "You have leveled up in Agility!",
						"Agility: " + (agilityLevel - 1) + " > " + agilityLevel + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				Hero.heroes.get(0).setAgilityLevel(agilityLevel);
				break;
				}
			case 2:
				{
				strengthLevel++;
				JOptionPane.showMessageDialog(frame, "You have leveled up in Strength!",
						"Strength: " + (strengthLevel - 1) + " > " + strengthLevel + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				Hero.heroes.get(0).setStrengthLevel(strengthLevel);
				break;
				}
			case 3:
				{
				speechLevel++;
				JOptionPane.showMessageDialog(frame, "You have leveled up in Charisma!",
						"Speech"
						+ ": " + (speechLevel - 1) + " > " + speechLevel + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				Hero.heroes.get(0).setSpeechLevel(speechLevel);
				break;
				}
			}
		}
	
	//also add:
	//buy/sell method
	//potion craft method
	//enhance attack method

	
	
	public int getWardPower()
		{
		return wardPower;
		}


	public int getMaxHeroHP()
		{
		return maxHeroHP;
		}


	public void setMaxHeroHP(int maxHeroHP)
		{
		this.maxHeroHP = maxHeroHP;
		}


	public void setWardPower(int wardPower)
		{
		this.wardPower = wardPower;
		}
	
	
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
