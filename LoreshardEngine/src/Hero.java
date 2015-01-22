import java.util.ArrayList; 

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Hero extends Creature
	{
	protected int adrenaline;
	protected int overAllLevel;
	protected int magicLevel;
	protected int agilityLevel;
	protected int strengthLevel;
	protected int speechLevel;
	protected int luckLevel;
	protected String characterClass;
	protected JFrame frame = new JFrame();
	ArrayList <Hero> inventory = new ArrayList<Hero>();
	
	
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
		Object[] attackType = {"Square", "Circle", "Triangle"};
		attackChoice = JOptionPane.showOptionDialog(frame, "How would you like to attack?",
				"Shape Choice",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, attackType, attackType[1]);
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
