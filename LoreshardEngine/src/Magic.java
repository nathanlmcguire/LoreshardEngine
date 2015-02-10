import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Magic
	{
	public static void castMagic(int hitPoints, int magicLev, int monsterNum)
		{
		JFrame frame = new JFrame();
		
		Object[] magicType = {"Fire", "Water", "Earth", "Air"};
		int magicChoice = JOptionPane.showOptionDialog(frame, "What element would you like to cast?",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, magicType, magicType[1]);
		
		switch(magicChoice)
			{
			case 0:
				{
				castFireBall(hitPoints, magicLev, monsterNum);
				break;
				}
			case 1:
				{
				castHeal(hitPoints, magicLev);
				break;
				}
			case 2:
				{
				castStoneSkin(magicLev);
				
				break;
				}
			case 3:
				{
				//castTeleport(magicLev);
				//NEEDS WORK
				break;
				}
			}
		}
	
	public static void castFireBall(int hitPoints, int magicLev, int monsterNum)
		{
		ImageIcon icon = new ImageIcon(("fireball.jpg"));
		int damage = (int) (Math.random() * (magicLev * 5)) + magicLev;
		JFrame frame = new JFrame();
		
		JOptionPane.showMessageDialog(frame, "You blast fire at the creature and do " + damage + " damage!",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		hitPoints = hitPoints - damage;
				JOptionPane.showMessageDialog(frame, "The monster has " + hitPoints + " HP left!",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE);
		Monster.monsters.get(monsterNum).setHitPoints(hitPoints);
		}
	
	public static void castHeal(int hitPoints, int magicLev)
		{
		ImageIcon icon = new ImageIcon(("heal.jpg"));
		int healValue = (int) (Math.random() * (magicLev * 10)) + magicLev;
		JFrame frame = new JFrame();
		
		Hero.heroes.get(0).setHeroHP(Hero.heroes.get(0).getHeroHP() + healValue);
		
		if(Hero.heroes.get(0).getHeroHP() > Hero.heroes.get(0).getMaxHeroHP())
			{
			Hero.heroes.get(0).setHeroHP(Hero.heroes.get(0).getMaxHeroHP());
			}
		
		JOptionPane.showMessageDialog(frame, "You heal yourself for " + healValue + " health!",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		}
	
	public static void castStoneSkin(int magicLev)
		{
		ImageIcon icon = new ImageIcon(("stone.jpg"));
		int stoneValue = (int) (Math.random() * (magicLev / 2)) + 1;
		int oldAC;
		Armor armor;
		JFrame frame = new JFrame();
		if(Hero.heroInventory.get(1) instanceof Armor)
			{
			armor = (Armor) Hero.heroInventory.get(1);
			oldAC = armor.getArmorLevel();
			armor.setArmorLevel(oldAC + stoneValue);
			}
		
		JOptionPane.showMessageDialog(frame, "You turn your skin to stone! You get + " + stoneValue + " armor!",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		}
	
	public static void castTeleport(int magicLev)
		{
		JFrame frame = new JFrame();
		
		JOptionPane.showMessageDialog(frame, "You teleport past the monster!",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE);
		}
	}
