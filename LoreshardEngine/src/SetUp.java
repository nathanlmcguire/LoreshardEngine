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
		
		Object[] chooseClassChoice = {"Fighter", "Mage", "Rogue", "Orator"};
		chosenClass = JOptionPane.showOptionDialog(frame, "Choose your class.",
				"CHARACTER CREATION",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, chooseClassChoice, chooseClassChoice[0]);
		}
	}
