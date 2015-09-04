import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Game
	{
	public static void play()
		{
		JFrame frame = new JFrame();
		ImageIcon icon = new ImageIcon(("games.jpg"));
		ImageIcon icon2 = new ImageIcon(("steps.png"));
		
		JOptionPane.showMessageDialog(frame, "On your travels you come across a clearing where a camp has been set up.",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon2);
		JOptionPane.showMessageDialog(frame, "There is a man sitting outside a tent who sees you.",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon2);
		JOptionPane.showMessageDialog(frame, "He offeres to play you in a game of Stubs!",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		Object[] choose = {"Play Stubs", "Leave"};
		int choice = JOptionPane.showOptionDialog(frame, "What would you like to do?",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				icon, choose, choose[0]);
		
		switch(choice)
			{
			case 0:
				{
				JOptionPane.showMessageDialog(frame, "You agree to play Stubs with the man.",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);	
				playStubs();
				break;
				}
			case 1:
				{
				JOptionPane.showMessageDialog(frame, "You bid farewell to the man and continue on your way.",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon2);	
				break;
				}
			}
		
		
		}	
		
	public static void playStubs()
		{
		int playerPoints = 0, opponentPoints = 0, roundPoints = 0, dieOne = 0, dieTwo = 0; 
		boolean contRound = true, playerTurn = true;;
		JFrame frame = new JFrame();
		ImageIcon icon = new ImageIcon(("games.jpg"));
		
		Object[] chooseBet = {"Your Weapon", "Your Armor", "Your Potion"};
		int bet = JOptionPane.showOptionDialog(frame, "What would you like to bet?",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				icon, chooseBet, chooseBet[0]);
		
		while(playerPoints < 100 && opponentPoints < 100)
			{
			contRound = true;
				
			while(contRound)
				{
				if(playerTurn)
					{
					JOptionPane.showMessageDialog(frame, "YOUR TURN!",
							"" + Hero.heroes.get(0).getName() + "'s Points = " + playerPoints + " Opponent's Points = " + opponentPoints + "",
							JOptionPane.QUESTION_MESSAGE,
							icon);
					dieOne = (int) (Math.random() * 6) + 1;
					dieTwo = (int) (Math.random() * 6) + 1;
						
					JOptionPane.showMessageDialog(frame, "You rolled a " + dieOne + " and a " + dieTwo + "!",
							"" + Hero.heroes.get(0).getName() + "'s Points = " + playerPoints + " Opponent's Points = " + opponentPoints + "",
							JOptionPane.QUESTION_MESSAGE,
							icon);
					
					if(dieOne < 2 || dieTwo < 2)
						{
						roundPoints = 0;	
						JOptionPane.showMessageDialog(frame, "Round over, you got 0 points!",
								"" + Hero.heroes.get(0).getName() + "'s Points = " + playerPoints + " Opponent's Points = " + opponentPoints + "",
								JOptionPane.QUESTION_MESSAGE,
								icon);
						playerTurn = false;
						contRound = false;
						}
					else if(dieOne == dieTwo)
						{
						roundPoints += (dieOne * dieTwo) * 2;
						JOptionPane.showMessageDialog(frame, "You have " + roundPoints + " points so far this round!",
								"" + Hero.heroes.get(0).getName() + "'s Points = " + playerPoints + " Opponent's Points = " + opponentPoints + "",
								JOptionPane.QUESTION_MESSAGE,
								icon);
						
						Object[] chooseCont = {"Yes", "End Round and Keep Points"};
						int cont = JOptionPane.showOptionDialog(frame, "Would you like to roll again?",
								"" + Hero.heroes.get(0).getName() + "'s Points = " + playerPoints + " Opponent's Points = " + opponentPoints + "",
								JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE,
								icon, chooseCont, chooseCont[0]);
						if(cont == 1)
							{
							playerPoints += roundPoints;
							roundPoints = 0;
							playerTurn = false;
							contRound = false;
							}
						}
					else
						{
						roundPoints += (dieOne + dieTwo) * 2;	
						JOptionPane.showMessageDialog(frame, "You have " + roundPoints + " points so far this round!",
								"" + Hero.heroes.get(0).getName() + "'s Points = " + playerPoints + " Opponent's Points = " + opponentPoints + "",
								JOptionPane.QUESTION_MESSAGE,
								icon);
						
						Object[] chooseCont = {"Yes", "End Round and Keep Points"};
						int cont = JOptionPane.showOptionDialog(frame, "Would you like to roll again?",
								"" + Hero.heroes.get(0).getName() + "'s Points = " + playerPoints + " Opponent's Points = " + opponentPoints + "",
								JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE,
								icon, chooseCont, chooseCont[0]);
						if(cont == 1)
							{
							playerPoints += roundPoints;
							roundPoints = 0;
							playerTurn = false;
							contRound = false;
							}
						}		
					}
				else
					{
					JOptionPane.showMessageDialog(frame, "OPPONENT'S TURN!",
							"" + Hero.heroes.get(0).getName() + "'s Points = " + playerPoints + " Opponent's Points = " + opponentPoints + "",
							JOptionPane.QUESTION_MESSAGE,
							icon);
					dieOne = (int) (Math.random() * 6) + 1;
					dieTwo = (int) (Math.random() * 6) + 1;
						
					JOptionPane.showMessageDialog(frame, "He rolled a " + dieOne + " and a " + dieTwo + "!",
							"" + Hero.heroes.get(0).getName() + "'s Points = " + playerPoints + " Opponent's Points = " + opponentPoints + "",
							JOptionPane.QUESTION_MESSAGE,
							icon);
					
					if(dieOne < 2 || dieTwo < 2)
						{
						roundPoints = 0;	
						JOptionPane.showMessageDialog(frame, "Round over, he got 0 points!",
								"" + Hero.heroes.get(0).getName() + "'s Points = " + playerPoints + " Opponent's Points = " + opponentPoints + "",
								JOptionPane.QUESTION_MESSAGE,
								icon);
						playerTurn = true;
						contRound = false;
						}
					else if(dieOne == dieTwo)
						{
						roundPoints += (dieOne * dieTwo) * 2;
						JOptionPane.showMessageDialog(frame, "He has " + roundPoints + " points so far this round!",
								"" + Hero.heroes.get(0).getName() + "'s Points = " + playerPoints + " Opponent's Points = " + opponentPoints + "",
								JOptionPane.QUESTION_MESSAGE,
								icon);
						
						if(roundPoints > 20)
							{
							JOptionPane.showMessageDialog(frame, "He decides to end the round.",
									"" + Hero.heroes.get(0).getName() + "'s Points = " + playerPoints + " Opponent's Points = " + opponentPoints + "",
									JOptionPane.QUESTION_MESSAGE,
									icon);
							opponentPoints += roundPoints;
							roundPoints = 0;
							playerTurn = true;	
							contRound = false;
							}
						else
							{
							JOptionPane.showMessageDialog(frame, "He decides to continue the round.",
									"" + Hero.heroes.get(0).getName() + "'s Points = " + playerPoints + " Opponent's Points = " + opponentPoints + "",
									JOptionPane.QUESTION_MESSAGE,
									icon);		
							}
						}
					else
						{
						roundPoints += (dieOne + dieTwo) * 2;	
						JOptionPane.showMessageDialog(frame, "He has " + roundPoints + " points so far this round!",
								"" + Hero.heroes.get(0).getName() + "'s Points = " + playerPoints + " Opponent's Points = " + opponentPoints + "",
								JOptionPane.QUESTION_MESSAGE,
								icon);
						
						int opponentChoice = (int) (Math.random() * 2) + 1;
						if(opponentChoice == 2)
							{
							JOptionPane.showMessageDialog(frame, "He decides to end the round.",
									"" + Hero.heroes.get(0).getName() + "'s Points = " + playerPoints + " Opponent's Points = " + opponentPoints + "",
									JOptionPane.QUESTION_MESSAGE,
									icon);
							opponentPoints += roundPoints;
							roundPoints = 0;
							playerTurn = true;	
							contRound = false;
							}
						else
							{
							JOptionPane.showMessageDialog(frame, "He decides to continue the round.",
									"" + Hero.heroes.get(0).getName() + "'s Points = " + playerPoints + " Opponent's Points = " + opponentPoints + "",
									JOptionPane.QUESTION_MESSAGE,
									icon);	
							}
						}			
					}
				}
			}
		if(playerPoints > 99)
			{
			JOptionPane.showMessageDialog(frame, "You have won the game!",
					"" + Hero.heroes.get(0).getName() + "'s Points = " + playerPoints + " Opponent's Points = " + opponentPoints + "",
					JOptionPane.QUESTION_MESSAGE,
					icon);	
			Hero.openLoot();	
			Hero.openLoot();
			}
		else
			{
			JOptionPane.showMessageDialog(frame, "You have lost the game!",
					"" + Hero.heroes.get(0).getName() + "'s Points = " + playerPoints + " Opponent's Points = " + opponentPoints + "",
					JOptionPane.QUESTION_MESSAGE,
					icon);	
			if(bet == 0)
				{
				Hero.heroInventory.set(0, new Sword("Fists", 0, 2, true));
				}
			else if(bet == 1)
				{
				Hero.heroInventory.set(1, new LightArmor("Rags", 0, "Light", 0, true));	
				}
			else
				{
				if(Hero.heroInventory.get(3) instanceof Potion)
					{
					Potion potion = (Potion) Hero.heroInventory.get(3);
					potion.setFull(false);
					potion.setItemName("Empty Potion");
					}
				}
			}
		}
	
	}
