import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Character
	{
	static SpecialItem item = (SpecialItem) Hero.heroInventory.get(5);
	
	public static void generateCharacter()
		{
		ImageIcon icon = new ImageIcon(("steps.png"));
		int ran = (int) (Math.random() * 7);
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, "While walking down the path you spot a hunched figure.",
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
				blacksmith();	
				break;
				}
			case 4:
				{
				mercenary();	
				break;
				}
			case 5:
				{
				vampire();
				break;
				}
			case 6:
				{
				alchemist();
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
		
		JOptionPane.showMessageDialog(frame, "He offers to help defend you on your adventures for a Bag of Gold.",
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
			Object[] choose = {"Hire", "Leave"};
			int choice = JOptionPane.showOptionDialog(frame, "You have " + item.getQuantity() + " Bag(s) of Gold.  What would you like to do?",
					"CHARACTER CREATION",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					icon, choose, choose[0]);
			
			switch(choice)
				{
				case 0:
					{
					Companion.generateMercCharacter();
					break;
					}
				case 1:
					{
					JOptionPane.showMessageDialog(frame, "You bid the mercenary farewell and continue on your way.",
							"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
							JOptionPane.QUESTION_MESSAGE,
							icon);
					break;
					}
				}
		}
		}

	public static void vampire()
		{
		JFrame frame = new JFrame();
		ImageIcon icon = new ImageIcon(("vampire.jpg"));
		ImageIcon icon2 = new ImageIcon(("vampireFangs.jpg"));
		JOptionPane.showMessageDialog(frame, "You cannot make out the identity of the person for he wears a hood!",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		
		JOptionPane.showMessageDialog(frame, "He offers you a Bag of Gold and 2 powerful items if you let him test something on you.",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		Object[] choose = {"Agree", "Leave"};
		int choice = JOptionPane.showOptionDialog(frame, "What would you like to do?",
				"CHARACTER CREATION",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				icon, choose, choose[0]);
		
		switch(choice)
			{
			case 0:
				{
				JOptionPane.showMessageDialog(frame, "You agree and suddenly the man leaps at you and sinks fangs into your throat!",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon2);
				JOptionPane.showMessageDialog(frame, "He is a vampire!  You will lose 10 max health, but you gain a Bag of Gold and 2 powerful items.",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon2);
				if(Hero.heroes.get(0).getMaxHeroHP() <= 10)
					{
					Hero.heroes.get(0).setMaxHeroHP(Hero.heroes.get(0).getMaxHeroHP() - 10);
					Hero.heroes.get(0).setHeroHP(Hero.heroes.get(0).getHeroHP() - 10);
					JOptionPane.showMessageDialog(frame, "Unfortunately the vampire took too much blood and you fall to the ground... dead.",
							"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
							JOptionPane.QUESTION_MESSAGE,
							icon2);	
					}
				else
					{
					JOptionPane.showMessageDialog(frame, "The vampire throws your reward to you and disappears.",
							"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
							JOptionPane.QUESTION_MESSAGE,
							icon);
					Hero.heroes.get(0).setHeroHP(Hero.heroes.get(0).getHeroHP() - 10);
					Hero.heroes.get(0).setMaxHeroHP(Hero.heroes.get(0).getMaxHeroHP() - 10);
					item.setQuantity(item.getQuantity() + 1);
					Hero.openLoot();
					Hero.openLoot();
					}
				
				break;
				}
			case 1:
				{
				JOptionPane.showMessageDialog(frame, "You bid the figure farewell and continue on your way.",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				break;
				}
			}
		}
	
	public static void alchemist()
		{
		JFrame frame = new JFrame();
		ImageIcon icon = new ImageIcon(("alchemist.jpg"));
		JOptionPane.showMessageDialog(frame, "It is a traveling alchemist.",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		
		JOptionPane.showMessageDialog(frame, "He offers you a Bag of Gold and a powerful item if you let him test his new concotion on you.",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		Object[] choose = {"Agree", "Leave"};
		int choice = JOptionPane.showOptionDialog(frame, "What would you like to do?",
				"CHARACTER CREATION",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				icon, choose, choose[0]);
		
		switch(choice)
			{
			case 0:
				{
				JOptionPane.showMessageDialog(frame, "You agree and drink the flask of strange liquid.",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				potionEffect();
				JOptionPane.showMessageDialog(frame, "The alchemist thanks you for your help and gives you what he promised.",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				item.setQuantity(item.getQuantity() + 1);
				Hero.openLoot();
				break;
				}
			case 1:
				{
				JOptionPane.showMessageDialog(frame, "You bid the alchemist farewell and continue on your way.",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				break;
				}
			}	
		}
	
	public static void potionEffect()
		{
		JFrame frame = new JFrame();
		ImageIcon icon = new ImageIcon(("potion2.jpg"));
		ImageIcon icon2 = new ImageIcon(("tree.jpg"));
		int ran = (int) (Math.random() * 19);
		switch(ran)
			{
			case 0:
			case 1:
				{
				JOptionPane.showMessageDialog(frame, "The potion strengthens your magic!",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				Hero.heroes.get(0).setMagicLevel(Hero.heroes.get(0).getMagicLevel() + 3);
				break;
				}
			case 2:
			case 3:
				{
				JOptionPane.showMessageDialog(frame, "The potion weakens your magic!",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				Hero.heroes.get(0).setMagicLevel(Hero.heroes.get(0).getMagicLevel() - 3);
				break;
				}
			case 4:
			case 5:
				{
				JOptionPane.showMessageDialog(frame, "The potion makes you stronger!",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				Hero.heroes.get(0).setStrengthLevel(Hero.heroes.get(0).getStrengthLevel() + 3);
				break;
				}
			case 6:
			case 7:
				{
				JOptionPane.showMessageDialog(frame, "The potion makes your muscles shrink!",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				Hero.heroes.get(0).setStrengthLevel(Hero.heroes.get(0).getStrengthLevel() - 3);
				break;
				}
			case 8:
			case 9:
				{
				JOptionPane.showMessageDialog(frame, "The potion makes you more agile!",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);	
				Hero.heroes.get(0).setAgilityLevel(Hero.heroes.get(0).getAgilityLevel() + 3);
				break;
				}
			case 10:
			case 11:
				{
				JOptionPane.showMessageDialog(frame, "The potion makes your agility decrease!",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);		
				Hero.heroes.get(0).setAgilityLevel(Hero.heroes.get(0).getAgilityLevel() - 3);
				break;
				}
			case 12:
			case 13:
				{
				JOptionPane.showMessageDialog(frame, "The potion increases your max health!",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);		
				Hero.heroes.get(0).setHeroHP(Hero.heroes.get(0).getHeroHP() + 5);
				Hero.heroes.get(0).setMaxHeroHP(Hero.heroes.get(0).getMaxHeroHP() + 5);
				break;
				}
			case 14:
			case 15:
				{
				JOptionPane.showMessageDialog(frame, "The potion decreases your max health!",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);		
				Hero.heroes.get(0).setHeroHP(Hero.heroes.get(0).getHeroHP() - 5);
				Hero.heroes.get(0).setMaxHeroHP(Hero.heroes.get(0).getMaxHeroHP() - 5);
				break;
				}
			case 16:
			case 17:
				{
				JOptionPane.showMessageDialog(frame, "The potion increases all of you skils majorly!",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);		
				Hero.heroes.get(0).setAgilityLevel(Hero.heroes.get(0).getAgilityLevel() + 3);
				Hero.heroes.get(0).setStrengthLevel(Hero.heroes.get(0).getStrengthLevel() + 3);
				Hero.heroes.get(0).setMagicLevel(Hero.heroes.get(0).getMagicLevel() + 3);
				break;
				}
			case 18:
				{
				JOptionPane.showMessageDialog(frame, "You feel your lembs thickening and your skin hardening!",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);	
				JOptionPane.showMessageDialog(frame, "Right before the eyes of the alchemist you change into a gargantuan tree!",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon2);	
				JOptionPane.showMessageDialog(frame, "Time suddenly speeds up. Years pass in seconds.",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon2);	
				JOptionPane.showMessageDialog(frame, "You become a sacred symbol for a tribe of druids.",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon2);	
				JOptionPane.showMessageDialog(frame, "You live on and on, witnessing the last moments of this world as the sun explodes.",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon2);	
				JOptionPane.showMessageDialog(frame, "YOU GOT THE ENDING: IMMORTAL TREE",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon2);	
				System.exit(0);
				break;
				}
			}
		}
	
	public static void blacksmith()
		{
			JFrame frame = new JFrame();
			ImageIcon icon = new ImageIcon(("blacksmith.jpg"));
			JOptionPane.showMessageDialog(frame, "It is a blacksmith!",
					"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
					JOptionPane.QUESTION_MESSAGE,
					icon);
			JOptionPane.showMessageDialog(frame, "He offers to take any Lore Shards you have and forge them into Sacred Items.",
					"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
					JOptionPane.QUESTION_MESSAGE,
					icon);
			if(Hero.heroes.get(0).getLoreShard() <= 0)
				{
				JOptionPane.showMessageDialog(frame, "Unfortunately you do not have any Lore Shards, so you continue on your way.",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				}
			else
				{
				Object[] choose = {"Craft", "Leave"};
				int choice = JOptionPane.showOptionDialog(frame, "You have " + Hero.heroes.get(0).getLoreShard() + " Lore Shard(s).  What would you like to do?",
						"CHARACTER CREATION",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						icon, choose, choose[0]);
				
				switch(choice)
					{
					case 0:
						{
						Object[] chooseOne = {"LoreBlade", "Ring of Stupendous Magic", "Dwarven Battle Armor", "Intant Kill Ward"};
						int choiceOne = JOptionPane.showOptionDialog(frame, "What would you like him to craft?",
								"CHARACTER CREATION",
								JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE,
								icon, chooseOne, chooseOne[0]);
						switch(choice)
							{
							case 0:
								{
								JOptionPane.showMessageDialog(frame, "The blacksmith crafts you a LoreBlade!",
										"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
										JOptionPane.QUESTION_MESSAGE,
										icon);	
								Hero.heroInventory.set(0, new Sword("LoreBlade", 100, 25, false));
								break;
								}
							case 1:
								{
								JOptionPane.showMessageDialog(frame, "The blacksmith crafts you a Ring of Stupendous Magic!",
										"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
										JOptionPane.QUESTION_MESSAGE,
										icon);	
								Hero.heroes.get(0).setMagicLevel(Hero.heroes.get(0).getMagicLevel() + 10);
								break;
								}
							case 2:
								{
								JOptionPane.showMessageDialog(frame, "The blacksmith crafts you a Dwarven Battle Armor.",
										"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
										JOptionPane.QUESTION_MESSAGE,
										icon);		
								Hero.heroInventory.set(1, new HeavyArmor("Dwarven Armor", 140, "Heavy", 25, false));
								break;
								}
							case 3:
								{
								JOptionPane.showMessageDialog(frame, "The blacksmith crafts you a Instant Kill Ward.",
										"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
										JOptionPane.QUESTION_MESSAGE,
										icon);		
								Hero.heroInventory.set(2, new Ward("Instant Kill Ward", 100, 30, 2));
								break;
								}
							}
						Hero.heroes.get(0).setLoreShard(Hero.heroes.get(0).getLoreShard() - 1);
						break;
						}
					case 1:
						{
						JOptionPane.showMessageDialog(frame, "You bid the blacksmith farewell and continue on your way.",
								"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
								JOptionPane.QUESTION_MESSAGE,
								icon);
						break;
						}
					}
				}
			}
	} 
