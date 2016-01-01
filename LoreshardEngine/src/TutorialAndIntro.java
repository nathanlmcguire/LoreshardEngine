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
		ImageIcon icon = new ImageIcon(("meleetut.jpg"));
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, "The primary tool for any Wayfarer in Yedrin is his/her weapon.",
				"MELEE TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "Melee combat does more damage than magic, but it is harder to hit the enemy.",
				"MELEE TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "When you strike at the enemy you can attack high, medium, low, or do an UBER STRIKE.",
				"MELEE TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "A high attack does a lot of damage but has a low chance to hit.",
				"MELEE TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "A medium attack does normal damage and has a normal chance to hit.",
				"MELEE TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "A low attack does low damage and has a very high chance of hitting.",
				"MELEE TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "Every turn in combat you gain adrenaline.  When you get enough adrenaline you can UBER STRIKE.",
				"MELEE TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "An UBER STRIKE does a huge amount of damage and hits 100% of the time.  But it will deplete your adrenaline.",
				"MELEE TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "After you attack the enemy will attack you in a random area(high, lmedium, low).",
				"MELEE TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "Choose an area to block or dodge out of the way.",
				"MELEE TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "An enemy hitting you high will do the same damage as them hitting you low.",
				"MELEE TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		}
	
	public static void magicTutorial()
		{
		ImageIcon icon = new ImageIcon(("magic.jpg"));
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, "Magic is a very powerful tool.",
				"MAGIC TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "There are three types of magic: fire, air, water.",
				"MAGIC TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "Fire spells cast fireballs at the enemy.",
				"MAGIC TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "Unlike melee attacks, magic cannot be blocked by enemies.",
				"MAGIC TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "But fireballs do less damage than melee attacks.",
				"MAGIC TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "Water spells heal yourself.",
				"MAGIC TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "Earth spells harden your skin giving you natural armor.",
				"MAGIC TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "Warning: you need to have at least one level in magic to use it.",
				"MAGIC TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		}
	
	public static void alchemyTutorial()
		{
		ImageIcon icon = new ImageIcon(("alchemytut.jpg"));
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, "Throughout Yedrin there are many types of interesting plants with facinating properties.",
				"ALCHEMY TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "If you combine those plants/herbs in a cauldron they will make a potion.",
				"ALCHEMY TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "The recipies are the same every time. There are multiple combinations for every type of potion.",
				"ALCHEMY TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "Potions can have powerful effects but they take an entire turn in combat to drink, so be careful.",
				"ALCHEMY TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		}
	
	public static void skillTutorial()
		{
		ImageIcon icon = new ImageIcon(("levelup.jpg"));
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, "As you explore the world of Yedrin you will get lots of opportunities to increase your skill.",
				"SKILL TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "When those opportunities arrive then you have three skills to choose from.",
				"SKILL TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "Magic, Agility, or Strength.",
				"SKILL TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "Magic makes your spells stronger.",
				"SKILL TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "Agility makes you better at avoiding traps, picking locks, and dodging attacks.",
				"SKILL TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "Strength makes you do more damage with melee attacks and gain more help when you level up.",
				"SKILL TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "Every so often the sign of the Wayfarer will reveal itself to you, and grant you a power.",
				"SKILL TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "Choose wisely.",
				"SKILL TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		}
           
	public static void stubsTutorial()
		{
		ImageIcon icon = new ImageIcon(("dice.png"));
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, "Stubs is a simple dice game commonly played in the world of Yedrin.",
				"STUBS TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "The goal of the game is to get 100 points before your opponent.",
				"STUBS TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "Each player takes turns rolling two dice.",
				"STUBS TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "If both of the dice are not ones, then you get points.  You then have an option to roll again.",
				"STUBS TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "But if one of the dice is a one when you reroll then you lose those points.",
				"STUBS TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		JOptionPane.showMessageDialog(frame, "If you decide to keep your points then however many you got are added to your total.",
				"STUBS TUTORIAL",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		}
	}
