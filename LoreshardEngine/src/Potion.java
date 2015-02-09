import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Potion extends Item
	{
	private int potionID;
	private boolean full;
	
	public Potion(String in, int v, int pid, boolean f)
		{
		setItemName(in);
		setValue(v);
		potionID = pid;
		full = f;
		}
	
	public static void drink()
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
				int healValue = (int) (Math.random() * 15) + 10;
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
				JOptionPane.showMessageDialog(frame, "Your health has been healed for 5 hit points!",
						"POTION",
						JOptionPane.QUESTION_MESSAGE,
						icon);
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
				JOptionPane.showMessageDialog(frame, "Your health has been healed for 5 hit points!",
						"POTION",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				break;
				}
			case 5:
				{
				JOptionPane.showMessageDialog(frame, "Your health has been healed for 5 hit points!",
						"POTION",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				break;
				}
			case 6:
				{
				JOptionPane.showMessageDialog(frame, "Magic explodes through your veins!",
						"POTION",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				Hero.heroes.get(0).setMagicLevel(Hero.heroes.get(0).getMagicLevel() + 1);
				break;
				}
			case 7:
				{		
				int healValue = (int) (Math.random() * 10) + 2;
				JOptionPane.showMessageDialog(frame, "You feel the Ward on your arm glow with power.",
						"POTION",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				Hero.heroes.get(0).setWardPower(Hero.heroes.get(0).getWardPower() + healValue);
				break;
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
