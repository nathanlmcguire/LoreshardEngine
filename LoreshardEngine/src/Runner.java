import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Runner
	{	
	public static void main(String[] args)
		{
		
		//WEAPONS
			Item.items.add(new Sword("Iron Sword", 30, 6, false));
			Item.items.add(new Sword("Steel Sword", 50, 8, false));
			Item.items.add(new Sword("Platinum Sword", 100, 13, false));
			Item.items.add(new Dagger("Iron Dagger", 10, 5, false));
			Item.items.add(new Dagger("Steel Dagger", 20, 6, false));
			Item.items.add(new Dagger("Platinum Dagger", 40, 8, false));
			Item.items.add(new Bow("Hunting Bow", 40, 8, false));
			Item.items.add(new Bow("Recurve Bow", 60, 9, false));
			Item.items.add(new Bow("Long Bow", 90, 10, false));
		//ARMOR
			Item.items.add(new LightArmor("Leather Armor", 20, "Light", 7, false));
			Item.items.add(new LightArmor("Chain Armor", 40, "Light", 8, false));
			Item.items.add(new LightArmor("Mithril Armor", 140, "Light", 12, false));
			Item.items.add(new HeavyArmor("Iron Armor", 60, "Heavy", 9, false));
			Item.items.add(new HeavyArmor("Steel Armor", 100, "Heavy", 11, false));
			Item.items.add(new HeavyArmor("Platinum Armor", 140, "Heavy", 15, false));
		//SPECIAL ITEMS
			Item.items.add(new SpecialItem("Keystone", 10, 1));
			Item.items.add(new SpecialItem("Bag of Gold", 10, 1));
			Item.items.add(new SpecialItem("Lockpicks", 10, 5));
			Item.items.add(new SpecialItem("Bomb", 10, 1));
			Item.items.add(new SpecialItem("Keystone", 10, 1));
			Item.items.add(new SpecialItem("Bag of Gold", 10, 1));
			Item.items.add(new SpecialItem("Lockpicks", 10, 5));
			Item.items.add(new SpecialItem("Bomb", 10, 1));
			Item.items.add(new SpecialItem("Keystone", 10, 1));
			Item.items.add(new SpecialItem("Bag of Gold", 10, 1));
			Item.items.add(new SpecialItem("Lockpicks", 10, 5));
			Item.items.add(new SpecialItem("Bomb", 10, 1));
			Item.items.add(new SpecialItem("Ward Shard", 10, 1));
			Item.items.add(new SpecialItem("Lore Shard", 10, 1));
		//CREATURES
			Monster.monsters.add(new Monster("Warg", 20, false, "Arena", 14));
			Monster.monsters.add(new Monster("Goblin", 18, false, "Arena", 12));
			Monster.monsters.add(new Monster("Goblin", 18, false, "Arena", 12));
			Monster.monsters.add(new Monster("Wolf", 18, false, "Arena", 11));
			Monster.monsters.add(new Monster("Minotaur", 73, false, "Arena", 20));
			Monster.monsters.add(new Monster("Troll", 31, false, "Arena", 16));
			Monster.monsters.add(new Monster("Kobold", 6, false, "Arena", 7));
			Monster.monsters.add(new Monster("Kobold", 6, false, "Arena", 7));
			Monster.monsters.add(new Monster("Kobold", 6, false, "Arena", 7));
			Monster.monsters.add(new Monster("Giant Spider", 28, false, "Arena", 16));
			Monster.monsters.add(new Monster("Giant Snake", 35, false, "Arena", 12));
			Monster.monsters.add(new Monster("Orc", 18, false, "Arena", 14));
			Monster.monsters.add(new Monster("Orc", 18, false, "Arena", 14));
			
			Monster.monsters.add(new Monster("Dragon", 200, true, "Arena", 70));
			Monster.monsters.add(new Monster("Kracken", 400, true, "Arena", 50));
			Monster.monsters.add(new Monster("Basilisk", 250, true, "Arena", 70));
			Monster.monsters.add(new Monster("Hydra", 300, true, "Arena", 70));
			Monster.monsters.add(new Monster("Chimera", 200, true, "Arena", 70));
			Monster.monsters.add(new Monster("Necromancer", 200, true, "Arena", 70));
			Monster.monsters.add(new Monster("Warlord", 200, true, "Arena", 80));
		//WARDS
			//Item.items.add(new Ward("Damage Ward", 100, 20, 1)); DON'T USE
			//Item.items.add(new Ward("Instant Kill Ward", 100, 30, 2));
			//Item.items.add(new Ward("Damage Ward", 100, 20, 3)); NOT FINISHED
			Item.items.add(new Ward("Armor Ward", 100, 5, 4));
			Item.items.add(new Ward("Treasure Ward", 100, 15, 5));
			Item.items.add(new Ward("Heal Ward", 100, 18, 6));
			Item.items.add(new Ward("Adrenaline Ward", 100, 20, 7)); 
			Item.items.add(new Ward("Level Ward", 100, 25, 8));
			
		//POTIONS
			Item.items.add(new Potion("Useless Potion", 0, 100, true));
			Potion.potions.add(new Potion("Useless Potion", 0, 100, true));
			Item.items.add(new Potion("Healing Potion", 10, 1, true));
			Potion.potions.add(new Potion("Healing Potion", 10, 1, true));
			Item.items.add(new Potion("Adrenaline Potion", 40, 2, true));
			Potion.potions.add(new Potion("Adrenaline Potion", 40, 2, true));
			Item.items.add(new Potion("Strength Potion", 30, 3, true));
			Potion.potions.add(new Potion("Strength Potion", 30, 3, true));
			Item.items.add(new Potion("Agility Potion", 20, 4, true));
			Potion.potions.add(new Potion("Agility Potion", 20, 4, true));
			Item.items.add(new Potion("Weak Poison", 100, 5, true));
			Potion.potions.add(new Potion("Weak Poison", 100, 5, true));
			Item.items.add(new Potion("Strong Poison", 100, 6, true));
			Potion.potions.add(new Potion("Strong Poison", 100, 6, true));
			Item.items.add(new Potion("Potion of Accuracy", 100, 7, true));
			Potion.potions.add(new Potion("Potion of Accuracy", 100, 7, true));
			Item.items.add(new Potion("Potion of Magic", 50, 8, true));
			Potion.potions.add(new Potion("Potion of Magic", 50, 8, true));
			Item.items.add(new Potion("Potion of Luck", 30, 9, true));
			Potion.potions.add(new Potion("Potion of Luck", 30, 9, true));
			Item.items.add(new Potion("Ward Potion", 100, 10, true));
			Potion.potions.add(new Potion("Ward Potion", 100, 10, true));
			Item.items.add(new Potion("Stoneskin Potion", 50, 11, true));
			Potion.potions.add(new Potion("Stoneskin Potion", 50, 11, true));
			Item.items.add(new Potion("Mega Healing Potion", 100, 12, true));
			Potion.potions.add(new Potion("Mega Healing Potion", 100, 12, true));
			Item.items.add(new Potion("Vitality Potion", 100, 13, true));
			Potion.potions.add(new Potion("Vitality Potion", 100, 13, true));
			Item.items.add(new Potion("Charisma Potion", 30, 14, true));
			Potion.potions.add(new Potion("Charisma Potion", 30, 14, true));
			
					//INGREDIENTS
			Item.items.add(new Ingredient("Mudstock Root", 10, 0));
			Item.items.add(new Ingredient("Grigs Root", 10, -1));
			Item.items.add(new Ingredient("Pettleroot", 10, 1));
			Item.items.add(new Ingredient("Flame Cherries", 10, 2));
			Item.items.add(new Ingredient("Greenweed", 10, -2));
			Item.items.add(new Ingredient("Climber's Ivy", 10, 3));
			Item.items.add(new Ingredient("Moon Lust  Flower", 10, -3));
			Item.items.add(new Ingredient("Roofhead Mushroom", 10, 4));
			Item.items.add(new Ingredient("Blood Sap", 10, 5));
			Item.items.add(new Ingredient("Frost Grass", 10, 6));
			Item.items.add(new Ingredient("Dragon's Breath Flower", 10, 7));
			Item.items.add(new Ingredient("Dawnchild Flower", 10, 8));
			Item.items.add(new Ingredient("Nettle Leaves", 10, 9));
			Item.items.add(new Ingredient("Dust Tear Flower", 10, 2));
			Item.items.add(new Ingredient("Bronth's Fruit", 10, -1));
			Item.items.add(new Ingredient("Boom Fruit", 10, 10));
			Item.items.add(new Ingredient("Pupil Fruit", 10, 1));
			Item.items.add(new Ingredient("Tresler Pinecone", 10, 1));
			Item.items.add(new Ingredient("Traltsvar Flower Stem", 10, 2));
			Item.items.add(new Ingredient("Skillshroom", 10, 10));
		
		//HighScores.addScore("Name", 0, "SUPER COOL ENDING");
		//HighScores.printScore();
			
		ImageIcon icon = new ImageIcon(("wayfarer.jpg"));
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, "Start",
			"WAYFARER_ALPHA 1.4",
			JOptionPane.QUESTION_MESSAGE,
			icon);
		
		SetUp.offerTutorial();
		SetUp.createHero();
		SetUp.chooseStartingWeapons();
		Hero.showInventory(Hero.heroInventory.get(0).getItemName(), Hero.heroInventory.get(1).getItemName(), Hero.heroInventory.get(2).getItemName(), Hero.heroInventory.get(3).getItemName());
		while(true)
			{
			SetUp.generateSituation();
			}
		
		}
	}
