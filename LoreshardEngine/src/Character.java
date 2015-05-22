import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Character
	{
	static SpecialItem item = (SpecialItem) Hero.heroInventory.get(5);
	
	public static void generateCharacter()
		{
		ImageIcon icon = new ImageIcon(("steps.png"));
		int ran = (int) (Math.random() * 3);
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, "While walking down the dark corridors of the dungeon you spot a hunched figure.",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		switch(ran)
			{
			case 0:
				{
				trainer();
				break;
				}
			case 1:
				{
				merchant();	
				break;
				}
			case 2:
				{
				peddler();	
				break;
				}
			case 3:
				{
				riddler();	
				break;
				}
			case 4:
				{
				mercenary();	
				break;
				}
			}
		}
	
	public static void trainer()
		{
		JFrame frame = new JFrame();
		ImageIcon icon = new ImageIcon(("trainer.jpg"));
		JOptionPane.showMessageDialog(frame, "It is a trainer!",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "He offers to train you in Strength, Agility, or Magic for a Bag of Gold.",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		if(item.getQuantity() <= 0)
			{
			JOptionPane.showMessageDialog(frame, "Unfortunately you do not have any Bags of Gold, so you continue on your way.",
					"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
					JOptionPane.QUESTION_MESSAGE,
					icon);
			}
		else
			{
			Object[] choose = {"Train", "Leave"};
			int choice = JOptionPane.showOptionDialog(frame, "You have " + item.getQuantity() + " Bag(s) of Gold.  What would you like to do?",
					"CHARACTER CREATION",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					icon, choose, choose[0]);
			
			switch(choice)
				{
				case 0:
					{
					Hero.levelUp(Hero.heroes.get(0).getMaxHeroHP(), Hero.heroes.get(0).getAdrenaline(), Hero.heroes.get(0).getOverAllLevel(), Hero.heroes.get(0).getMagicLevel(), Hero.heroes.get(0).getAgilityLevel(), Hero.heroes.get(0).getStrengthLevel());
					item.setQuantity(item.getQuantity() - 1);
					break;
					}
				case 1:
					{
					JOptionPane.showMessageDialog(frame, "You bid the trainer farewell and continue on your way.",
							"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
							JOptionPane.QUESTION_MESSAGE,
							icon);
					break;
					}
				}
			}
		}
	
	public static void peddler()
		{
		JFrame frame = new JFrame();
		ImageIcon icon = new ImageIcon(("npc.jpg"));
		ImageIcon ped = new ImageIcon(("peddler.jpg"));
		int ran = (int) (Math.random() * 3);
		Item tradeItem = (Item) Hero.heroInventory.get(ran);
		
		JOptionPane.showMessageDialog(frame, "It is a peddler!",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				ped);
		
		JOptionPane.showMessageDialog(frame, "He wants to trade a mystery item for your " + tradeItem.getItemName() + ".",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				ped);
		
		Object[] choose = {"Accept", "Decline"};
		int choice = JOptionPane.showOptionDialog(frame, "Do you accept his trade offer?",
				"CHARACTER CREATION",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				ped, choose, choose[0]);
		
		switch(choice)
			{
			case 0:
				{
				JOptionPane.showMessageDialog(frame, "You give the peddler your " + tradeItem.getItemName() + ".",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						ped);
				if(ran == 0)
					{
					Hero.heroInventory.set(0, (new Sword("Fists", 0, 1, true)));
					}
				else if(ran == 1)
					{
					Hero.heroInventory.set(1, (new LightArmor("Rags", 0, "Light", 0, true)));
					}
				else
					{
					Hero.heroInventory.set(2, (new Ward("Broken Ward", 0, 100000, 9)));
					}
				Hero.openLoot();
				break;
				}
			case 1:
				{
				JOptionPane.showMessageDialog(frame, "You bid the peddler farewell and continue on your way.",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						ped);
				break;
				}
			}
		}
	
	public static void merchant()
		{
		JFrame frame = new JFrame();
		ImageIcon icon = new ImageIcon(("npc.jpg"));
		ImageIcon merc = new ImageIcon(("merchant.jpg"));
		JOptionPane.showMessageDialog(frame, "It is a merchant!",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				merc);
		JOptionPane.showMessageDialog(frame, "He offers you a mystery item for a bag of gold!",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				merc);
		
		if(item.getQuantity() <= 0)
			{
			JOptionPane.showMessageDialog(frame, "Unfortunately you do not have any Bags of Gold, so you continue on your way.",
					"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
					JOptionPane.QUESTION_MESSAGE,
					merc);
			}
		else
			{
			Object[] choose = {"Buy", "Leave"};
			int choice = JOptionPane.showOptionDialog(frame, "You have " + item.getQuantity() + " Bag(s) of Gold.  What would you like to do?",
					"CHARACTER CREATION",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					merc, choose, choose[0]);
			
			switch(choice)
				{
				case 0:
					{
					Hero.openLoot();
					item.setQuantity(item.getQuantity() - 1);
					break;
					}
				case 1:
					{
					JOptionPane.showMessageDialog(frame, "You bid the merchant farewell and continue on your way.",
							"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
							JOptionPane.QUESTION_MESSAGE,
							merc);
					break;
					}
				}
			}
		}
	
	public static void riddler()
		{
		JFrame frame = new JFrame();
		ImageIcon icon = new ImageIcon(("npc.jpg"));
		JOptionPane.showMessageDialog(frame, "It is an old man.",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		}
	
	public static void mercenary()
		{
		JFrame frame = new JFrame();
		ImageIcon icon = new ImageIcon(("mercenary.jpg"));
		JOptionPane.showMessageDialog(frame, "It is a mercenary!",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		}
	

	}
