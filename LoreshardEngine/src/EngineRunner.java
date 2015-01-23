
public class EngineRunner
	{
	public static void main(String[] args)
		{
		//WEAPONS
		Item.items.add(new IronSword("Iron Sword", 30, 3));
		Item.items.add(new IronDagger("Iron Dagger", 10, 1));
		Item.items.add(new HuntingBow("Hunting Bow", 30, 4));
		//ARMOR
		Item.items.add(new LeatherArmor("Leather Armor", 40, "Light", 1));
		Item.items.add(new IronArmor("Iron Armor", 60, "Heavy", 3));
		//CREATURES
		Hero player = new Hero("Player", 20, 0, 0, 0, 0, 0, 0, 0, "Alpha Tester");
		Monster.monsters.add(new Monster("Tharg", 10, false, "Arena", 3));
		}
	}
