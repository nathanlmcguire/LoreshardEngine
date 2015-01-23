import java.util.ArrayList; 

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Hero extends Creature
	{
	private int adrenaline;
	private int overAllLevel;
	private int magicLevel;
	private int agilityLevel;
	private int strengthLevel;
	private int speechLevel;
	private int luckLevel;
	private String characterClass;
	
	private JFrame frame = new JFrame();
	
	static ArrayList <Hero> inventory = new ArrayList<Hero>();
	
	
	public Hero(String n, int h, int ad, int o, int m, int ag, int st, int sp, int l, String c)
		{
		setName(n);
		setHitPoints(h);
		adrenaline = ad;
		overAllLevel = o;
		magicLevel = m;
		agilityLevel = ag;
		strengthLevel = st;
		speechLevel = sp;
		luckLevel = l;
		characterClass = c;
		}
	
	
	public void chooseAttack()
		{
		int CombatChoice;
		Object[] attackType = {"Melee", "Magic", "Potion", "Scroll"};
		CombatChoice = JOptionPane.showOptionDialog(frame, "What would you like to do?",
				"COMBAT",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, attackType, attackType[1]);
		switch(CombatChoice)
			{
			case 1:
				{
				attack();
				break;
				}
			case 2:
				{
				break;
				}
			case 3:
				{
				break;
				}
			case 4:
				{
				break;
				}
			}
		}
	
	@Override
	public void attack()
		{
		
		}
	
	@Override
	public void defend()
		{
		//nothing yet
		}
	
	public void loot()
		{
		//randomly adds a piece of loot to the inventory
		}
	
	public void levelUp()
		{
		//level up and choose your skills
		}
	//also add:
	//buy/sell method
	//potion craft method
	//enhance attack method
	
	}
