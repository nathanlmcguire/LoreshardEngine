import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class TutorialAndIntro
	{
	public static void allTutorials()
		{
		ImageIcon icon = new ImageIcon(("tutorial.jpg"));
		JFrame frame = new JFrame();	
		int optionChosen = 0;
		boolean learning = true;
		
		while(learning)
			{
			Object[] option = {"Intro", "Melee Tutorial", "Magic Tutorial", "Alchemy Tutorial", "Skill Tutorial", "Stubs Tutorial", "Done"};
			optionChosen = JOptionPane.showOptionDialog(frame, "",
					"Intro/Tutorial",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					icon, option, option[0]);
			switch(optionChosen)
				{
				case 0:
					{
					playIntro();
					break;
					}
				case 1:
					{
					meleeTutorial();
					break;
					}
				case 2:
					{
					magicTutorial();
					break;
					}
				case 3:
					{
					alchemyTutorial();
					break;
					}
				case 4:
					{
					skillTutorial();
					break;
					}
				case 5:
					{
					stubsTutorial();
					break;
					}
				case 6:
					{
					learning = false;
					break;
					}
				}
			}
		
		}
	
	public static void playIntro()
		{
		ImageIcon icon = new ImageIcon(("story.jpg"));
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, "You were an orphan.",
				"STORY",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "You have lived all your life in a small orphanage in the middle of nowhere.",
				"STORY",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "After coming of age you get together what you can and head out.",
				"STORY",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "Ahead of you is the strange and perilous land of Yedrin.",
				"STORY",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "You could become a knight, a king, a nobleman, or a great wizard.",
				"STORY",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "Maybe you will find riches, powerful weapons, or ancient tomes.",
				"STORY",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "Much is unknown but this much is sure...",
				"STORY",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "You are a Wayfarer and you will find your own path.",
				"STORY",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		}
	
	public static void meleeTutorial()
		{
		
		}
	
	public static void magicTutorial()
		{
		
		}
	
	public static void alchemyTutorial()
		{
		
		}
	
	public static void skillTutorial()
		{
		
		}

	
	public static void stubsTutorial()
		{
		
		}
	}
