import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class SetUp
	{
	public static void createHero()
		{
		String chosenName = "";
		int chosenClass = 0;
		JFrame frame = new JFrame();

		chosenName = JOptionPane.showInputDialog(frame, "What do you want to be called?");
		
		Object[] chooseClassChoice = {"Fighter", "Mage", "Rogue"};
		chosenClass = JOptionPane.showOptionDialog(frame, "Choose your class.",
				"CHARACTER CREATION",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, chooseClassChoice, chooseClassChoice[0]);
		switch(chosenClass)
			{
			case 0:
				{
				Hero.heroes.add(new Hero(chosenName, 20, 0, 1, 0, 1, 2, 1, "Fighter"));
				
				break;
				}
			case 1:
				{
				Hero.heroes.add(new Hero(chosenName, 20, 0, 1, 2, 1, 0, 1, "Mage"));
				
				break;
				}
			case 2:
				{
				Hero.heroes.add(new Hero(chosenName, 20, 0, 1, 0, 2, 1, 1, "Rogue"));
				
				break;
				}
			}
		}
	}
