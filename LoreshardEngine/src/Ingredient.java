import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Ingredient extends Item
	{
	private int herbValue;
	
	public Ingredient(String in, int v, int hv)
		{
		setItemName(in);
		setValue(v);
		herbValue = hv;
		}
	
	public static void brew()
		{
		int brewTotal = 0;
		Potion createdPotion = Potion.potions.get(0);
		ImageIcon icon = new ImageIcon(("cauldron.jpg"));
		JFrame frame = new JFrame();
		
		JOptionPane.showMessageDialog(frame, "You have found a cauldron to brew potions in!",
				"BREW",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		
		Object[] choose = {"Brew", "Leave"};
		int choice = JOptionPane.showOptionDialog(frame, "Do you want to brew a potion?",
				"BREW",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				icon, choose, choose[0]);
		
		switch(choice)
			{
			case 0:
				{
				if(Hero.alchemyBag.size() < 2)
					{
					JOptionPane.showMessageDialog(frame, "Unfortunately you don't have enough ingredients.",
							"BREW",
							JOptionPane.QUESTION_MESSAGE,
							icon);
					}
				
				else
					{
					for(int i = 0; i < 2; i++)
						{
						Object [] fred = new Object[Hero.alchemyBag.size()];
						for(int b = 0; b < Hero.alchemyBag.size(); b++)
							{
							fred [b] = Hero.alchemyBag.get(b).getItemName();
							}
						int ingredientChoice = JOptionPane.showOptionDialog(frame, "Which ingredient would you like to use?",
								"BREW",
								JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE,
								null, fred, fred[0]);

						brewTotal = brewTotal + Hero.alchemyBag.get(ingredientChoice).getHerbValue();
						Hero.alchemyBag.remove(ingredientChoice);
						}
					
					for(int i = 0; i < Potion.potions.size(); i++)
						{
						if(Potion.potions.get(i).getPotionID() == brewTotal)
							{
							createdPotion = Potion.potions.get(i);
							i = Potion.potions.size();
							}
						}
							
					JOptionPane.showMessageDialog(frame, "You have brewed: " + createdPotion.getItemName() + "!",
							"BREW",
							JOptionPane.QUESTION_MESSAGE,
							icon);
					
					Object[] potionType = {Hero.heroInventory.get(3).getItemName(), createdPotion.getItemName()};
					int PotionChoice = JOptionPane.showOptionDialog(frame, "Which potion would you like to keep?",
							"BREW",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null, potionType, potionType[1]);
					switch(PotionChoice)
						{
						case 0:
							{
							break;
							}
						case 1:
							{
							Hero.heroInventory.set(3, createdPotion);
							break;
							}
						}
					}
				}
			case 1:
				{
				JOptionPane.showMessageDialog(frame, "You leave the cauldron and continue along the path.",
						"BREW",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				}
			}
		
		
		}

	public int getHerbValue()
		{
		return herbValue;
		}

	public void setHerbValue(int herbValue)
		{
		this.herbValue = herbValue;
		}
	
	
	}
