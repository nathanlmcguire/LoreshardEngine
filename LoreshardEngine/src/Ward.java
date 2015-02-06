import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Ward extends Item
	{
	private int wardPowerNeeded;
	private int wardIdentity;
	
	public Ward(String in, int v, int wpn, int id)
		{
		setItemName(in);
		setValue(v);
		wardPowerNeeded = wpn;
		wardIdentity = id;
		}
	
	public static void useWard(int monsterNum)
		{
		ImageIcon icon = new ImageIcon(("lightning.jpg"));
		ImageIcon iconTwo = new ImageIcon(("search.jpg"));
		ImageIcon iconThree = new ImageIcon(("heal.jpg"));
		ImageIcon iconFour = new ImageIcon(("arrow.jpg"));
		int wardID = 9;
		int wardCost = 0;
		JFrame frame = new JFrame();
		
		if(Hero.heroInventory.get(2) instanceof Ward)
			{
			Ward ward = (Ward) Hero.heroInventory.get(2);
			wardID = ward.getWardIdentity();
			wardCost = ward.getWardPowerNeeded();
			}
		Hero.heroes.get(0).setWardPower(Hero.heroes.get(0).getWardPower() - wardCost);
		switch(wardID)
			{
			case 1:
				{
				JOptionPane.showMessageDialog(frame, "Nothing happens.",
						"WARD",
						JOptionPane.QUESTION_MESSAGE);
				break;
				}
			case 2:
				{
				JOptionPane.showMessageDialog(frame, "Lightning explodes from your hands and you incinerate the monster!",
						"WARD",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				Monster.monsters.get(monsterNum).setHitPoints(0);
				break;
				}
			case 3:
				{
				JOptionPane.showMessageDialog(frame, "Nothing happens.",
						"WARD",
						JOptionPane.QUESTION_MESSAGE);
				
				break;
				}
			case 4:
				{
				JOptionPane.showMessageDialog(frame, "Nothing happens.",
						"WARD",
						JOptionPane.QUESTION_MESSAGE);
				break;
				}
			case 5:
				{
				JOptionPane.showMessageDialog(frame, "A piece of loot appears before you!",
						"WARD",
						JOptionPane.QUESTION_MESSAGE,
						iconTwo);
				Hero.openLoot();
				break;
				}
			case 6:
				{
				Hero.heroes.get(0).setHeroHP(Hero.heroes.get(0).getMaxHeroHP());
				JOptionPane.showMessageDialog(frame, "You are healed completely!",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						iconThree);
				break;
				}
			case 7:
				{
				JOptionPane.showMessageDialog(frame, "Nothing happens.",
						"WARD",
						JOptionPane.QUESTION_MESSAGE);
				break;
				}
			case 8:
				{
				JOptionPane.showMessageDialog(frame, "You feel the experience of your ancestors flow through you.",
						"WARD",
						JOptionPane.QUESTION_MESSAGE,
						iconFour);
				Hero.levelUp(Hero.heroes.get(0).getMaxHeroHP(), Hero.heroes.get(0).getAdrenaline(), Hero.heroes.get(0).getOverAllLevel(), Hero.heroes.get(0).getMagicLevel(), Hero.heroes.get(0).getAgilityLevel(), Hero.heroes.get(0).getStrengthLevel(), Hero.heroes.get(0).getSpeechLevel());
				break;
				}
			case 9:
				{
				JOptionPane.showMessageDialog(frame, "Nothing happens.",
						"WARD",
						JOptionPane.QUESTION_MESSAGE);
				break;
				}
			}
		}
	
	public int getWardPowerNeeded()
		{
		return wardPowerNeeded;
		}

	public void setWardPowerNeeded(int wardPowerNeeded)
		{
		this.wardPowerNeeded = wardPowerNeeded;
		}

	public int getWardIdentity()
		{
		return wardIdentity;
		}

	public void setWardIdentity(int wardIdentity)
		{
		this.wardIdentity = wardIdentity;
		}
	
	
	}
