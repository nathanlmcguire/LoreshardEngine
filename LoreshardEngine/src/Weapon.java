
public class Weapon extends Item
	{
	private int damage;
	private String itemType = "Weapon";
	
	public String getItemType()
		{
		return itemType;
		}
	
	public void setItemType(String itemType)
		{
		this.itemType = itemType;
		}
	
	public int getDamage()
		{
		return damage;
		}
	
	public void setDamage(int damage)
		{
		this.damage = damage;
		}
	}
