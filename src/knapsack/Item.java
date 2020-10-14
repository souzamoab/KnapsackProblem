package knapsack;

public class Item {
	
	public String label;
	public int weight;
	public int value;
	
	public Item(String label, int weight, int value) {
		super();
		this.label = label;
		this.weight = weight;
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public int getWeight() {
		return weight;
	}

	public int getValue() {
		return value;
	}
	
}
