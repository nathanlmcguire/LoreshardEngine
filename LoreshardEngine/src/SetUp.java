import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class SetUp
	{
	public static void createHero()
		{
		ImageIcon icon = new ImageIcon(("class.jpg"));
		String chosenName = "";
		int chosenClass = 0;
		JFrame frame = new JFrame();
		chosenName = JOptionPane.showInputDialog(frame, "What do you want to be called?");
		Object[] chooseClassChoice = {"Fighter", "Mage", "Rogue"};
		chosenClass = JOptionPane.showOptionDialog(frame, "Choose your class.",
				"CHARACTER CREATION",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				icon, chooseClassChoice, chooseClassChoice[0]);
		switch(chosenClass)
			{
			case 0:
				{
				Hero.heroes.add(new Hero(chosenName, 20, 20, 30, 1, 0, 1, 2, "Fighter", 10, 5, false, 0, 0, 10, 1, 1, 0, 5));
				break;
				}
			case 1:
				{
				Hero.heroes.add(new Hero(chosenName, 22, 22, 30, 1, 5, 1, 0, "Mage", 10, 5, false, 0, 0, 10, 1, 1, 0, 5));
				break;
				}
			case 2:
				{
				Hero.heroes.add(new Hero(chosenName, 21, 21, 30, 1, 0, 5, 1, "Rogue", 10, 5, false, 0, 0, 10, 1, 1, 0, 5));
				break;
				}
			}
		Hero.heroInventory.add(new Sword("Fists", 0, 2, true));
		Hero.heroInventory.add(new LightArmor("Rags", 0, "Light", 0, true));
		Hero.heroInventory.add(new Ward("Broken Ward", 0, 100000, 9));
		Hero.heroInventory.add(new Potion("Weak Healing Potion", 5, 0, true));
		Hero.heroInventory.add(new SpecialItem("Keystone", 10, 0));
		Hero.heroInventory.add(new SpecialItem("Bag of Gold", 10, 1));
		Hero.heroInventory.add(new SpecialItem("Lockpicks", 10, 3));
		Hero.heroInventory.add(new SpecialItem("Bomb", 10, 0));
		Hero.companions.add(new Companion("name", 0, 0, 0, "attack", false, 0));
		Hero.alchemyBag.add(new Ingredient("Mudstock", 10, 0));
		Hero.alchemyBag.add(new Ingredient("Grigs", 10, -1));
		Hero.alchemyBag.add(new Ingredient("Pettleroot", 10, 1));
		
		}
	
	public static void generateSituation()
		{
		int situationNum = (int) (Math.random() * 17) + 1;
		
		switch(situationNum)
			{
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				{
				//MONSTER
				int monsterNum = Monster.randomize();
				while(Monster.monsters.get(monsterNum).getHitPoints() > 0)
					{
					Hero.chooseAttack(monsterNum);
					}
				Monster.monsters.remove(monsterNum);
				break;
				}
			case 6:
			case 7:
			case 8:
				{
				//CAULDRON
				Ingredient.brew();
				break;
				}
			case 9:
			case 10:
			case 11:
				{
				//NPC
				Character.generateCharacter();
				break;
				
				}
			case 12:
			case 13:
			case 14:
				{
				//DYNAMIC EVENT
				Event.generateEvent();
				break;
				}
			case 15:
				{
				//LOCKPICKING 
				pickLock();
				break;
				}
			case 16:
				{
				//Traps
				activateTrap();
				break;
				}
			case 17:
				{
				//PLAY GAME
				Game.play();
				break;
				}
			}
		}
	
	public static void chooseStartingWeapons()
		{
		ImageIcon icon = new ImageIcon(("starting.jpg"));
		JFrame frame = new JFrame();
		Object[] starterOptions = {"Keystones", "Small Fortune", "Ancient Sword", "Ring of Magic", "Simple Pendant"};
		int starterChoice = JOptionPane.showOptionDialog(frame, "What special item do you want to start ?",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				icon, starterOptions, starterOptions[1]);
		
		switch(starterChoice)
			{
			case 0:
				{
				JOptionPane.showMessageDialog(frame, "You have selected the Keystones!  These items will open locks with forgotten magic, but the stone will be used up.",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				SpecialItem item = (SpecialItem) Hero.heroInventory.get(4);
				item.setQuantity(item.getQuantity() + 2);
				break;
				}
			case 1:
				{
				JOptionPane.showMessageDialog(frame, "You have selected the Small Fortune!  You can use this to buy items or hire mercenaries.",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				SpecialItem item = (SpecialItem) Hero.heroInventory.get(5);
				item.setQuantity(item.getQuantity() + 3);	
				break;
				}
			case 2:
				{
				JOptionPane.showMessageDialog(frame, "You have selected the Ancient Sword!  This means that you have a strong starting weapon for this dungeon.",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				Weapon oldWeapon = (Weapon) Hero.heroInventory.get(0);
				int oldDamage = oldWeapon.getDamage();
				
				Weapon newWeapon = (Weapon) Item.items.get(1);
				int newDamage = newWeapon.getDamage();
				if(newDamage > oldDamage)
					{
					Hero.heroInventory.set(0, newWeapon);
					}
				break;	
				}
			case 3:
				{
				int magicLevel = Hero.heroes.get(0).getMagicLevel();
				magicLevel = magicLevel + 1;
				JOptionPane.showMessageDialog(frame, "You have selected the Magic Ring!  Now you have more powerful magic.",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				Hero.heroes.get(0).setMagicLevel(magicLevel);	
				break;	
				}
			case 4:
				{
				JOptionPane.showMessageDialog(frame, "You have selected the Simple Pendant!  This simple amulet reminds you of home, but has no real use.",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);	
				break;
				}
			}
		}
	
	public static void activateTrap()
		{
		ImageIcon icon = new ImageIcon(("trap.jpg"));
		ImageIcon evade = new ImageIcon(("evade.png"));
		ImageIcon loot = new ImageIcon(("loot.jpg"));
		JFrame frame = new JFrame();
		
		JOptionPane.showMessageDialog(frame, "As you walk along the path you unknowingly activate a tripwire rigged between two trees!",
				"" + Hero.heroes.get(0).getName() + "'s HP = " +  Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon);	
		int chance = (int) (Math.random() * 10);
		
		if(chance > Hero.heroes.get(0).getAgilityLevel())
			{
			JOptionPane.showMessageDialog(frame, "You are too slow to get out of the way and poison darts slice into your side!",
					"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
					JOptionPane.QUESTION_MESSAGE,
					icon);	
			int dmg = (int) (Math.random() * 10) + 3;
			Hero.heroes.get(0).setMaxHeroHP(Hero.heroes.get(0).getMaxHeroHP() - dmg);
			Hero.heroes.get(0).setHeroHP(Hero.heroes.get(0).getMaxHeroHP());
			
			JOptionPane.showMessageDialog(frame, "Your max health is decreased by " + dmg + "!",
					"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
					JOptionPane.QUESTION_MESSAGE,
					icon);	
			}
		else
			{
			JOptionPane.showMessageDialog(frame, "Luckily you dodge away, unscathed.",
					"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
					JOptionPane.QUESTION_MESSAGE,
					evade);	
			}
		}
	
	public static void pickLock()
		{
		ImageIcon icon = new ImageIcon(("trap.jpg"));
		ImageIcon evade = new ImageIcon(("evade.png"));
		ImageIcon loot = new ImageIcon(("loot.jpg"));
		JFrame frame = new JFrame();
		boolean stay = true;
		SpecialItem item1 = (SpecialItem) Hero.heroInventory.get(4);
		SpecialItem item2 = (SpecialItem) Hero.heroInventory.get(6);
		
		JOptionPane.showMessageDialog(frame, "As you creep through the dungeon you find a battered old treasure chest.",
				"" + Hero.heroes.get(0).getName() + "'s HP = " +  Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				loot);	
		JOptionPane.showMessageDialog(frame, "You can use a Keystone to unlock it, or try your hand at lockpicking.  But if you fail at lockpicking, you might activate a trap.",
				"" + Hero.heroes.get(0).getName() + "'s HP = " +  Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				loot);	
		
		while(stay)
			{
			Object[] actions = {"Leave", "Keystone(" + item1.getQuantity() + ")", "Lockpick(" + item2.getQuantity() + ")"};
			int chosenAction = JOptionPane.showOptionDialog(frame, "What do you want to use?",
					"CHARACTER CREATION",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					loot, actions, actions[0]);
			
			
			switch(chosenAction)
				{
				case 0:
					{
					JOptionPane.showMessageDialog(frame, "You leave the chest be and continue through the dungeon.",
							"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
							JOptionPane.QUESTION_MESSAGE,
							loot);	
					stay = false;
					break;
					}
				case 1:
					{
					SpecialItem item = (SpecialItem) Hero.heroInventory.get(4);
					if(item.getQuantity() > 0)
						{
						JOptionPane.showMessageDialog(frame, "You press your Keystone to the chest and it disolves into the lock, opening the chest!",
								"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
								JOptionPane.QUESTION_MESSAGE,
								loot);
						item.setQuantity(item.getQuantity() - 1);
						Hero.openLoot();
						stay = false;
						}
					else
						{
						JOptionPane.showMessageDialog(frame, "You have no Keystones to use.",
								"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
								JOptionPane.QUESTION_MESSAGE,
								loot);
						}
					break;
					}
				case 2:
					{
					SpecialItem item = (SpecialItem) Hero.heroInventory.get(6);
					if(item.getQuantity() > 0)
						{
						int chance = (int) (Math.random() * 10);
						if(chance > Hero.heroes.get(0).getAgilityLevel())
							{
							JOptionPane.showMessageDialog(frame, "You fail to pick the lock.",
									"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
									JOptionPane.QUESTION_MESSAGE,
									loot);	
							int check = (int) (Math.random() * 2);
							if(check == 0)
								{
								JOptionPane.showMessageDialog(frame, "Luckily no trap is activated.",
										"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
										JOptionPane.QUESTION_MESSAGE,
										loot);
								stay = false;
								}
							else
								{
								int dmg = (int) (Math.random() * 3) + 3;
								Hero.heroes.get(0).setMaxHeroHP(Hero.heroes.get(0).getMaxHeroHP() - dmg);
								Hero.heroes.get(0).setHeroHP(Hero.heroes.get(0).getMaxHeroHP());
								
								JOptionPane.showMessageDialog(frame, "Arrows fly out from holes the wall!",
										"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
										JOptionPane.QUESTION_MESSAGE,
										icon);
								
								JOptionPane.showMessageDialog(frame, "Your max health is decreased by " + dmg + "!",
										"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
										JOptionPane.QUESTION_MESSAGE,
										icon);	
								}
				
							}	
						else
							{
							JOptionPane.showMessageDialog(frame, "You manage to pick the lock and you find a piece of loot inside!",
									"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
									JOptionPane.QUESTION_MESSAGE,
									loot);	
							Hero.openLoot();
							stay = false;
							}
						item.setQuantity(item.getQuantity() - 1);
						}
					else
						{
						JOptionPane.showMessageDialog(frame, "You have no lockpicks to use.",
								"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
								JOptionPane.QUESTION_MESSAGE,
								loot);
						}
					
					break;
					}
				
				}
			}
		
		}
	
	public static void offerTutorial()
		{
		ImageIcon icon = new ImageIcon(("tutorial.jpg"));
		JFrame frame = new JFrame();
		int tutorialOptionChosen = 0;
		Object[] tutorialOption = {"Yes", "No"};
		tutorialOptionChosen = JOptionPane.showOptionDialog(frame, "Do you need the Intro/Tutorial?",
				"Intro/Tutorial",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				icon, tutorialOption, tutorialOption[0]);
		switch(tutorialOptionChosen)
			{
			case 0:
				{
				TutorialAndIntro.allTutorials();
				break;	
				}
			case 1:
				{
				break;
				}	
			}
		}
	}
