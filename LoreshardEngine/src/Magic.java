import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Magic
	{
	public static void castMagic(int hitPoints, int magicLev, int monsterNum)
		{
		JFrame frame = new JFrame();
		int magicChoice;
		if(Hero.heroes.get(0).getAdrenaline() >= 40)
			{
			Object[] magicType = {"Fire", "Water", "Earth","UBER CAST"};
			magicChoice = JOptionPane.showOptionDialog(frame, "What element would you like to cast?",
					"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null, magicType, magicType[1]);
			}
		else
			{
			Object[] magicType = {"Fire", "Water", "Earth"};
			magicChoice = JOptionPane.showOptionDialog(frame, "What element would you like to cast?",
					"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null, magicType, magicType[1]);
			}
		
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
				castUber(hitPoints, magicLev, monsterNum);
				break;
				}
			}
		}
	
	public static void castFireBall(int hitPoints, int magicLev, int monsterNum)
		{
		ImageIcon icon = new ImageIcon(("fireball.jpg"));
		int damage = (int) (Math.random() * (magicLev * 2)) + magicLev;
		JFrame frame = new JFrame();
		
		JOptionPane.showMessageDialog(frame, "You blast fire at the creature and do " + damage + " damage!",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		damage = checkForRandomExplosion(damage);
		if(Monster.magicRes == 0)
			{
			hitPoints = hitPoints - (damage / 2);
			JOptionPane.showMessageDialog(frame, "The monster is resistant to magic damage!",
					"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
					JOptionPane.QUESTION_MESSAGE,
					icon);
			}
		else if(Monster.magicRes == 1)
			{
			hitPoints = hitPoints - (damage * 2);	
			JOptionPane.showMessageDialog(frame, "The monster is weak to magic damage!",
					"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
					JOptionPane.QUESTION_MESSAGE,
					icon);
			}
		else
			{
			hitPoints = hitPoints - damage;	
			}
		
				JOptionPane.showMessageDialog(frame, "The monster has " + hitPoints + " HP left!",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE);
		Monster.monsters.get(monsterNum).setHitPoints(hitPoints);
		}
	
	public static void castHeal(int hitPoints, int magicLev)
		{
		ImageIcon icon = new ImageIcon(("heal.jpg"));
		int healValue = (int) (Math.random() * (magicLev * 5)) + magicLev;
		JFrame frame = new JFrame();
		
		Hero.heroes.get(0).setHeroHP(Hero.heroes.get(0).getHeroHP() + healValue);
		
		if(Hero.heroes.get(0).getHeroHP() > Hero.heroes.get(0).getMaxHeroHP())
			{
			Hero.heroes.get(0).setHeroHP(Hero.heroes.get(0).getMaxHeroHP());
			}
		
		JOptionPane.showMessageDialog(frame, "You heal yourself for " + healValue + " health!",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		}
	
	public static void castStoneSkin(int magicLev)
		{
		ImageIcon icon = new ImageIcon(("stone.jpg"));
		JFrame frame = new JFrame();
		
		JOptionPane.showMessageDialog(frame, "You turn your skin to stone! You get + 1 armor!",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		
		Hero.heroes.get(0).setNaturalArmor(Hero.heroes.get(0).getNaturalArmor() + 2);
		if(Hero.heroes.get(0).getNaturalArmor() >= Hero.heroes.get(0).getMaxNaturalArmor())
			{
			Hero.heroes.get(0).setNaturalArmor(Hero.heroes.get(0).getMaxNaturalArmor());	
			}
		}
	
	public static void castUber(int hitPoints, int magicLev, int monsterNum)
		{
		ImageIcon icon = new ImageIcon(("lightning.jpg"));
		int damage = (int) (Math.random() * (magicLev * 15)) + magicLev;
		JFrame frame = new JFrame();
		damage = damage * 2;
		JOptionPane.showMessageDialog(frame, "You blast lightning at the creature and do " + damage + " damage!",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		hitPoints = hitPoints - damage;
				JOptionPane.showMessageDialog(frame, "The monster has " + hitPoints + " HP left!",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE);
		Monster.monsters.get(monsterNum).setHitPoints(hitPoints);
		Hero.heroes.get(0).setAdrenaline(Hero.heroes.get(0).getAdrenaline() - 40);
		}
	
	public static int checkForRandomExplosion(int damage)
		{
		int chance = (int) (Math.random() * 100) + 1;
		ImageIcon icon = new ImageIcon(("crit.jpg"));
		JFrame frame = new JFrame();
				
		if(chance <= Hero.heroes.get(0).getMagicLuck())
			{
			JOptionPane.showMessageDialog(frame, "YOUR FIREBALL RANDOMLY EXLODES ON IMPACT, 5x DAMAGE!",
					"CRITICAL HIT",
					JOptionPane.QUESTION_MESSAGE,
					icon);
			damage = damage * 5;
			}
		return damage;
		}
	}
