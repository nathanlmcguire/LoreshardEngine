import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Character
	{
	public void generateCharacter()
		{
		ImageIcon icon = new ImageIcon(("steps.png"));
		int ran = (int) (Math.random() * 4);
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, "While walking down the dark corridors of the dungeon you spot a hunched figure.",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		switch(ran)
			{
			case 0:
				{
				trainer();
				break;
				}
			case 1:
				{
				peddler();	
				break;
				}
			case 2:
				{
				merchant();	
				break;
				}
			case 3:
				{
				riddler();	
				break;
				}
			}
		}
	
	public void trainer()
		{
		
		}
	
	public void peddler()
		{
		
		}
	
	public void merchant()
		{
		
		}
	
	public void riddler()
		{
		
		}
	

	}
