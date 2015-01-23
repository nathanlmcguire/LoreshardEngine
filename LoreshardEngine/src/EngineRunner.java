import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class EngineRunner
	{
	public static void main(String[] args)
		{
		//WEAPONS
		Item.items.add(new Sword("Iron Sword", 30, 3));
		Item.items.add(new Sword("Steel Sword", 50, 5));
		Item.items.add(new Sword("Platinum Sword", 100, 10));
		Item.items.add(new Dagger("Iron Dagger", 10, 1));
		Item.items.add(new Dagger("Steel Dagger", 20, 2));
		Item.items.add(new Dagger("Platinum Dagger", 40, 4));
		Item.items.add(new Bow("Hunting Bow", 40, 4));
		Item.items.add(new Bow("Recurve Bow", 60, 6));
		Item.items.add(new Bow("Long Bow", 90, 9));
		//ARMOR
		Item.items.add(new LightArmor("Leather Armor", 20, "Light", 5));
		Item.items.add(new LightArmor("Chain Armor", 40, "Light", 10));
		Item.items.add(new LightArmor("Mithril Armor", 140, "Light", 50));
		Item.items.add(new HeavyArmor("Iron Armor", 60, "Heavy", 30));
		Item.items.add(new HeavyArmor("Steel Armor", 100, "Heavy", 50));
		Item.items.add(new HeavyArmor("Platinum Armor", 140, "Heavy", 70));
		//CREATURES
		Monster.monsters.add(new Monster("Tharg", 10, false, "Arena", 3));
		
		JFrame frame = new JFrame();
		Object[] testTwo = {"OK"};
		JOptionPane.showOptionDialog(frame, "Start game.",
				"Test",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, testTwo, testTwo[0]);
		
		Hero player = new Hero("Player", 20, 0, 0, 0, 0, 0, 0, "Alpha Tester");
		
		Hero.chooseAttack();
		}
	}
