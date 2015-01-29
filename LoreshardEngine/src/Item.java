import java.util.*;

public abstract class Item
	{
	private int value;
	private String itemName;
	private boolean isEquipped = false;
	private String itemType;
	
	static ArrayList <Item> items = new ArrayList<Item>();
	
	public int getDamage()
		{
		return 0;
		}
	
	public String getItemType()
		{
		return itemType;
		}
	
	public void setItemType(String itemType)
		{
		this.itemType = itemType;
		}
	
	public boolean getIsEquipped()
		{
		return isEquipped;
		}
	
	public void setIsEquipped(boolean isEquipped)
		{
		this.isEquipped = isEquipped;
		}
	
	public int getValue()
		{
		return value;
		}
	
	public void setValue(int value)
		{
		this.value = value;
		}
	
	public String getItemName()
		{
		return itemName;
		}
	
	public void setItemName(String itemName)
		{
		this.itemName = itemName;
		}
	}
