import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Runner
	{
	public static void main(String[] args)
		{
		//WEAPONS
		Item.items.add(new Sword("Iron Sword", 30, 3, false, "Weapon"));
		Item.items.add(new Sword("Steel Sword", 50, 5, false, "Weapon"));
		Item.items.add(new Sword("Platinum Sword", 100, 10, false, "Weapon"));
//		Item.items.add(new Dagger("Iron Dagger", 10, 1, false));
//		Item.items.add(new Dagger("Steel Dagger", 20, 2, false));
//		Item.items.add(new Dagger("Platinum Dagger", 40, 4, false));
//		Item.items.add(new Bow("Hunting Bow", 40, 4, false));
//		Item.items.add(new Bow("Recurve Bow", 60, 6, false));
//		Item.items.add(new Bow("Long Bow", 90, 9, false));
		//ARMOR
//		Item.items.add(new LightArmor("Leather Armor", 20, "Light", 5, false));
//		Item.items.add(new LightArmor("Chain Armor", 40, "Light", 10, false));
//		Item.items.add(new LightArmor("Mithril Armor", 140, "Light", 50, false));
		Item.items.add(new HeavyArmor("Iron Armor", 60, "Heavy", 30, false, "Armor"));
		Item.items.add(new HeavyArmor("Steel Armor", 100, "Heavy", 50, false, "Armor"));
		Item.items.add(new HeavyArmor("Platinum Armor", 140, "Heavy", 70, false, "Armor"));
		//CREATURES
		Monster.monsters.add(new Monster("Warg", 12, false, "Arena", 4));
		Monster.monsters.add(new Monster("Goblin", 10, false, "Arena", 5));
		Monster.monsters.add(new Monster("Wolf", 5, false, "Arena", 3));
		Monster.monsters.add(new Monster("Minotaur", 50, false, "Arena", 10));
		Monster.monsters.add(new Monster("Troll", 20, false, "Arena", 7));
		
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, "Start game?",
			"CHARACTER CREATION",
			JOptionPane.QUESTION_MESSAGE);
		
		

		SetUp.createHero();
		while(true)
			{
			Hero.chooseAttack(Monster.randomize());
			}
		
		}
	}
