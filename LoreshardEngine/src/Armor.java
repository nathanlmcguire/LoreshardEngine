
public class Armor extends Item
	{
	private String armorType;
	private int armorLevel;
	private String itemType = "Armor";
	
	public String getItemType()
		{
		return itemType;
		}
	
	public void setItemType(String itemType)
		{
		this.itemType = itemType;
		}

	public String getArmorType()
		{
		return armorType;
		}
	
	public void setArmorType(String armorType)
		{
		this.armorType = armorType;
		}
	
	public int getArmorLevel()
		{
		return armorLevel;
		}
	
	public void setArmorLevel(int armorLevel)
		{
		this.armorLevel = armorLevel;
		}
	}
