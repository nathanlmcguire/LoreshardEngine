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
				Hero.heroes.add(new Hero(chosenName, 20, 20, 0, 1, 0, 1, 2, "Fighter", 10));
				break;
				}
			case 1:
				{
				Hero.heroes.add(new Hero(chosenName, 20, 10, 0, 1, 5, 1, 0, "Mage", 10));
				break;
				}
			case 2:
				{
				Hero.heroes.add(new Hero(chosenName, 20, 15, 0, 1, 0, 2, 1, "Rogue", 10));
				break;
				}
			}
		Hero.heroInventory.add(new Sword("Fists", 0, 1, true));
		Hero.heroInventory.add(new LightArmor("Rags", 0, "Light", 0, true));
		Hero.heroInventory.add(new Ward("Broken Ward", 0, 1, 9));
		Hero.heroInventory.add(new Potion("Weak Healing Potion", 5, 0, true));
		Hero.alchemyBag.add(new Ingredient("Mudstock", 10, 0));
		Hero.alchemyBag.add(new Ingredient("Grigs", 10, -1));
		Hero.alchemyBag.add(new Ingredient("Pettleroot", 10, 1));
		
		}
	
	public static void generateSituation()
		{
		int situationNum = (int) (Math.random() * 9) + 1;
		
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
				{
				//Traps
				activateTrap();
				break;
				}
			case 10:
				{
				//Stubs
				Stubs.play();
				break;
				}
			case 11:
				{
				//DYNAMIC EVENT
				//generateEvent();
				break;
				}
			case 12:
				{
				//HERBS
				//gatherHerbs();
				break;
				}
			case 13:
				{
				//LOCKPICKING 
				//pickLock();
				break;
				}
			case 14:
				{
				//SIDE QUEST
				//generateSideQuest();
				break;
				}
			}
		}
	
	public static void activateTrap()
		{
		ImageIcon icon = new ImageIcon(("trap.jpg"));
		ImageIcon evade = new ImageIcon(("evade.png"));
		JFrame frame = new JFrame();
		
		JOptionPane.showMessageDialog(frame, "As you creep through the dungeon you unknowingly activate a tripwire!",
				"" + Hero.heroes.get(0).getName() + "'s HP = " +  Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon);	
		int chance = (int) (Math.random() * Hero.heroes.get(0).getAgilityLevel()) + 3;
		
		if(chance > Hero.heroes.get(0).getAgilityLevel())
			{
			JOptionPane.showMessageDialog(frame, "You are too slow to get out of the way and poison darts slice into your side!",
					"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
					JOptionPane.QUESTION_MESSAGE,
					icon);	
			int dmg = (int) (Math.random() * 3) + 3;
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
	}
