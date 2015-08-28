import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Potion extends Item
	{
	private int potionID;
	private boolean full;
	static ArrayList <Potion> potions = new ArrayList<Potion>();
	
	public Potion(String in, int v, int pid, boolean f)
		{
		setItemName(in);
		setValue(v);
		potionID = pid;
		full = f;
		}
	
	public static void drink(int monsterNum)
		{
		ImageIcon icon = new ImageIcon(("potion.jpg"));
		int potionID = 0;
		JFrame frame = new JFrame();
		
		if(Hero.heroInventory.get(3) instanceof Potion)
			{
			Potion potion = (Potion) Hero.heroInventory.get(3);
			potionID = potion.getPotionID();
			}
		//Hero.heroes.get(0).setWardPower(Hero.heroes.get(0).getWardPower() - wardCost);
		switch(potionID)
			{
			case 0:
				{
				JOptionPane.showMessageDialog(frame, "Your health has been healed for 15 hit points!",
						"POTION",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				Hero.heroes.get(0).setHeroHP(Hero.heroes.get(0).getHeroHP() + 15);
				
				if(Hero.heroes.get(0).getHeroHP() > Hero.heroes.get(0).getMaxHeroHP())
					{
					Hero.heroes.get(0).setHeroHP(Hero.heroes.get(0).getMaxHeroHP());
					}
				break;
				}
			case 1:
				{
				int healValue = (int) (Math.random() * 15) + 16;
				JOptionPane.showMessageDialog(frame, "Your health has been healed for " + healValue + " hit points!",
						"POTION",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				Hero.heroes.get(0).setHeroHP(Hero.heroes.get(0).getHeroHP() + healValue);
				
				if(Hero.heroes.get(0).getHeroHP() > Hero.heroes.get(0).getMaxHeroHP())
					{
					Hero.heroes.get(0).setHeroHP(Hero.heroes.get(0).getMaxHeroHP());
					}
				break;
				}
			case 2:
				{
				JOptionPane.showMessageDialog(frame, "You feel adrenaline surge throughout your body!",
						"POTION",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				Hero.heroes.get(0).setAdrenaline(Hero.heroes.get(0).getAdrenaline() + 40);
				break;
				}
			case 3:
				{
				JOptionPane.showMessageDialog(frame, "You feel power course through your muscles.",
						"POTION",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				Hero.heroes.get(0).setStrengthLevel(Hero.heroes.get(0).getStrengthLevel() + 1);
				break;
				}
			case 4:
				{
				JOptionPane.showMessageDialog(frame, "Your senses are heightened and you feel more agile!",
						"POTION",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				Hero.heroes.get(0).setAgilityLevel(Hero.heroes.get(0).getAgilityLevel() + 1);
				break;
				}
			case 5:
				{
				JOptionPane.showMessageDialog(frame, "You throw a potion of weak poison at your opponent! It does 7 damage!",
						"POTION",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				Monster.monsters.get(monsterNum).setHitPoints(Monster.monsters.get(monsterNum).getHitPoints() - 6);
				break;
				}
			case 6:
				{
				JOptionPane.showMessageDialog(frame, "You throw a potion of strong poison at your opponent! It does 15 damage!",
						"POTION",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				Monster.monsters.get(monsterNum).setHitPoints(Monster.monsters.get(monsterNum).getHitPoints() - 15);
				break;
				}
			case 7:
				{		
				JOptionPane.showMessageDialog(frame, "The passage of time slows and you feel cetain that your next attack will strike its target.",
						"POTION",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				Hero.heroes.get(0).setAccuracyEffect(true);
				break;
				}
			case 8:
				{
				int healValue = (int) (Math.random() * 50) + 25;
				JOptionPane.showMessageDialog(frame, "Magic explodes through your veins!",
						"POTION",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				Hero.heroes.get(0).setMagicLevel(Hero.heroes.get(0).getMagicLevel() + 1);
				break;
				}
			case 9:
				{
				JOptionPane.showMessageDialog(frame, "You suddenly feel a strange sensation!  There is an unexplainable feeling that you will now hit more critical strikes!",
						"POTION",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				Hero.heroes.get(0).setLuck(Hero.heroes.get(0).getLuck() + 2);
				break;
				}
			case 10:
				{
				JOptionPane.showMessageDialog(frame, "You feel adrenaline surge throughout your body!",
						"POTION",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				Hero.heroes.get(0).setWardPower(Hero.heroes.get(0).getWardPower() + 40);
				}
			case 11:
				{	
				JOptionPane.showMessageDialog(frame, "The potion makes your skin hard as stone!",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);	
				Hero.heroes.get(0).setNaturalArmor(Hero.heroes.get(0).getNaturalArmor() + 2);
				if(Hero.heroes.get(0).getNaturalArmor() >= 10)
					{
					Hero.heroes.get(0).setNaturalArmor(5);	
					}
				break;
				}
			case 12:
				{
				int healValue = (int) (Math.random() * 50) + 25;
				JOptionPane.showMessageDialog(frame, "Your health has been healed for " + healValue + " hit points!",
						"POTION",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				Hero.heroes.get(0).setHeroHP(Hero.heroes.get(0).getHeroHP() + healValue);
				
				if(Hero.heroes.get(0).getHeroHP() > Hero.heroes.get(0).getMaxHeroHP())
					{
					Hero.heroes.get(0).setHeroHP(Hero.heroes.get(0).getMaxHeroHP());
					}	
				break;
				}
			case 13:
				{
				int healValue = (int) (Math.random() * 10) + 5;
				JOptionPane.showMessageDialog(frame, "Your max health has been increased by " + healValue + " hit points!",
						"POTION",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				Hero.heroes.get(0).setHeroHP(Hero.heroes.get(0).getHeroHP() + healValue);
				Hero.heroes.get(0).setMaxHeroHP(Hero.heroes.get(0).getMaxHeroHP() + healValue);
				break;	
				}
			default:
				{
				JOptionPane.showMessageDialog(frame, "Nothing happens!",
						"POTION",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				}
				
			}
		if(Hero.heroInventory.get(3) instanceof Potion)
			{
			Potion potion = (Potion) Hero.heroInventory.get(3);
			potion.setFull(false);
			potion.setItemName("Empty Potion");
			}
		
		}

	public int getPotionID()
		{
		return potionID;
		}

	public void setPotionID(int potionID)
		{
		this.potionID = potionID;
		}

	public boolean isFull()
		{
		return full;
		}

	public void setFull(boolean full)
		{
		this.full = full;
		}
	
	
	
	}
