import java.util.ArrayList;


public class SpecialItem extends Item
	{
	private int quantity;
	
	public SpecialItem(String in, int v, int q)
		{
		setItemName(in);
		setValue(v);
		quantity = q;
		}

	public int getQuantity() 
		{
		return quantity;
		}

	public void setQuantity(int quantity)
		{
		this.quantity = quantity;
		}
	}
