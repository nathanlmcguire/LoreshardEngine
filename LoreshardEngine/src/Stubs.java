import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Stubs
	{
	static int playerPoint;
	
	
	public static void play()
		{
		ImageIcon iconThree = new ImageIcon(("dice.png"));
		ImageIcon icon = new ImageIcon(("steps.png"));
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, "You are walking down the path and you see an old man.",
			"STUBS",
			JOptionPane.QUESTION_MESSAGE,
			icon);
		
		JOptionPane.showMessageDialog(frame, "Old Man: Would you like to play a game of Stubs with me?",
				"STUBS",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "Old Man: If you win I will give you a treasure, but if I win then I get your weapon!",
				"STUBS",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		
		Object[] chooseClassChoice = {"Yes", "No"};
		int choice = JOptionPane.showOptionDialog(frame, "Old Man: Would you like to play?",
				"STUBS",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				iconThree, chooseClassChoice, chooseClassChoice[0]);
		
		switch(choice)
			{
			case 0:
				{
				int totalDice = rollDice();
				switch (totalDice)
					{
					case 2:
					case 12:
						{
						lose();
						break;
						}
					case 7:
					case 11:
						{
						win();
						break;
						}
					default:
						{
						boolean check = true;
						playerPoint = point(totalDice);
						while(true)
							{
							totalDice = rollDice();
							if(totalDice == 7)
								{
								lose();
								}
							if(totalDice == playerPoint)
								{
								win();
								check = false;
								}
							else
								{
								JOptionPane.showMessageDialog(frame, "Old Man: You didn't get your point this time!",
										"STUBS",
										JOptionPane.QUESTION_MESSAGE,
										iconThree);
								}
							totalDice = rollDice();
							break;
							}
						}
					}
				
				}
			case 1:
				{
				JOptionPane.showMessageDialog(frame, "Old Man:  That's a shame, oh well, on your way.",
						"STUBS",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				break;
				}
			}
		}
	
	public static int rollDice()
		{
		ImageIcon iconThree = new ImageIcon(("dice.png"));
		JFrame frame = new JFrame();
		int diceRollOne;
		int diceRollTwo;
		int totalDice;
		Random randomNumber = new Random();
		diceRollOne = 1 + randomNumber.nextInt(6);
		diceRollTwo = 1 + randomNumber.nextInt(6);
		totalDice = diceRollOne + diceRollTwo;
		JOptionPane.showMessageDialog(frame, "You rolled the dice and got a: " + totalDice+ "!",
				"STUBS",
				JOptionPane.QUESTION_MESSAGE,
				iconThree);
		return totalDice;
		}
	
	public static void lose()
		{
		JFrame frame = new JFrame();
		ImageIcon iconThree = new ImageIcon(("dice.jpg"));
		JOptionPane.showMessageDialog(frame, "Old Man: Hahahah!  You lose!  This weapon will sell for a pretty penny!",
				"STUBS",
				JOptionPane.QUESTION_MESSAGE,
				iconThree);
		Hero.heroInventory.set(0, new Sword("Fists", 0, 1, true));
		Hero.showInventory(Hero.heroInventory.get(0).getItemName(), Hero.heroInventory.get(1).getItemName(), Hero.heroInventory.get(2).getItemName(), Hero.heroInventory.get(3).getItemName());
		}
	
	public static void win()
		{
		JFrame frame = new JFrame();
		ImageIcon iconThree = new ImageIcon(("dice.jpg"));
		JOptionPane.showMessageDialog(frame, "Old Man: Ah darn, you won.  Well here is your treasure, bye!",
				"STUBS",
				JOptionPane.QUESTION_MESSAGE,
				iconThree);
		Hero.openLoot();
		}
	
	public static int point(int totalDice)
		{
		JFrame frame = new JFrame();
		ImageIcon iconThree = new ImageIcon(("dice.jpg"));
		JOptionPane.showMessageDialog(frame, "Old Man: Well rolled.  Your point is: " + totalDice + ".",
				"STUBS",
				JOptionPane.QUESTION_MESSAGE,
				iconThree);
		return totalDice;
		}
	
	}
