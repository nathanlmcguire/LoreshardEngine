import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Runner
	{	
	public static void main(String[] args)
		{
		
		//WEAPONS
			Item.items.add(new Sword("Iron Sword", 30, 4, false));
			Item.items.add(new Sword("Steel Sword", 50, 6, false));
			Item.items.add(new Sword("Platinum Sword", 100, 10, false));
			Item.items.add(new Dagger("Iron Dagger", 10, 3, false));
			Item.items.add(new Dagger("Steel Dagger", 20, 4, false));
			Item.items.add(new Dagger("Platinum Dagger", 40, 6, false));
			Item.items.add(new Bow("Hunting Bow", 40, 5, false));
			Item.items.add(new Bow("Recurve Bow", 60, 6, false));
			Item.items.add(new Bow("Long Bow", 90, 7, false));
		//ARMOR
			Item.items.add(new LightArmor("Leather Armor", 20, "Light", 3, false));
			Item.items.add(new LightArmor("Chain Armor", 40, "Light", 4, false));
			Item.items.add(new LightArmor("Mithril Armor", 140, "Light", 8, false));
			Item.items.add(new HeavyArmor("Iron Armor", 60, "Heavy", 5, false));
			Item.items.add(new HeavyArmor("Steel Armor", 100, "Heavy", 7, false));
			Item.items.add(new HeavyArmor("Platinum Armor", 140, "Heavy", 10, false));
		//CREATURES
			Monster.monsters.add(new Monster("Warg", 17, false, "Arena", 12));
			Monster.monsters.add(new Monster("Goblin", 15, false, "Arena", 10));
			Monster.monsters.add(new Monster("Goblin", 15, false, "Arena", 10));
			Monster.monsters.add(new Monster("Goblin", 15, false, "Arena", 10));
			Monster.monsters.add(new Monster("Wolf", 15, false, "Arena", 9));
			Monster.monsters.add(new Monster("Minotaur", 70, false, "Arena", 20));
			Monster.monsters.add(new Monster("Troll", 28, false, "Arena", 14));
			Monster.monsters.add(new Monster("Kobold", 3, false, "Arena", 5));
			Monster.monsters.add(new Monster("Kobold", 3, false, "Arena", 5));
			Monster.monsters.add(new Monster("Kobold", 3, false, "Arena", 5));
			Monster.monsters.add(new Monster("Kobold", 3, false, "Arena", 5));
			Monster.monsters.add(new Monster("Giant Spider", 25, false, "Arena", 14));
			Monster.monsters.add(new Monster("Giant Snake", 32, false, "Arena", 10));
			Monster.monsters.add(new Monster("Orc", 15, false, "Arena", 12));
			Monster.monsters.add(new Monster("Dragon", 100, true, "Arena", 25));
		//WARDS
			//Item.items.add(new Ward("Damage Ward", 100, 20, 1)); DON'T USE
			Item.items.add(new Ward("Instant Kill Ward", 100, 10, 2));
			//Item.items.add(new Ward("Damage Ward", 100, 20, 3)); NOT FINISHED
			//Item.items.add(new Ward("Armor Ward", 100, 20, 4)); NOT FINISHED
			Item.items.add(new Ward("Treasure Ward", 100, 10, 5));
			Item.items.add(new Ward("Heal Ward", 100, 10, 6));
			//Item.items.add(new Ward("Adrenaline Ward", 100, 20, 7)); NOT FINISHED
			Item.items.add(new Ward("Level Ward", 100, 10, 8));
			
		//POTIONS
			Item.items.add(new Potion("Useless Potion", 0, 100, true));
			Potion.potions.add(new Potion("Useless Potion", 0, 100, true));
			Item.items.add(new Potion("Healing Potion", 10, 1, true));
			Potion.potions.add(new Potion("Healing Potion", 10, 1, true));
			//Item.items.add(new Potion("Adrenaline Potion", 40, 2));
			//Potion.potions.add(new Potion("Adrenaline Potion", 40, 2));
			Item.items.add(new Potion("Strength Potion", 30, 3, true));
			Potion.potions.add(new Potion("Strength Potion", 30, 3, true));
			//Item.items.add(new Potion("Agility Potion", 20, 4));
			//Potion.potions.add(new Potion("Agility Potion", 20, 4));
			//Item.items.add(new Potion("Charisma Potion", 30, 5));
			//Potion.potions.add(new Potion("Charisma Potion", 30, 5));
			Item.items.add(new Potion("Potion of Magic", 50, 6, true));
			Potion.potions.add(new Potion("Potion of Magic", 50, 6, true));
			Item.items.add(new Potion("Ward Potion", 100, 7, true));
			Potion.potions.add(new Potion("Ward Potion", 100, 7, true));
			Item.items.add(new Potion("Mega Healing Potion", 100, 8, true));
			Potion.potions.add(new Potion("Mega Healing Potion", 100, 8, true));
		//INGREDIENTS
			Item.items.add(new Ingredient("Mudstock", 10, 0));
			Item.items.add(new Ingredient("Grigs", 10, -1));
			Item.items.add(new Ingredient("Pettleroot", 10, 1));
			Item.items.add(new Ingredient("Flame Cherries", 10, 3));
			Item.items.add(new Ingredient("Greenweed", 10, -2));
			Item.items.add(new Ingredient("Climber's Ivy", 10, 4));
			Item.items.add(new Ingredient("Moon Lust", 10, 4));
			Item.items.add(new Ingredient("Roofhead", 10, 1));
			Item.items.add(new Ingredient("Blood Sap", 10, -3));
			Item.items.add(new Ingredient("Frost Grass", 10, 2));
			Item.items.add(new Ingredient("Dragon's Breath", 10, 3));
			Item.items.add(new Ingredient("Dawnchild", 10, 5));
		
		ImageIcon icon = new ImageIcon(("scroll.jpg"));
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, "Start?",
			"LORESHARD 2 ALPHA",
			JOptionPane.QUESTION_MESSAGE,
			icon);
		
		SetUp.createHero();
		Hero.showInventory(Hero.heroInventory.get(0).getItemName(), Hero.heroInventory.get(1).getItemName(), Hero.heroInventory.get(2).getItemName(), Hero.heroInventory.get(3).getItemName());
		while(true)
			{
			SetUp.generateSituation();
			}
		
		}
	}
