import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Companion 
	{
	private String comName;
	private int comMaxHP;
	private int comHP;
	private int comDmg;
	private String attackType;
	private boolean companionPresence;
	private int comArmor;
	
	public Companion(String n, int mh, int h, int d, String at, boolean cp, int a)
		{
		n = comName;
		mh = comMaxHP;
		h = comHP;
		d = comDmg;
		at = attackType;  //Example:  slashes at the [monster], stabs the [monster], shoots fire at the [monster]
		cp = companionPresence;
		a = comArmor;
		}
	
	public static void generateCompanion()                                                                         
		{
		ImageIcon icon = new ImageIcon(("shield.jpg"));
		ImageIcon icon2 = new ImageIcon(("claws.jpg"));
		JFrame frame = new JFrame();
		String name = "";
		int nameNum = (int) (Math.random() * 10) + 1;
		String attack = "";
		int attackNum = (int) (Math.random() * 9) + 1;
		int armor = (int) (Math.random() * 3);
		int damage = (int) (Math.random() * 15) + 5;
		int health = (int) (Math.random() * Hero.heroes.get(0).getHeroHP()) + 20;
		
			
		
		switch(nameNum)
			{
			case 1:	
				{
				name = ("Tyren");
				break;
				}
			case 2:	
				{
				name = ("Goron");
				break;
				}
			case 3:	
				{
				name = ("Keld");
				break;
				}
			case 4:	
				{
				name = ("Shiare");
				break;
				}
			case 5:	
				{
				name = ("Aulra");
				break;
				}
			case 6:	
				{
				name = ("Dusk");
				break;
				}
			case 7:	
				{
				name = ("Yuri");
				break;
				}
			case 8:	
				{
				name = ("Rudvar");
				break;
				}
			case 9:	
				{
				name = ("Soolk");
				break;
				}
			case 10:	
				{
				name = ("Quern");
				break;
				}
			}
		
		JOptionPane.showMessageDialog(frame, "My name is " + name + " and I would be glad to accompany you.",
				"" + Hero.heroes.get(0).getName() + "'s HP = " +  Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				null);
		
		switch(attackNum)
			{
			case 1:	
				{
				attack = ("shoots fire");
				break;
				}
			case 2:	
				{
				attack = ("stabs a spear");
				break;
				}
			case 3:	
				{
				attack = ("fires an arrow");
				break;
				}
			case 4:	
				{
				attack = ("swings a blade");
				break;
				}
			case 5:	
				{
				attack = ("throws a knife");
				break;
				}
			case 6:	
				{
				attack = ("blasts lightning");
				break;
				}
			case 7:	
				{
				attack = ("punches");
				break;
				}
			case 8:	
				{
				attack = ("swings an axe");
				break;
				}
			case 9:	
				{
				attack = ("shoots a crossbow");
				break;
				}	
			}
		
		if(Hero.companions.get(0).isCompanionPresence())
			{
			Object[] actions = {name, Hero.companions.get(0).getComName()};
			int chosenAction = JOptionPane.showOptionDialog(frame, "Which companion do you want to accompany you?",
					"CHARACTER CREATION",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null, actions, actions[0]);	
			if(chosenAction == 0)
				{
				Hero.companions.set(0, new Companion(name, health, health, damage, attack, true, armor));	
				}
			}
		else
			{
			Hero.companions.set(0, new Companion(name, health, health, damage, attack, true, armor));		
			}
		}
	
	public static void attack(int monsterNum, int hitpoints)
		{
		ImageIcon attack = new ImageIcon(("attack.jpg"));
		JFrame frame = new JFrame();
		
		if(Hero.companions.get(0).isCompanionPresence())
			{
			int dmg = (int) (Math.random() * Hero.companions.get(0).getComDmg()) + Hero.companions.get(0).getComDmg();
			
			JOptionPane.showMessageDialog(frame, "" + Hero.companions.get(0).getComName() + " " + Hero.companions.get(0).getAttackType() + " at the monster and does " + dmg + " damage!",
					"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
					JOptionPane.QUESTION_MESSAGE,
					attack);	
			hitpoints = hitpoints - dmg;
			
			JOptionPane.showMessageDialog(frame, "The monster has " + hitpoints + " HP left!",
					"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
					JOptionPane.QUESTION_MESSAGE,
					attack);
			
			Monster.monsters.get(monsterNum).setHitPoints(hitpoints);	
			}
		else
			{
			System.out.println("IT ISN'T WORKING");	
			}
		}
	
	public static void defend(int monsterDamage)
		{
		ImageIcon icon = new ImageIcon(("shield.jpg"));
		ImageIcon icon2 = new ImageIcon(("claws.jpg"));
		JFrame frame = new JFrame();
		
		if(Hero.companions.get(0).isCompanionPresence())
			{
			int chance = (int) (Math.random() * 3) + 1;
			
			if(chance == 1)
				{
				JOptionPane.showMessageDialog(frame, "" + Hero.companions.get(0).getComName() + " blocks the monster's attack!",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);		
				}
			else
				{
				monsterDamage = monsterDamage - Hero.companions.get(0).getComArmor();
				JOptionPane.showMessageDialog(frame, "" + Hero.companions.get(0).getComName() + " takes " + monsterDamage + " from the monster!",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);	
				Hero.companions.get(0).setComHP(Hero.companions.get(0).getComHP() - monsterDamage);
				JOptionPane.showMessageDialog(frame, "" + Hero.companions.get(0).getComName() + " has " + Hero.companions.get(0).getComHP() + " health left.",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);	
				if(Hero.companions.get(0).getComHP() <= 0)
					{
					JOptionPane.showMessageDialog(frame, "" + Hero.companions.get(0).getComName() + " is dead!",
							"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
							JOptionPane.QUESTION_MESSAGE,
							icon);
					Hero.companions.get(0).setCompanionPresence(false);
					}
				}
			}	
		}

	public String getComName()
		{
			return comName;
		}

	public void setComName(String comName)
		{
			this.comName = comName;
		}

	public int getComMaxHP()
		{
			return comMaxHP;
		}

	public void setComMaxHP(int comMaxHP)
		{
			this.comMaxHP = comMaxHP;
		}

	public int getComHP()
		{
			return comHP;
		}

	public void setComHP(int comHP)
		{
			this.comHP = comHP;
		}

	public int getComDmg()
		{
			return comDmg;
		}

	public void setComDmg(int comDmg)
		{
			this.comDmg = comDmg;
		}

	public String getAttackType()
		{
			return attackType;
		}

	public void setAttackType(String attackType)
		{
			this.attackType = attackType;
		}

	public boolean isCompanionPresence()
		{
			return companionPresence;
		}

	public void setCompanionPresence(boolean companionPresence)
		{
			this.companionPresence = companionPresence;
		}
	
	public int getComArmor()
		{
			return comArmor;
		}

	public void setComArmor(int comArmor)
		{
			this.comArmor = comArmor;
		}
	}
